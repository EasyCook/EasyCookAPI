package repositories;

import models.recipes.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 11/03/15.
 */
@Named
@Singleton
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
}
