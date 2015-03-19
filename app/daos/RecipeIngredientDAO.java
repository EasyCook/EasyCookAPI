package daos;

import models.recipes.RecipeIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import repositories.RecipeIngredientRepository;

import javax.inject.Named;
import java.util.List;

/**
 * Created by eduardo on 12/03/15.
 */
@Named
@Transactional
public class RecipeIngredientDAO extends AbstractDAO<RecipeIngredient,Long>
{
	RecipeIngredientRepository recipeIngredientRepository;

	@Autowired
	public RecipeIngredientDAO(RecipeIngredientRepository recipeIngredientRepository)
	{
		super(recipeIngredientRepository);
		this.recipeIngredientRepository = recipeIngredientRepository;
	}



}
