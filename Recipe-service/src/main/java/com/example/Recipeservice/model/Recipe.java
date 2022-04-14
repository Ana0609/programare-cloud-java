package com.example.Recipeservice.model;

import com.example.Recipeservice.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private String name;
    private List<Ingredient> ingredients;
}
