package daos;

import models.recipes.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import repositories.IngredientRepository;

import javax.inject.Named;

/**
 * Created by eduardo on 12/03/15.
 */
@Named
@Transactional
public class IngredientDAO extends AbstractDAO<Ingredient,Long>
{
	IngredientRepository ingredientRepository;

	@Autowired
	public IngredientDAO(  IngredientRepository ingredientRepository )
	{
		super( ingredientRepository );
		this.ingredientRepository = ingredientRepository;
	}
}
