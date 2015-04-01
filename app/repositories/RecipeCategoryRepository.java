package repositories;

import models.recipes.Category;
import models.recipes.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by eduardo on 19/03/15.
 */
@Named
@Singleton
public interface RecipeCategoryRepository extends JpaRepository< RecipeCategory,Long >
{
	@Query("select c.category from RecipeCategory c where c.recipe.id =?1 ")
	public List<Category> getCategoryByRecipeId(Long id);



}
