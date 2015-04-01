package services;

import models.recipes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import repositories.*;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardo on 12/03/15.
 */
@Named
@Transactional
public class RecipeService extends AbstractService< Recipe, Long >
{
	RecipeRepository           recipeRepository;
	CategoryRepository         categoryRepository;
	RecipeCategoryRepository   recipeCategoryRepository;
	IngredientRepository       ingredientRepository;
	RecipeIngredientRepository recipeIngredientRepository;

	@Autowired
	public RecipeService( JpaRepository< Recipe, Long > repo, IngredientRepository ingredientRepository, RecipeRepository recipeRepository,
	                      RecipeCategoryRepository recipeCategoryRepository, CategoryRepository categoryRepository,
	                      RecipeIngredientRepository recipeIngredientRepository )
	{
		super( repo );
		this.recipeRepository = recipeRepository;
		this.recipeCategoryRepository = recipeCategoryRepository;
		this.categoryRepository = categoryRepository;
		this.ingredientRepository = ingredientRepository;
	}

	public List< Category > getCategories( Long id )
	{
		return recipeCategoryRepository.getCategoryByRecipeId( id );
	}

	public boolean addCategory(Long recipeId, Long categoryId)
	{
		Recipe recipe = recipeRepository.findOne( recipeId );
		Category category = categoryRepository.findOne( categoryId );
		if( category == null )
		{
			return false;
		}

		RecipeCategory recipeCategory = new RecipeCategory();
		recipeCategory.setRecipe( recipe );
		recipeCategory.setCategory( category );

		recipeCategoryRepository.save( recipeCategory );

		return true;
	}

	public boolean addCategories( Long recipeId, List< Long > categories )
	{
		List< RecipeCategory > recipeCategories = new ArrayList<>();
		Recipe recipe = recipeRepository.findOne( recipeId );
		for( Long categoryId : categories )
		{
			Category category = categoryRepository.findOne( categoryId );

			if( category == null )
			{
				return false;
			}

			RecipeCategory recipeCategory = new RecipeCategory();
			recipeCategory.setRecipe( recipe );
			recipeCategory.setCategory( category );
			recipeCategories.add( recipeCategory );
		}

		recipeCategoryRepository.save( recipeCategories );

		return true;
	}

	public boolean addIngredient(Long recipeId, Long ingredientId)
	{
		Recipe recipe = recipeRepository.findOne( recipeId );
		Ingredient ingredient = ingredientRepository.findOne( ingredientId );

		if( ingredient == null )
		{
			return false;
		}
		RecipeIngredient recipeIngredient = new RecipeIngredient();
		recipeIngredient.setIngredient( ingredient );
		recipeIngredient.setRecipe( recipe );
		recipeIngredientRepository.save( recipeIngredient );

		return true;
	}

	public boolean addIngredients( Long recipeId, List< Long > ingredients )
	{
		List< RecipeIngredient > recipeIngredients = new ArrayList<>();
		Recipe recipe = recipeRepository.findOne( recipeId );
		for( Long ingredientId : ingredients )
		{
			Ingredient ingredient = ingredientRepository.findOne( ingredientId );
			if( ingredient == null )
			{
				return false;
			}
			RecipeIngredient recipeIngredient = new RecipeIngredient();
			recipeIngredient.setIngredient( ingredient );
			recipeIngredient.setRecipe( recipe );
			recipeIngredients.add( recipeIngredient );
		}

		recipeIngredientRepository.save( recipeIngredients );

		return true;
	}


}
