package services;

import models.recipes.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.IngredientRepository;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 12/03/15.
 */
@Named
@Singleton
public class IngredientService extends AbstractService<Ingredient,Long>
{
	IngredientRepository ingredientRepository;

	@Autowired
	public IngredientService( IngredientRepository ingredientRepository )
	{
		super( ingredientRepository );
		this.ingredientRepository = ingredientRepository;
	}
}
