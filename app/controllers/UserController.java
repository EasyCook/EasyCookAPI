package controllers;

import daos.NotFoundException;
import daos.UserDAO;
import dtos.UserDTO;
import models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import security.TokenAuth;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

import static Constants.StatusCode.COULT_NOT_DELETE;
import static Constants.StatusCode.COULT_NOT_UPDATE;
import static play.libs.Json.toJson;

@Named
@Singleton
@TokenAuth
public class UserController extends Controller
{


	UserDAO userDAO;


	@Autowired
	public UserController( UserDAO userDAO )
	{
		this.userDAO = userDAO;
	}

	public Result getAllUsers()
	{
		List< User > users = userDAO.findAll();
		return ok( toJson( users ) );
	}

	public Result getUser( Long userId )
	{
		User user = userDAO.findById( userId );
		return ok( toJson( user ) );
	}

	public Result updateUser( Long userId )
	{
		Form< UserDTO > updateData = Form.form( UserDTO.class ).bindFromRequest();

		if( updateData.hasErrors() )
		{
			return badRequest( updateData.errorsAsJson() );
		}

		UserDTO userDTO = updateData.get();

		User user;

		try
		{
			user = userDAO.update(userId, userDTO );
		}
		catch( NotFoundException e )
		{
			return status( COULT_NOT_UPDATE, "Could not update user" );
		}

		return ok( toJson( user ) );
	}

	public Result deleteUser( Long userId )
	{
		try
		{
			userDAO.delete( userId );
		}
		catch( NotFoundException e )
		{
			return status( COULT_NOT_DELETE, "Could not delete user" );
		}

		return ok();
	}


}
