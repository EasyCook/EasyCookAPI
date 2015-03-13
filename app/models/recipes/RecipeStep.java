package models.recipes;

import models.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by eduardo on 10/03/15.
 */
@SuppressWarnings("serial")
@Entity
public class RecipeStep extends AbstractEntity {
    String description;
    String image;
    @ManyToOne
    Recipe recipe;
}
