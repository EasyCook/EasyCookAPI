package models.recipes;

import models.base.AbstractEntity;

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

	public Recipe recipe;

	@ManyToOne

	public Category category;

	public Recipe getRecipe()
	{
		return recipe;
	}

	public void setRecipe( Recipe recipe )
	{
		this.recipe = recipe;
	}

	public Category getCategory()
	{
		return category;
	}

	public void setCategory( Category category )
	{
		this.category = category;
	}
}
