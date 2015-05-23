package services;

import dtos.RecipeDTO;
import models.recipes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import repositories.*;
import services.base.AbstractService;
import services.interfaces.RecipeService;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by eduardo on 12/03/15.
 */
@Named
@Singleton
@Transactional
public class RecipeServiceImpl extends AbstractService<Recipe, Long> implements RecipeService
{
    RecipeRepository recipeRepository;
    CategoryRepository categoryRepository;
    RecipeCategoryRepository recipeCategoryRepository;
    IngredientRepository ingredientRepository;
    RecipeIngredientRepository recipeIngredientRepository;
    RecipeStepRepository recipeStepRepository;
    UnitRepository unitRepository;

    @Autowired
    public RecipeServiceImpl (JpaRepository<Recipe, Long> repo, IngredientRepository ingredientRepository, RecipeRepository recipeRepository,
                              RecipeCategoryRepository recipeCategoryRepository, CategoryRepository categoryRepository,
                              RecipeIngredientRepository recipeIngredientRepository, RecipeStepRepository recipeStepRepository, UnitRepository unitRepository)
    {
        super(repo);
        this.recipeRepository = recipeRepository;
        this.recipeCategoryRepository = recipeCategoryRepository;
        this.categoryRepository = categoryRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.recipeStepRepository = recipeStepRepository;
        this.unitRepository = unitRepository;
    }

    public List<Category> getCategories (Long id)
    {
        return recipeCategoryRepository.getCategoryByRecipeId(id);
    }

    public boolean addCategory (Long recipeId, Long categoryId)
    {
        Recipe recipe = recipeRepository.findOne(recipeId);
        Category category = categoryRepository.findOne(categoryId);
        if (category == null)
        {
            return false;
        }

        RecipeCategory recipeCategory = new RecipeCategory();
        recipeCategory.setRecipe(recipe);
        recipeCategory.setCategory(category);

        recipeCategoryRepository.save(recipeCategory);

        return true;
    }

    public boolean addCategories (Long recipeId, List<Long> categories)
    {
        List<RecipeCategory> recipeCategories = new ArrayList<>();
        Recipe recipe = recipeRepository.findOne(recipeId);
        for (Long categoryId : categories)
        {
            Category category = categoryRepository.findOne(categoryId);

            if (category == null)
            {
                return false;
            }

            RecipeCategory recipeCategory = new RecipeCategory();
            recipeCategory.setRecipe(recipe);
            recipeCategory.setCategory(category);
            recipeCategories.add(recipeCategory);
        }

        recipeCategoryRepository.save(recipeCategories);

        return true;
    }

    public boolean addIngredient (Long recipeId, Long ingredientId)
    {
        Recipe recipe = recipeRepository.findOne(recipeId);
        Ingredient ingredient = ingredientRepository.findOne(ingredientId);

        if (ingredient == null)
        {
            return false;
        }
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setIngredient(ingredient);
        recipeIngredient.setRecipe(recipe);
        recipeIngredientRepository.save(recipeIngredient);

        return true;
    }

    public boolean addIngredients (Long recipeId, List<Long> ingredients)
    {
        List<RecipeIngredient> recipeIngredients = new ArrayList<>();
        Recipe recipe = recipeRepository.findOne(recipeId);
        for (Long ingredientId : ingredients)
        {
            Ingredient ingredient = ingredientRepository.findOne(ingredientId);
            if (ingredient == null)
            {
                return false;
            }
            RecipeIngredient recipeIngredient = new RecipeIngredient();
            recipeIngredient.setIngredient(ingredient);
            recipeIngredient.setRecipe(recipe);
            recipeIngredients.add(recipeIngredient);
        }

        recipeIngredientRepository.save(recipeIngredients);

        return true;
    }

    public boolean addSteps (Long recipeId, List<RecipeStep> steps)
    {
        List<RecipeStep> recipeSteps = new ArrayList<>();
        final Recipe recipe = recipeRepository.findOne(recipeId);

        if (recipe == null)
        {
            return false;
        }

        steps.forEach(step -> step.setRecipe(recipe));

        recipeStepRepository.save(steps);

        return true;
    }

    public Optional<Long> createRecipe ( RecipeDTO recipeDTO)
    {
        List< Ingredient > ingredients = recipeDTO.getIngredients();
        List< RecipeStep > recipeSteps = recipeDTO.getSteps();
        Unit timeU = unitRepository.findOne(recipeDTO.getTimeUnit().getId());

        Recipe recipe = new Recipe();
        recipe.setCalories( recipeDTO.getCalories() );
        recipe.setDescription( recipeDTO.getDescription() );
        recipe.setDifficulty( recipeDTO.getDifficulty() );
        recipe.setPortion( recipeDTO.getPortion() );
        recipe.setThumbnail( recipeDTO.getThumbnail() );
        recipe.setTitle( recipeDTO.getTitle() );
        recipe.setTime( recipeDTO.getCookingTime() );
        recipe.setTimeUnit(timeU);

        recipe = recipeRepository.save(recipe);

        if (recipe.getId() == null)
        {
            return Optional.empty();
        }

        if (addIngredients(recipe.getId(), ingredients.stream().map(i -> i.getId()).collect(Collectors.toList())))
        {
            if (addSteps(recipe.getId(), recipeSteps))
            {
                return Optional.of(recipe.getId());
            }

            return Optional.empty();

        }

        return Optional.empty();
    }

    public List<Ingredient> getRecipeIngredients (Long recipeId)
    {
        List<Ingredient> ingredients = recipeIngredientRepository.getRecipeIngredients(recipeId);
        return ingredients;
    }

    public List<RecipeStep> getRecipeSteps (Long recipeId)
    {
        List<RecipeStep> recipeSteps = recipeStepRepository.findByRecipeId(recipeId);
        return recipeSteps;
    }


    public RecipeDTO getRecipeDTO (Recipe recipe)
    {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setCalories( recipe.getCalories() );
        recipeDTO.setCookingTime( recipe.getTime() );
        recipeDTO.setDescription( recipe.getDescription() );
        recipeDTO.setDifficulty( recipe.getDifficulty() );
        recipeDTO.setId( recipe.getId() );
        recipeDTO.setTimeUnit( recipe.getTimeUnit() );
        recipeDTO.setPortion( recipe.getPortion() );
        recipeDTO.setThumbnail( recipe.getThumbnail() );
        recipeDTO.setTitle( recipe.getTitle() );

        recipeDTO.setUser( recipe.getUser() );

        List<RecipeStep> steps = getRecipeSteps(recipe.getId());
        recipeDTO.setSteps( steps );

        List<Ingredient> ingredients = getRecipeIngredients(recipe.getId());
        recipeDTO.setIngredients( ingredients );
        return recipeDTO;
    }

    public List<RecipeDTO> getRecipeDTO(List<Recipe> recipes)
    {
        List<RecipeDTO> recipeDTOs = new ArrayList<>();
        for (Recipe recipe : recipes)
        {
            recipeDTOs.add(getRecipeDTO(recipe));
        }

        return recipeDTOs;
    }
}
