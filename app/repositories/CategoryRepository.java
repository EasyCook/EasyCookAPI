package repositories;

import models.recipes.Category;
import models.recipes.Recipe;
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
public interface CategoryRepository extends JpaRepository< Category, Long >
{
	Category findBySlug( String slug );

	@Query("select c.recipe from RecipeCategory c where c.category.id = ?1")
	List<Recipe> getRecipes(Long id);
}
