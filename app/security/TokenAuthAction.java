package security;


import Constants.StatusCode;
import Constants.UserLoginStatus;
import models.security.Token;
import models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import play.libs.F;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Http.Context;
import play.mvc.Result;
import repositories.TokenRepository;
import services.interfaces.UserService;

import javax.inject.Named;

@Named
public class TokenAuthAction extends Action.Simple
{
	public final static String AUTH_TOKEN_HEADER = "X-AUTH-TOKEN";
	public static final String AUTH_TOKEN        = "authToken";


	public TokenRepository tokenRepository;
	public UserService userService;

	@Autowired
	public TokenAuthAction( UserService userService, TokenRepository tokenRepository )
	{
		this.tokenRepository = tokenRepository;
		this.userService = userService;
	}

	public static User getUser()
	{
		return ( User ) Http.Context.current().args.get( "user" );
	}

	@Override
	public Promise< Result > call( Context ctx ) throws Throwable
	{
		User user = null;
		Token token = null;
		String[] authTokenHeaderValues = ctx.request().headers().get(AUTH_TOKEN_HEADER);

        if ((authTokenHeaderValues != null) && (authTokenHeaderValues.length == 1) && (authTokenHeaderValues[0] != null))
        {

            //user = models.user.User.findByAuthToken(authTokenHeaderValues[0]);
            token = tokenRepository.findUserByAuthToken(authTokenHeaderValues[0]);
            if (token != null)
            {
	            token = userService.checkIfExpired( token );
                UserLoginStatus status = token.status;
                if (status == UserLoginStatus.ACTIVE)
                {
                    user = token.user;

                    if (user != null)
                    {
                        ctx.args.put("user", user);
                        return delegate.call(ctx);
                    }
                }
                else
                {
                    return F.Promise.pure((Result) status(StatusCode.TOKEN_EXPIRED, "Token expired"));
                }

            }else
            {
                return F.Promise.pure((Result) unauthorized(".|."));
            }

        }

        return F.Promise.pure((Result) unauthorized());
    }
}