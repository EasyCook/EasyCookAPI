package repositories;

import models.recipes.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by eduardo on 11/03/15.
 */
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient,Long> {
}
