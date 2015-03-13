package repositories;

import models.recipes.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by eduardo on 11/03/15.
 */
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
}
