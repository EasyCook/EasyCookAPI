package services;

import models.recipes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.CategoryRepository;
import services.base.AbstractService;
import services.interfaces.CategoryService;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 11/03/15.
 */
@Named
@Singleton
public class CategoryServiceImpl extends AbstractService<Category,Long> implements CategoryService
{

	CategoryRepository                   categoryRepository;


	@Autowired
	public CategoryServiceImpl (CategoryRepository categoryRepository)
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
