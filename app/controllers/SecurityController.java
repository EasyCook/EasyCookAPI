package controllers;


import Constants.StatusCode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import daos.UserDAO;
import models.security.Token;
import models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import play.data.Form;
import play.data.validation.Constraints;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import security.TokenAuth;
import security.TokenAuthAction;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class SecurityController extends Controller /* extends Action.Simple */ {

    public UserDAO userDAO;


    @Autowired
    public SecurityController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Transactional
    public Result signUp() {
        Form<Login> form = Form.form(Login.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(form.errorsAsJson());
        } else {
            Login login = form.get();


            User user = userDAO.finByEmail(login.email);

            if (user != null) {
                return status(StatusCode.USER_EXISTS, "User already exists");
            }

            user = new User();
            user.setEmail(login.getEmail());
            user.setPassword(login.getPassword());
            user = userDAO.save(user);
            return ok();

        }
    }

    // returns an authToken
    @Transactional
    public Result login() {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();

        if (loginForm.hasErrors()) {
            return badRequest(loginForm.errorsAsJson());
        }

        Login login = loginForm.get();

        User user = userDAO.findByEmailAndPassword(login.getEmail(), login.getPassword());


        if (user == null) {
            return status(StatusCode.BAD_CREDENTIALS);
        } else {

            //TODO handle expired token
            ObjectNode authTokenJson = login(user);

            if (authTokenJson == null) {
                return status(StatusCode.TOKEN_EXPIRED);
            }

            return ok(authTokenJson);
        }


    }

    private ObjectNode login(User user) {
        user = userDAO.login(user);

        //handling expired token
        if (user == null) {
            return null;
        }

        Token token = userDAO.getUserToken(user);

        ObjectNode authTokenJson = Json.newObject();
        authTokenJson.put("id", user.getId());
        authTokenJson.put("name", user.firstName + " " + user.lastName);
        authTokenJson.put("role", "admin");
        authTokenJson.put(TokenAuthAction.AUTH_TOKEN, token.getAuthToken());

        response().setCookie(TokenAuthAction.AUTH_TOKEN, token.getAuthToken());

        return authTokenJson;
    }

    @Transactional
    @TokenAuth
    public Result logout() {
        response().discardCookie(TokenAuthAction.AUTH_TOKEN);
        //User user = TokenAuthAction.getUser();
        User user = userDAO.getLoggedInUser();
        userDAO.logout(user.getId());
        return ok("logged out");
    }

    public static class Login {

        @Constraints.Required
        @Constraints.Email
        public String email;

        @Constraints.Required
        public String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }


}