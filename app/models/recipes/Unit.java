package models.recipes;

import models.base.AbstractEntity;

import javax.persistence.Entity;

/**
 * Created by eduardo on 12/02/15.
 */
@SuppressWarnings("serial")
@Entity
public class Unit extends AbstractEntity{

	String type;
	String dimentional;
	String description;

	public String getDimentional()
	{
		return dimentional;
	}

	public void setDimentional( String dimentional )
	{
		this.dimentional = dimentional;
	}

	public String getType()
	{
		return type;
	}

	public void setType( String name )
	{
		this.type = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription( String description )
	{
		this.description = description;
	}
}
