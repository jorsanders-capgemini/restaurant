package com.capgemini.restaurant.controllers;

import com.capgemini.restaurant.models.Ingredient;
import com.capgemini.restaurant.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @CrossOrigin
    @GetMapping("api/ingredientes/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable(required = true) long id) {
        return ResponseEntity.ok().body(new Ingredient(id));
    }

    @CrossOrigin
    // TODO: Putmapping
    @PostMapping(value = "api/ingredient/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity saveIngredient(@RequestBody final Ingredient ingredient) {
        ingredientService.save(ingredient);

        return ResponseEntity.ok().body(ingredient);
    }

    @CrossOrigin
    @GetMapping(value = "api/ingredientes", produces = "application/json")
    public ResponseEntity<Iterable<Ingredient>> listIngredientes() {
        Iterable<Ingredient> ingredientes = ingredientService.listAll();
        return new ResponseEntity<Iterable<Ingredient>>(ingredientes, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "api/ingredientes/findByName/{name}", produces = "application/json")
    public ResponseEntity<Iterable<Ingredient>> findIngredientesByName(@PathVariable(required = true) String name) {
        Iterable<Ingredient> ingredientes = ingredientService.findByDescription(name);
        return new ResponseEntity<Iterable<Ingredient>>(ingredientes, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "api/ingredientes/delete/{id}", produces = "application/json")
    public void deleteIngredient(@PathVariable long id) {
        ingredientService.deleteId(id);
    }
}
