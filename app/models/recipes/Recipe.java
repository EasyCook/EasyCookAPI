package models.recipes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import models.base.AbstractEntity;
import models.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

/**
 * Created by eduardo on 13/02/15.
 */
@SuppressWarnings("serial")
@Entity
public class Recipe extends AbstractEntity
{

    String title;
    String description;
    String portion;
    String thumbnail;

    Integer calories;
    Integer difficulty;

    Long time;


    @OneToOne(cascade = CascadeType.ALL,fetch = EAGER)
    Region region;


    @OneToOne( cascade = CascadeType.ALL,fetch = EAGER)
    Unit timeUnit;


    @ManyToOne( cascade = CascadeType.ALL,fetch = EAGER)
    User user;

	/*@OneToOne Unit ingredientUnit;*/
    @JsonIgnore
    @OneToMany(fetch = LAZY, cascade = CascadeType.ALL, mappedBy = "recipe", orphanRemoval = true)
    List<RecipeStep> steps = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = LAZY, cascade = CascadeType.ALL, mappedBy = "recipe", orphanRemoval = true)
    List<RecipeCategory> categories = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = LAZY, cascade = CascadeType.ALL, mappedBy = "recipe", orphanRemoval = true)
    List<RecipeIngredient> ingredients = new ArrayList<>();

    public List<RecipeCategory> getCategories ()
    {
        return categories;
    }

    public void setCategories (List<RecipeCategory> categories)
    {
        this.categories = categories;
    }

	/*public Unit getIngredientUnit()
    {
		return ingredientUnit;
	}

	public void setIngredientUnit( Unit ingredientUnit )
	{
		this.ingredientUnit = ingredientUnit;
	}*/

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getPortion ()
    {
        return portion;
    }

    public void setPortion (String portion)
    {
        this.portion = portion;
    }

    public String getThumbnail ()
    {
        return thumbnail;
    }

    public void setThumbnail (String thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public Integer getCalories ()
    {
        return calories;
    }

    public void setCalories (Integer calories)
    {
        this.calories = calories;
    }

    public Integer getDifficulty ()
    {
        return difficulty;
    }

    public void setDifficulty (Integer difficulty)
    {
        this.difficulty = difficulty;
    }

    public List<RecipeIngredient> getIngredients ()
    {
        return ingredients;
    }

    public void setIngredients (List<RecipeIngredient> ingredients)
    {
        this.ingredients = ingredients;
    }


    public Region getRegion ()
    {
        return region;
    }

    public void setRegion (Region region)
    {
        this.region = region;
    }

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

    public Long getTime ()
    {
        return time;
    }

    public void setTime (Long time)
    {
        this.time = time;
    }

    public Unit getTimeUnit ()
    {
        return timeUnit;
    }

    public void setTimeUnit (Unit timeUnit)
    {
        this.timeUnit = timeUnit;
    }

    public List<RecipeStep> getSteps ()
    {
        return steps;
    }

    public void setSteps (List<RecipeStep> steps)
    {
        this.steps = steps;
    }
}
