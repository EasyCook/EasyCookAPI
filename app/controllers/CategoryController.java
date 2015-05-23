package controllers;

import controllers.base.BaseCrudController;
import models.recipes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import play.mvc.Result;
import services.interfaces.CategoryService;

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
	CategoryService categoryService;

	@Autowired
	public CategoryController( CategoryService categoryService)
	{
		super(categoryService);
		this.categoryService = categoryService;
	}

	public Result getCategoryBySlug( String slug )
	{
		Category category;
		category = categoryService.findBySlug( slug );
		return ok( toJson( category ) );
	}


}
