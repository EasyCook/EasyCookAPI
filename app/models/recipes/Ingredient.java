package models.recipes;

import models.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by eduardo on 10/02/15.
 */
@SuppressWarnings("serial")
@Entity
public class Ingredient extends AbstractEntity
{
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredient")
    List<RecipeIngredient> recipes;


}
