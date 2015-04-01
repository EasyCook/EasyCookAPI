package repositories;

import models.recipes.Ingredient;
import models.recipes.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by eduardo on 11/03/15.
 */
@Named
@Singleton
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient,Long> {
	@Query("select i.ingredient from RecipeIngredient i where i.recipe.id = ?1")
	public List<Ingredient> getRecipeIngredients(Long id);
}
