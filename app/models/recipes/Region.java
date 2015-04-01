package models.recipes;

import models.AbstractEntity;

import javax.persistence.Entity;

/**
 * Created by eduardo on 12/02/15.
 */
@SuppressWarnings("serial")
@Entity
public class Region extends AbstractEntity {
    String name;

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}
}
