package models.recipes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import models.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by eduardo on 10/03/15.
 */
@SuppressWarnings("serial")
@Entity
public class RecipeStep extends AbstractEntity {

	String  description;
	String  image;
	Integer stepOrder;


	@ManyToOne
    @JsonIgnore
    Recipe recipe;

	public String getDescription()
	{
		return description;
	}

	public void setDescription( String description )
	{
		this.description = description;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage( String image )
	{
		this.image = image;
	}

	public Integer getStepOrder()
	{
		return stepOrder;
	}

	public void setStepOrder( Integer order )
	{
		this.stepOrder = order;
	}

	public Recipe getRecipe()
	{
		return recipe;
	}

	public void setRecipe( Recipe recipe )
	{
		this.recipe = recipe;
	}
}
