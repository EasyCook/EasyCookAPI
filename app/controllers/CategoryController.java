package controllers;

import daos.CategoryDAO;
import daos.NotFoundException;
import models.recipes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Named;
import javax.inject.Singleton;

import static Constants.StatusCode.COULT_NOT_UPDATE;
import static play.libs.Json.toJson;


/**
 * Created by eduardo on 11/03/15.
 */
@Named
@Singleton
public class CategoryController extends BaseCrudController<Category>
{
	CategoryDAO categoryDAO;

	@Autowired
	public CategoryController( CategoryDAO categoryDAO )
	{
		super(categoryDAO,Category.class);
		this.categoryDAO = categoryDAO;
	}

	public Result getCategoryBySlug( String slug )
	{
		Category category ;
		category = categoryDAO.findBySlug( slug );
		return ok( toJson( category ) );
	}


}
