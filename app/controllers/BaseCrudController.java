package controllers;

import daos.AbstractDAO;
import daos.NotFoundException;
import models.AbstractEntity;
import models.recipes.Category;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Named;
import javax.inject.Singleton;

import java.io.Serializable;

import static Constants.StatusCode.COULT_NOT_UPDATE;
import static play.libs.Json.toJson;

/**
 * Created by eduardo on 12/03/15.
 */

public abstract class BaseCrudController<T extends AbstractEntity> extends Controller
{
	private AbstractDAO<T,Long> dao;
	private Class<T> clazz;
	public BaseCrudController( AbstractDAO<T,Long> dao, Class<T> clazz)
	{
		this.clazz = clazz;
		this.dao = dao;
	}

	public Result create()
	{
		Form< T > form = Form.form( clazz ).bindFromRequest();
		if( form.hasErrors() )
		{
			return badRequest();
		}

		T category = form.get();
		dao.save( category );

		return ok( toJson( category ) );
	}

	public Result update( Long id )
	{
		Form< T > form = Form.form( clazz ).bindFromRequest();
		if( form.hasErrors() )
		{
			return badRequest();
		}

		T object = form.get();

		try
		{
			object =  dao.update( id, object );
		}
		catch( NotFoundException e )
		{
			return status( COULT_NOT_UPDATE, "Could not update" );
		}

		return ok( toJson( object ) );

	}

	public Result delete(Long id)
	{
		Form< T > form = Form.form( clazz ).bindFromRequest();
		if( form.hasErrors() )
		{
			return badRequest();
		}

		T object = form.get();

		try
		{
			dao.delete( id);
		}
		catch( NotFoundException e )
		{
			return status( COULT_NOT_UPDATE, "Could not update" );
		}

		return ok(  );
	}

	public void objectMapper(Object src, Object target){
		dao.myCopyProperties( src,target );
	}
}
