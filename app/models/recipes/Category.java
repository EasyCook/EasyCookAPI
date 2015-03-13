package models.recipes;

import models.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by eduardo on 12/02/15.
 */
@SuppressWarnings("serial")
@Entity
public class Category extends AbstractEntity{
    String name;
    String description;
    String thumbnail;
    String slug;
	@OneToMany List<RecipeCategory> recipes;

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription( String description )
	{
		this.description = description;
	}

	public String getThumbnail()
	{
		return thumbnail;
	}

	public void setThumbnail( String thumbnail )
	{
		this.thumbnail = thumbnail;
	}

	public String getSlug()
	{
		return slug;
	}

	public void setSlug( String slug )
	{
		this.slug = slug;
	}
}
