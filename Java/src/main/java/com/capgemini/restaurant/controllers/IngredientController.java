package com.capgemini.restaurant.controllers;

import com.capgemini.restaurant.models.Ingredient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class IngredientController {

    @CrossOrigin
    @GetMapping("api/ingredients/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable(required = true) String id) {
      return ResponseEntity.ok().body(new Ingredient(id));
    }

    @CrossOrigin
    @GetMapping("api/ingredients")
    public ResponseEntity<List<Ingredient>> getIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();

        Ingredient sugar = new Ingredient("1");
        sugar.setId("4");
        sugar.setDescription("sugar");
        ingredients.add(sugar);

        Ingredient salt = new Ingredient("2");
        salt.setDescription("salt");
        salt.setPrice("50");
        ingredients.add(salt);

        return ResponseEntity.ok().body(ingredients);
    }
}
