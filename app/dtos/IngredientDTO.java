package dtos;

import models.recipes.Unit;

/**
 * Created by eduardo on 26/05/15.
 */
public class IngredientDTO extends BaseDTO{

	Unit   ingredientUnit;
	Long amount;

	public Unit getIngredientUnit() {
		return ingredientUnit;
	}

	public void setIngredientUnit( Unit ingredientUnit ) {
		this.ingredientUnit = ingredientUnit;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount( Long amount ) {
		this.amount = amount;
	}
}
