package services;

import models.recipes.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.IngredientRepository;
import services.base.AbstractService;
import services.interfaces.IngredientService;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 12/03/15.
 */
@Named
@Singleton
public class IngredientServiceImpl extends AbstractService<Ingredient,Long> implements IngredientService
{
	IngredientRepository ingredientRepository;

	@Autowired
	public IngredientServiceImpl (IngredientRepository ingredientRepository)
	{
		super( ingredientRepository );
		this.ingredientRepository = ingredientRepository;
	}
}
