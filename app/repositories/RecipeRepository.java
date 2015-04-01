package repositories;

import models.recipes.Category;
import models.recipes.Ingredient;
import models.recipes.Recipe;
import models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by eduardo on 10/03/15.
 */
@Named
@Singleton
public interface RecipeRepository extends JpaRepository<Recipe,Long> {




}
