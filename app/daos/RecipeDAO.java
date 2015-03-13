package daos;

import models.recipes.Category;
import models.recipes.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import repositories.RecipeRepository;

import java.util.List;

/**
 * Created by eduardo on 12/03/15.
 */
public class RecipeDAO extends AbstractDAO<Recipe,Long>
{
	RecipeRepository recipeRepository;

	@Autowired
	public RecipeDAO( JpaRepository< Recipe, Long > repo, RecipeRepository recipeRepository)
	{
		super( repo );
		this.recipeRepository = recipeRepository;
	}

	public List<Category> getCategories(Long id)
	{
		return recipeRepository.getCategories( id );
	}

}
