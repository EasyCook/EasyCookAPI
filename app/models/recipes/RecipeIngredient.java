package models.recipes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import models.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by eduardo on 13/02/15.
 */
@SuppressWarnings( "serial" )
@Entity
public class RecipeIngredient extends AbstractEntity {
	@ManyToOne
	Ingredient ingredient;

	@OneToOne
	Unit ingredientUnit;

	@ManyToOne
	@JsonIgnore
	Recipe recipe;

	Long amount;

	public Long getAmount() {
		return amount;
	}

	public void setAmount( Long amount ) {
		this.amount = amount;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient( Ingredient ingredient ) {
		this.ingredient = ingredient;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe( Recipe recipe ) {
		this.recipe = recipe;
	}

	public Unit getIngredientUnit() {
		return ingredientUnit;
	}

	public void setIngredientUnit( Unit ingredientUnit ) {
		this.ingredientUnit = ingredientUnit;
	}
}
