package controllers;

import controllers.base.BaseCrudController;
import models.recipes.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import services.interfaces.IngredientService;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 12/03/15.
 */
@Named
@Singleton
public class IngredientController extends BaseCrudController<Ingredient>
{
	IngredientService ingredientDAO;

	@Autowired
	public IngredientController( IngredientService ingredienService )
	{
		super( ingredienService);
		this.ingredientDAO = ingredienService;
	}
}
