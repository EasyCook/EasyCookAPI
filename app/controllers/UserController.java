package controllers;

import controllers.base.BaseCrudController;
import dtos.UserDTO;
import models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import security.TokenAuth;
import services.interfaces.UserService;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
@TokenAuth
public class UserController extends BaseCrudController<User>
{


	UserService userService;


	@Autowired
	public UserController( UserService userService )
	{
        super(userService);
		this.userService = userService;
        setUpdateClass(UserDTO.class);
	}



}
