package com.capgemini.restaurant.controllers;

import com.capgemini.restaurant.models.Ingredient;
import com.capgemini.restaurant.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @CrossOrigin
    @GetMapping(value = "api/ingredients", produces = "application/json")
    public ResponseEntity<Iterable<Ingredient>> listAll() {
        Iterable<Ingredient> ingredients = ingredientService.listAll();
        return new ResponseEntity<Iterable<Ingredient>>(ingredients, HttpStatus.OK);
    }

    @PostMapping(value = "api/ingredients", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Ingredient> create(@RequestBody final Ingredient ingredient) {
        ingredientService.create(ingredient);
        return new ResponseEntity<Ingredient>(ingredient, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("api/ingredients/{id}")
    public ResponseEntity<Ingredient> getById(@PathVariable(required = true) long id) {
        Optional<Ingredient> ingredient = ingredientService.getById(id);

        if (ingredient.isPresent()) {
            return new ResponseEntity<Ingredient>(ingredient.get(), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient with id " + id +" does not exist");
        }
    }

    @CrossOrigin
    // TODO: Putmapping
    @PostMapping(value = "api/ingredient/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity saveIngredient(@RequestBody final Ingredient ingredient) {
        ingredientService.save(ingredient);

        return ResponseEntity.ok().body(ingredient);
    }

    @CrossOrigin
    @DeleteMapping(value = "api/ingredients/delete/{id}", produces = "application/json")
    public void deleteIngredient(@PathVariable long id) {
        ingredientService.deleteId(id);
    }

    @CrossOrigin
    @GetMapping(value = "api/ingredients/findByName/{name}", produces = "application/json")
    public ResponseEntity<Iterable<Ingredient>> findIngredientsByName(@PathVariable(required = true) String name) {
        Iterable<Ingredient> ingredients = ingredientService.findByDescription(name);
        return new ResponseEntity<Iterable<Ingredient>>(ingredients, HttpStatus.OK);
    }
}
