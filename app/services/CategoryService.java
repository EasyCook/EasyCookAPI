package services;

import models.recipes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.CategoryRepository;

import javax.inject.Named;

/**
 * Created by eduardo on 11/03/15.
 */
@Named
public class CategoryService extends AbstractService<Category,Long>
{

	CategoryRepository                   categoryRepository;


	@Autowired
	public CategoryService( CategoryRepository categoryRepository )
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
