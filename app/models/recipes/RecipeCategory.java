package models.recipes;

import models.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by eduardo on 12/03/15.
 */
@SuppressWarnings( "serial" )
@Entity
public class RecipeCategory extends AbstractEntity
{
	@ManyToOne
	Recipe recipe;

	@ManyToOne
	Category category;

}
