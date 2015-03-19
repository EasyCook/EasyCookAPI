package daos;

import dtos.CategoryDTO;
import models.recipes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.CategoryRepository;
import utils.ObjectUtils;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by eduardo on 11/03/15.
 */
@Named
@Transactional
public class CategoryDAO extends AbstractDAO<Category,Long>
{

	CategoryRepository                   categoryRepository;


	@Autowired
	public CategoryDAO( CategoryRepository categoryRepository )
	{
		super(categoryRepository);
		this.categoryRepository = categoryRepository;

	}


	//region custom methods
	public Category findBySlug( String slug )
	{
		return categoryRepository.findBySlug( slug );
	}
	//endregion
}
