package com.example.Recipeservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ingredient {
    private String name;
    private Double quantity;
    private String unitOfMeasurement;
}