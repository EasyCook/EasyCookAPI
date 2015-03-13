package repositories;

import models.recipes.RecipeStep;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by eduardo on 11/03/15.
 */
public interface RecipeStepRepository extends JpaRepository<RecipeStep,Long> {
}
