package controllers;

import controllers.base.BaseCrudController;
import dtos.RecipeDTO;
import models.recipes.*;
import org.springframework.beans.factory.annotation.Autowired;
import play.data.Form;
import play.mvc.Result;
import services.interfaces.RecipeService;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

import static play.libs.Json.toJson;


/**
 * Created by eduardo on 12/03/15.
 */
@Named
@Singleton
public class RecipeController extends BaseCrudController< Recipe >
{
	RecipeService recipeService;


	@Autowired
	public RecipeController( RecipeService recipeService )
	{
		super( recipeService);
		this.recipeService = recipeService;
	}

	@Override
	public Result create()
	{

		Form< RecipeDTO > recipeDTOForm = Form.form( RecipeDTO.class ).bindFromRequest();;
		recipeDTOForm = recipeDTOForm.bindFromRequest();

		if( recipeDTOForm.hasErrors() )
		{
			return badRequest( recipeDTOForm.errorsAsJson() );
		}

		RecipeDTO recipeDTO = recipeDTOForm.get();

		Optional< Long > recipeId = recipeService.createRecipe( recipeDTO );

		if( recipeId.isPresent() )
		{
			return ok( toJson( recipeId.get() ) );
		}

		return badRequest();

	}

	public Result getRecipe( Long id )
	{
		Recipe recipe = recipeService.findById( id );

		if( recipe == null )
		{
			return notFound();
		}
        RecipeDTO recipeDTO = recipeService.getRecipeDTO(recipe);

		return ok( toJson( recipeDTO ) );
	}

    @Override
    public Result getAll()
    {
        List<Recipe> recipes = recipeService.findAll();
        List<RecipeDTO> recipeDTOs = recipeService.getRecipeDTO(recipes);
        return ok(toJson(recipeDTOs));

    }

    public Result getRecipeCategory( Long id )
	{
		List< Category > categories = recipeService.getCategories( id );
		return ok( toJson( categories ) );
	}

	public Result addCategory( Long recipeId, Long categoryId )
	{
		if( recipeService.addCategory( recipeId, categoryId ) )
		{
			return ok();
		}
		return badRequest();
	}


	public Result addIngredient( Long recipeId, Long ingredientId )
	{
		if( recipeService.addIngredient( recipeId, ingredientId ) )
		{
			return ok();
		}
		return badRequest();
	}


}
