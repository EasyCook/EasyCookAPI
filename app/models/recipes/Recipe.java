package models.recipes;

import models.AbstractEntity;
import models.user.User;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

/**
 * Created by eduardo on 13/02/15.
 */
@SuppressWarnings( "serial" )
@Entity
public class Recipe extends AbstractEntity
{

	String title;

	String description;

	String portion;

	String thumbnail;

	Integer calories;

	Integer difficulty;

	@OneToMany( cascade = CascadeType.ALL, mappedBy = "recipe" ) List< RecipeIngredient > ingredients;

	@OneToOne Level level;

	@OneToOne Region region;

	@OneToMany( fetch = LAZY , cascade = CascadeType.ALL, mappedBy = "recipe") List< RecipeCategory > categories;

	@ManyToOne User user;

	Long time;

	@OneToOne Unit timeUnit;

	@OneToMany( fetch = LAZY ) List< RecipeStep > steps;

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

	public Integer getDifficulty()
	{
		return difficulty;
	}

	public void setDifficulty( Integer difficulty )
	{
		this.difficulty = difficulty;
	}

	public List< RecipeIngredient > getIngredients()
	{
		return ingredients;
	}

	public void setIngredients( List< RecipeIngredient > ingredients )
	{
		this.ingredients = ingredients;
	}

	public Level getLevel()
	{
		return level;
	}

	public void setLevel( Level level )
	{
		this.level = level;
	}

	public Region getRegion()
	{
		return region;
	}

	public void setRegion( Region region )
	{
		this.region = region;
	}

	public List< RecipeCategory > getCategory()
	{
		return categories;
	}

	public void setCategory( List< RecipeCategory > category )
	{
		this.categories = category;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser( User user )
	{
		this.user = user;
	}

	public Long getTime()
	{
		return time;
	}

	public void setTime( Long time )
	{
		this.time = time;
	}

	public Unit getTimeUnit()
	{
		return timeUnit;
	}

	public void setTimeUnit( Unit timeUnit )
	{
		this.timeUnit = timeUnit;
	}

	public List< RecipeStep > getSteps()
	{
		return steps;
	}

	public void setSteps( List< RecipeStep > steps )
	{
		this.steps = steps;
	}
}
