package repositories;

import models.recipes.RecipeStep;
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
public interface RecipeStepRepository extends JpaRepository<RecipeStep,Long> {

    @Query("select s from RecipeStep s where s.recipe.id = ?1")
    public List<RecipeStep> findByRecipeId(Long Id);
}
