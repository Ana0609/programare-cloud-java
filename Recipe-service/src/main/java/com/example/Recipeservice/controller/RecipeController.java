package com.example.Recipeservice.controller;

import com.example.Recipeservice.model.Recipe;
import com.example.Recipeservice.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes(){
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @PostMapping
    public ResponseEntity<Recipe> saveRecipe(@RequestBody Recipe r){
        return ResponseEntity.ok(recipeService.saveRecipe(r));
    }
}
