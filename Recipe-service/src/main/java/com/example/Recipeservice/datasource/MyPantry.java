package com.example.Recipeservice.datasource;

import com.example.Recipeservice.model.Ingredient;
import com.example.Recipeservice.model.Recipe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Repository
public class MyPantry {
    private List<Recipe> recipes;

    public MyPantry(){
        List<Ingredient> ingredients1 = new ArrayList<>();
        List<Ingredient> ingredients2 = new ArrayList<>();
        ingredients1.add(new Ingredient("Milk", 500.0, "ml"));
        ingredients1.add(new Ingredient("Meat", 1500.0, "g"));
        ingredients2.add(new Ingredient("Tomatoes", 12.0, "pieces"));
        ingredients2.add(new Ingredient("Fries", 650.0, "g"));
        ingredients2.add(new Ingredient("Olive oil", 200.0, "ml"));
        recipes = Stream.of(
                new Recipe("Recipe1", ingredients1),
                new Recipe("Recipe2", ingredients2)
        ).collect(Collectors.toList());
    }

    public List<Recipe> getAllRecipes(){return recipes;}

    public Optional<Recipe> findRecipeByName(String name) {
        return recipes.stream().filter(i -> i.getName().equals(name)).findFirst();
    }
    public Recipe saveRecipe(Recipe myRecipe){
        findRecipeByName(myRecipe.getName()).ifPresent(i -> {
            throw new RuntimeException("Recipe with name " + i.getName() + " already exists!");
        });
        this.recipes.add(myRecipe);
        return myRecipe;
    }

    public List<Recipe> saveAllRecipes(List<Recipe> recipeList){
        recipeList.forEach(recipe -> {
            findRecipeByName(recipe.getName()).ifPresent(i -> {
                throw new RuntimeException("Recipe with name " + i.getName() + " already exists!");
            });
        });
        this.recipes.addAll(recipeList);
        return recipeList;
    }
}
