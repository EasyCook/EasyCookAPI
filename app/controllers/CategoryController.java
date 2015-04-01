package controllers;

import services.CategoryService;
import models.recipes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import play.mvc.Result;

import javax.inject.Named;
import javax.inject.Singleton;

import static play.libs.Json.toJson;


/**
 * Created by eduardo on 11/03/15.
 */
@Named
@Singleton
public class CategoryController extends BaseCrudController<Category>
{
	CategoryService categoryDAO;

	@Autowired
	public CategoryController( CategoryService categoryDAO )
	{
		super( categoryDAO, Category.class );
		this.categoryDAO = categoryDAO;
	}

	public Result getCategoryBySlug( String slug )
	{
		Category category;
		category = categoryDAO.findBySlug( slug );
		return ok( toJson( category ) );
	}


}
