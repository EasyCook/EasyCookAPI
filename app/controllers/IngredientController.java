package controllers;

import daos.AbstractDAO;
import daos.IngredientDAO;
import models.recipes.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 12/03/15.
 */
@Named
@Singleton
public class IngredientController extends BaseCrudController<Ingredient>
{
	IngredientDAO ingredientDAO;

	@Autowired
	public IngredientController(IngredientDAO ingredientDAO)
	{
		super( ingredientDAO, Ingredient.class );
		this.ingredientDAO = ingredientDAO;
	}
}
