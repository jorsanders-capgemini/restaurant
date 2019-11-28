package com.capgemini.restaurant.controllers;

import com.capgemini.restaurant.models.Dish;
import com.capgemini.restaurant.models.Ingredient;
import com.capgemini.restaurant.services.DishService;
import com.capgemini.restaurant.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class DishController {
    @Autowired
    private DishService dishService;

    @Autowired
    private IngredientService ingredientService;

    @CrossOrigin
    @GetMapping(value = "api/dishes", produces = "application/json")
    public ResponseEntity<Iterable<Dish>> listAll() {
        Iterable<Dish> dishes = dishService.listAll();
        return new ResponseEntity<Iterable<Dish>>(dishes, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "api/dish", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Dish> create(@RequestBody final Dish dish) {
        dishService.create(dish);
        return new ResponseEntity<Dish>(dish, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("api/dishes/{id}")
    public ResponseEntity<Dish> getById(@PathVariable(required = true) long id) {
        Optional<Dish> dish = dishService.getById(id);
        if (dish.isPresent()) {
            return new ResponseEntity<Dish>(dish.get(), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dish with id " + id + " not found");
        }
    }

    @CrossOrigin
    @PutMapping(value = "api/dish/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity saveDish(@RequestBody final Dish dish) {
        for (Ingredient ingredient : dish.getIngredients()) {
            ingredient = ingredientService.save(ingredient);
        }
        dishService.save(dish);

        return ResponseEntity.ok().body(dish);
    }

    @CrossOrigin
    @DeleteMapping(value = "api/dishes/delete/{id}", produces = "application/json")
    public void deleteDish(@PathVariable long id) {
        dishService.deleteId(id);
    }


    @CrossOrigin
    @GetMapping(value = "api/dishes/findByDescription/{description}", produces = "application/json")
    public ResponseEntity<Iterable<Dish>> findDishesByDescription(@PathVariable(required = true) String description) {
        // TODO use query variable not path variable
        Iterable<Dish> dishes = dishService.findByDescription(description);
        return new ResponseEntity<Iterable<Dish>>(dishes, HttpStatus.OK);
    }


}
