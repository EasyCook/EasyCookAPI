package models.recipes;

import models.AbstractEntity;

import javax.persistence.Entity;

/**
 * Created by eduardo on 12/02/15.
 */
@SuppressWarnings("serial")
@Entity
public class Level extends AbstractEntity
{
    String name;
}
