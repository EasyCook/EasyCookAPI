package controllers.base;

import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.exception.ConstraintViolationException;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import services.exceptions.NotFoundException;
import services.base.GenericService;

import javax.persistence.PersistenceException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static Constants.StatusCode.COULT_NOT_DELETE;
import static Constants.StatusCode.COULT_NOT_UPDATE;
import static play.libs.Json.fromJson;
import static play.libs.Json.toJson;

/**
 * Created by eduardo on 12/03/15.
 */

public abstract class BaseCrudController < T > extends Controller
{

	protected GenericService< T, Long > service;
	private Class< T >                 clazz;
    private Class< ? >                 updateClazz;

	public BaseCrudController( GenericService< T, Long > service )
	{
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        clazz = (Class) pt.getActualTypeArguments()[0];
		this.service = service;
        setUpdateClass(clazz);

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
		Form< ? > form = Form.form( getUpdateClass() ).bindFromRequest();
		if( form.hasErrors() )
		{
			return badRequest();
		}

		Object object = form.get();

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
		try
		{
			service.delete( id );
		}
		catch( Exception e )

		{
			return status( COULT_NOT_DELETE, "Could not delete" );
		}

		return ok();
	}

	public void objectMapper( Object src, Object target )
	{
		service.copyProperties(src, target);
	}


    public void setUpdateClass(Class<?> clazz)
    {
        this.updateClazz = clazz;
    }

    public Class<?> getUpdateClass()
    {
        return this.updateClazz;
    }
}
