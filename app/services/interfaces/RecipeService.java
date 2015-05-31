package services.interfaces;

import dtos.IngredientDTO;
import dtos.RecipeDTO;
import models.recipes.Category;
import models.recipes.Ingredient;
import models.recipes.Recipe;
import models.recipes.RecipeIngredient;
import models.recipes.RecipeStep;
import services.base.GenericService;

import java.util.List;
import java.util.Optional;

/**
 * Created by eduardo on 5/04/15.
 */
public interface RecipeService extends GenericService<Recipe, Long>
{
    public List<Category> getCategories (Long id);

    public boolean addCategory (Long recipeId, Long categoryId);

    public boolean addCategories (Long recipeId, List<Long> categories);

    public boolean addIngredient (Long recipeId, Long ingredientId);

    public boolean addIngredients (Long recipeId, List< IngredientDTO> ingredients);

    public boolean addSteps (Long recipeId, List<RecipeStep> steps);

    public Optional<Long> createRecipe (RecipeDTO recipeDTO);

    public List< RecipeIngredient > getRecipeIngredients( Long recipeId );

    public List<RecipeStep> getRecipeSteps (Long recipeId);

    public RecipeDTO getRecipeDTO (Recipe recipe);

    public List<RecipeDTO> getRecipeDTO (List<Recipe> recipes);
}
