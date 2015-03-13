package models.recipes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import models.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by eduardo on 13/02/15.
 */
@SuppressWarnings("serial")
@Entity
public class RecipeIngredient extends AbstractEntity
{
    @ManyToOne
    Ingredient ingredient;

    @ManyToOne
    @JsonIgnore
    Recipe recipe;

    @OneToOne
    Unit unit;

}
