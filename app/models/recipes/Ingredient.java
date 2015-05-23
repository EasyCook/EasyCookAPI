package models.recipes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import models.base.AbstractEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardo on 10/02/15.
 */
@SuppressWarnings("serial")
@Entity
public class Ingredient extends AbstractEntity
{
    String name;
    String description;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_id")
    @JsonIgnore
    List<RecipeIngredient> recipes = new ArrayList<>();

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public List<RecipeIngredient> getRecipes ()
    {
        return recipes;
    }

    public void setRecipes (List<RecipeIngredient> recipes)
    {
        this.recipes = recipes;
    }
}
