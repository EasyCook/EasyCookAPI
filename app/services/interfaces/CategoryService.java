package services.interfaces;

import models.recipes.Category;
import services.base.GenericService;

import java.io.Serializable;

/**
 * Created by eduardo on 5/04/15.
 */
public interface CategoryService extends GenericService<Category,Long>
{
    public Category findBySlug( String slug );
}
