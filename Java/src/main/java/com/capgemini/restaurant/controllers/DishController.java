package com.capgemini.restaurant.controllers;

import com.capgemini.restaurant.models.Dish;
import com.capgemini.restaurant.models.DishRepository;
import com.capgemini.restaurant.models.DishService;
import com.capgemini.restaurant.models.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DishController {
    @Autowired
    DishService dishService;
    @Autowired
    private DishRepository dishRepository;

    @CrossOrigin
    @GetMapping("api/dishes/{id}")
    public ResponseEntity<Dish> getDish(@PathVariable(required = true) long id) {
        return ResponseEntity.ok().body(new Dish(id));
    }

    @CrossOrigin
    @GetMapping("api/dishes")
    public ResponseEntity<List<Dish>> getDishes() {
        List<Dish> dishes = new ArrayList<>();

        Dish hutspot = new Dish(1);
        hutspot.setDescription("hutspot");
        hutspot.setSellingPrice(10.99);
        hutspot.setMargin(20.0);
        hutspot.setAvailable(true);

        ArrayList<Ingredient> ingredients1 = new ArrayList<Ingredient>();
        ingredients1.add(new Ingredient("onion", "A", "B", "1", "c", "2", "5", "6", "5", "category", "5", "10"));
        ingredients1.add(new Ingredient("carrot", "X", "Y", "2", "c", "2", "5", "6", "5", "category", "5", "10"));
        ingredients1.add(new Ingredient("potatoe", "Y", "Y", "2", "c", "2", "5", "6", "5", "category", "5", "10"));
        hutspot.setIngredient(ingredients1);
        dishes.add(hutspot);

        ArrayList<Ingredient> ingredients2 = new ArrayList<Ingredient>();
        Dish carpaccio = new Dish(2, "carpaccio", 10.0, ingredients2, 20.0, true);
        ingredients2.add(new Ingredient("rundercarpaccio", "bracheY", "supplierB", "3", "unitC", "1", "5", "6", "5", "category", "8", "10"));
        ingredients2.add(new Ingredient("balsamico-azijn", "bracheY", "supplierB", "3", "unitC", "1", "5", "6", "5", "category", "8", "10"));
        ingredients2.add(new Ingredient("rucola", "bracheY", "supplierB", "3", "unitC", "1", "5", "6", "5", "category", "8", "10"));
        ingredients2.add(new Ingredient("parmezaan", "bracheY", "supplierB", "3", "unitC", "1", "5", "6", "5", "category", "8", "10"));
        dishes.add(carpaccio);

        dishService.saveDish(hutspot);
        dishService.saveDish(carpaccio);

        return ResponseEntity.ok().body(dishes);

    }

    @CrossOrigin
    @PostMapping(value="api/savedish",consumes="application/json",produces="application/json")
    public ResponseEntity saveDish(@RequestBody final Dish dish) {
        List<Dish> dishes = new ArrayList<>();
        dishService.saveDish(dish);
        Dish hutspot = new Dish(1);
        hutspot.setDescription("hutspot");
        hutspot.setSellingPrice(10.99);
        hutspot.setMargin(20.0);

        ArrayList<Ingredient> ingredients1 = new ArrayList<Ingredient>();
        ingredients1.add(new Ingredient("onion", "A", "B", "1", "c", "2", "5", "6", "5", "category", "5", "10"));
        ingredients1.add(new Ingredient("carrot", "X", "Y", "2", "c", "2", "5", "6", "5", "category", "5", "10"));
        ingredients1.add(new Ingredient("potatoe", "Y", "Y", "2", "c", "2", "5", "6", "5", "category", "5", "10"));
        hutspot.setIngredient(ingredients1);
        dishes.add(hutspot);

        ArrayList<Ingredient> ingredients2 = new ArrayList<Ingredient>();
        Dish carpaccio = new Dish(2, "carpaccio", 10.0, ingredients2, 20.0, true);
        ingredients2.add(new Ingredient("rundercarpaccio", "bracheY", "supplierB", "3", "unitC", "1", "5", "6", "5", "category", "8", "10"));
        ingredients2.add(new Ingredient("balsamico-azijn", "bracheY", "supplierB", "3", "unitC", "1", "5", "6", "5", "category", "8", "10"));
        ingredients2.add(new Ingredient("rucola", "bracheY", "supplierB", "3", "unitC", "1", "5", "6", "5", "category", "8", "10"));
        ingredients2.add(new Ingredient("parmezaan", "bracheY", "supplierB", "3", "unitC", "1", "5", "6", "5", "category", "8", "10"));
        dishes.add(carpaccio);

        dishService.saveDish(hutspot);
        dishService.saveDish(carpaccio);

        return ResponseEntity.ok().body(dish);

    }

    @CrossOrigin
    @GetMapping(value="api/listdishes",produces="application/json")
    public ResponseEntity<Iterable<Dish>> listDishes() {
        Iterable<Dish> dishes = dishService.listAll();
        ResponseEntity<Iterable<Dish>> responseEntity = new ResponseEntity<Iterable<Dish>>(dishes, HttpStatus.OK);
        return responseEntity;
    }

    // Find dish by description
    @CrossOrigin
    @GetMapping(value="api/dishbydescription/{searchTerm}",produces="application/json")
    public ResponseEntity<Iterable<Dish>> searchAvailableDishes(String searchTerm) {
        Iterable<Dish> dishes = dishRepository.findByDescription(searchTerm);
        ResponseEntity<Iterable<Dish>> responseEntity = new ResponseEntity<Iterable<Dish>>(dishes, HttpStatus.OK);
        return responseEntity;
    }

    // Find dish by description containg
    @CrossOrigin
    @GetMapping(value="api/dishbydescrcontaining/{searchTerm}",produces="application/json")
    public ResponseEntity<Iterable<Dish>> searchAvailableDishesByDescription(String searchTerm) {
        Iterable<Dish> dishes = dishRepository.findByDescriptionContainingIgnoreCase(searchTerm);
        ResponseEntity<Iterable<Dish>> responseEntity = new ResponseEntity<Iterable<Dish>>(dishes, HttpStatus.OK);
        return responseEntity;
    }

    // Deletes a database item when clicked
    @CrossOrigin
    @DeleteMapping(value="api/deletedish/{id}",produces="application/json")
    public void deleteDish(@PathVariable long id) {
        dishRepository.deleteById(id);
    }

    // Deletes a database item when clicked
    @CrossOrigin
    @DeleteMapping(value="api/deletedishdescription/{searchTerm}",produces="application/json")
    public void deleteDishByDescrContaining(@PathVariable String searchTerm) {
        dishRepository.deleteByDescriptionContainingIgnoreCase(searchTerm);
    }



}
