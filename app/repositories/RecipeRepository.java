package repositories;

import models.recipes.Category;
import models.recipes.Recipe;
import models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by eduardo on 10/03/15.
 */
public interface RecipeRepository extends JpaRepository<Recipe,Long> {

	@Query("select r.category from RecipeCategory r where r.recipe.id = ?1")
	public List<Category> getCategories(Long id);
}
