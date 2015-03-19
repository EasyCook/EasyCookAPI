package dtos;

import models.recipes.RecipeIngredient;
import models.recipes.RecipeStep;
import models.recipes.Unit;
import models.user.User;

import java.util.List;

/**
 * Created by eduardo on 12/03/15.
 */
public class RecipeDTO
{
	/**
	 * id : (integer)
	 * title : (string)
	 * description : (string)
	 * ingredients : [ {
	 * id : (integer)
	 * name : (string)
	 * quantity : (string)
	 * timeUnit : (string),
	 * }
	 * ]
	 * difficulty : (integer)
	 * steps : [
	 * image : (image)
	 * description : (string)
	 * ]
	 * portion : (string)
	 * thumbnail : (image)
	 * calories : (interger)
	 * cooking_time : {
	 * time : (integer)
	 * timeUnit : (string)
	 * }
	 * author : {
	 * id : (integer)
	 * name : (string)
	 * }
	 */

	Long                     id;
	String                   title;
	String                   description;
	List< RecipeIngredient > ingredients;
	Integer                  difficulty;
	List< RecipeStep >       steps;
	String                   portion;
	String                   thumbnail;
	Integer                  calories;
	Long                     cookingTime;
	Unit                     timeUnit;
	User                     user;

	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle( String title )
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription( String description )
	{
		this.description = description;
	}

	public List< RecipeIngredient > getIngredients()
	{
		return ingredients;
	}

	public void setIngredients( List< RecipeIngredient > ingredients )
	{
		this.ingredients = ingredients;
	}

	public Integer getDifficulty()
	{
		return difficulty;
	}

	public void setDifficulty( Integer difficulty )
	{
		this.difficulty = difficulty;
	}

	public List< RecipeStep > getSteps()
	{
		return steps;
	}

	public void setSteps( List< RecipeStep > steps )
	{
		this.steps = steps;
	}

	public String getPortion()
	{
		return portion;
	}

	public void setPortion( String portion )
	{
		this.portion = portion;
	}

	public String getThumbnail()
	{
		return thumbnail;
	}

	public void setThumbnail( String thumbnail )
	{
		this.thumbnail = thumbnail;
	}

	public Integer getCalories()
	{
		return calories;
	}

	public void setCalories( Integer calories )
	{
		this.calories = calories;
	}

	public Long getCookingTime()
	{
		return cookingTime;
	}

	public void setCookingTime( Long cookingTime )
	{
		this.cookingTime = cookingTime;
	}

	public Unit getTimeUnit()
	{
		return timeUnit;
	}

	public void setTimeUnit( Unit timeUnit )
	{
		this.timeUnit = timeUnit;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser( User user )
	{
		this.user = user;
	}
}
