package com.example.Recipeservice.service;

import com.example.Recipeservice.datasource.MyPantry;
import com.example.Recipeservice.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    private final MyPantry pantry;

    @Autowired
    public RecipeService(MyPantry pantry) {
        this.pantry = pantry;
    }


    public List<Recipe> getAllRecipes() { return pantry.getAllRecipes(); }

    public Recipe saveRecipe(Recipe myRecipe) {
        return pantry.saveRecipe(myRecipe);
    }
}
