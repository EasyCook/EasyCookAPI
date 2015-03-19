package controllers;

import daos.IngredientDAO;
import daos.RecipeDAO;
import daos.RecipeIngredientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 18/03/15.
 */
@Named
@Singleton
public class RecipeIndredientController extends Controller
{
	RecipeIngredientDAO recipeIngredientDAO;

	@Autowired
	public RecipeIndredientController( RecipeIngredientDAO recipeIngredientDAO)
	{
		this.recipeIngredientDAO = recipeIngredientDAO;
	}

	public Result create(Integer recipeId, Integer ingredientId)
	{
		return ok();
	}
}
