package models.recipes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import models.AbstractEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardo on 12/02/15.
 */
@SuppressWarnings("serial")
@Entity
public class Category extends AbstractEntity
{
    String name;
    String description;
    String thumbnail;
    String slug;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    List<RecipeCategory> recipes = new ArrayList<>();

    public String getName ()
    {
        return name;
    }

    public List<RecipeCategory> getRecipes ()
    {
        return recipes;
    }

    public void setRecipes (List<RecipeCategory> recipes)
    {
        this.recipes = recipes;
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

    public String getThumbnail ()
    {
        return thumbnail;
    }

    public void setThumbnail (String thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public String getSlug ()
    {
        return slug;
    }

    public void setSlug (String slug)
    {
        this.slug = slug;
    }
}
