package controllers;

import daos.RecipeDAO;
import dtos.RecipeDTO;
import models.recipes.Category;
import models.recipes.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import static play.libs.Json.toJson;


/**
 * Created by eduardo on 12/03/15.
 */
public class RecipeController extends Controller
{
	RecipeDAO recipeDAO;

	@Autowired
	public RecipeController( RecipeDAO recipeDAO )
	{
		this.recipeDAO = recipeDAO;
	}

	public Result getRecipe(Long id)
	{
		Recipe recipe = recipeDAO.findById( id );

		if(recipe==null)
			return notFound();

		RecipeDTO recipeDTO = new RecipeDTO();
		recipeDTO.setCalories( recipe.getCalories() );
		recipeDTO.setCookingTime( recipe.getTime() );
		recipeDTO.setDescription( recipe.getDescription() );
		recipeDTO.setDifficulty( recipe.getDifficulty() );
		recipeDTO.setId( recipe.getId() );
		recipeDTO.setIngredients( recipe.getIngredients() );
		recipeDTO.setMetric( recipe.getTimeUnit() );
		recipeDTO.setPortion( recipe.getPortion() );
		recipeDTO.setSteps( recipe.getSteps() );
		recipeDTO.setThumbnail( recipe.getThumbnail() );
		recipeDTO.setTitle( recipe.getTitle() );
		recipeDTO.setUser( recipe.getUser() );

		return ok(toJson( recipeDTO ));
	}

	public Result getRecipeCategory(Long id)
	{
		List<Category > categories = recipeDAO.getCategories( id );
		return ok(toJson(categories));
	}
}
