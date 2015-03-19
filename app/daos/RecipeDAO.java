package daos;

import models.recipes.Category;
import models.recipes.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import repositories.RecipeRepository;

import javax.inject.Named;
import java.util.List;

/**
 * Created by eduardo on 12/03/15.
 */
@Named
@Transactional
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
