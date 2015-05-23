package models.user;

import models.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by eduardo on 28/03/15.
 */
@SuppressWarnings("serial")
@Entity
public class Image extends AbstractEntity
{
	String url;
	String name;
	@ManyToOne
	User user;
}
