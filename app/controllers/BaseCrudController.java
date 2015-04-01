package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import services.AbstractService;
import services.NotFoundException;

import java.util.ArrayList;
import java.util.List;

import static Constants.StatusCode.COULT_NOT_UPDATE;
import static play.libs.Json.fromJson;
import static play.libs.Json.toJson;

/**
 * Created by eduardo on 12/03/15.
 */

public abstract class BaseCrudController < T > extends Controller
{

	protected AbstractService< T, Long > service;
	private Class< T >                 clazz;
	private List< T > bulkInsert = new ArrayList<>();

	public BaseCrudController( AbstractService< T, Long > service, Class< T > clazz )
	{
		this.clazz = clazz;
		this.service = service;

	}

	public Result get( Long id )
	{
		return ok( toJson( service.findById( id ) ) );
	}

	public Result getAll()
	{
		return ok( toJson( service.findAll() ) );
	}

	public Result create()
	{
		Form< T > form = Form.form( clazz ).bindFromRequest();
		if( form.hasErrors() )
		{
			return badRequest();
		}

		T object = form.get();
		service.save( object );

		return ok( toJson( object ) );
	}

	public Result createAll()
	{
		JsonNode json = request().body().asJson();
		final List<T> objects = new ArrayList<>();

		for( JsonNode jsonNode : json )
		{
			T object = fromJson( jsonNode, clazz );
			objects.add( object );
		}



		service.save( objects );

		return ok( toJson( objects ) );
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
			object = service.update( id, object );
		}
		catch( NotFoundException e )
		{
			return status( COULT_NOT_UPDATE, "Could not update" );
		}

		return ok( toJson( object ) );

	}

	public Result delete( Long id )
	{
		Form< T > form = Form.form( clazz ).bindFromRequest();
		if( form.hasErrors() )
		{
			return badRequest();
		}

		T object = form.get();

		try
		{
			service.delete( id );
		}
		catch( NotFoundException e )
		{
			return status( COULT_NOT_UPDATE, "Could not update" );
		}

		return ok();
	}

	public void objectMapper( Object src, Object target )
	{
		service.myCopyProperties( src, target );
	}


}
