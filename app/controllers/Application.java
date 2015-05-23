package controllers;

import services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import play.mvc.*;

import javax.inject.Named;

@Named
public class Application extends Controller
{







	public Result checkPreFlight( String path )
	{
		response().setHeader( "Access-Control-Allow-Origin", "*" );
		response().setHeader("Access-Control-Allow-Methods", "POST,PUT");
        response().setHeader("Access-Control-Allow-Headers",
                "accept, origin, Content-type, x-json, x-prototype-version, x-requested-with, X-AUTH-TOKEN,useXDomain");
        return ok();
    }

    public Result index ()
    {
        return ok(views.html.index.render("TEST"));
    }


}
