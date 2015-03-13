package controllers;

import daos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import play.*;
import play.mvc.*;

import views.html.*;

import javax.inject.Named;

@Named
public class Application extends Controller
{


    UserDAO userDAO;


    @Autowired
    public Application(UserDAO userDAO)
    {
        this.userDAO = userDAO;

    }

    public  Result checkPreFlight (String path)
    {
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST,PUT");
        response().setHeader("Access-Control-Allow-Headers",
                "accept, origin, Content-type, x-json, x-prototype-version, x-requested-with, X-AUTH-TOKEN,useXDomain");
        return ok();
    }

    public Result index ()
    {
        return ok();
    }


}
