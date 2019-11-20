package com.capgemini.restaurant.controllers;

import com.capgemini.restaurant.models.Dish;
import com.capgemini.restaurant.models.DishService;
import com.capgemini.restaurant.models.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DishController {
    @Autowired
    DishService dishService;
    @CrossOrigin
    @GetMapping("api/dishes/{id}")
    public ResponseEntity<Dish> getDish(@PathVariable(required = true) long id) {
        return ResponseEntity.ok().body(new Dish(id));
    }
    @CrossOrigin
    @GetMapping("api/dishes")
    public ResponseEntity<List<Dish>> getDishes() {
      List<Dish>  dishes = new ArrayList<>();

      Dish hutspot = new Dish(1);
      hutspot.setDescription("hutspot");
      hutspot.setSellingPrice(10.99);
      hutspot.setMargin(20.0);
      //ArrayList<String> ingredients1 = new ArrayList<>();
      ArrayList<Ingredient> ingredients1 = new ArrayList<Ingredient>();
      ingredients1.add(new Ingredient("onion", "A", "B", "1", "c", "2", "5", "6", "5", "category", "5", "10"));
      ingredients1.add(new Ingredient("carrot", "X", "Y", "2", "c", "2", "5", "6", "5", "category", "5", "10"));
      ingredients1.add(new Ingredient("potatoe", "Y", "Y", "2", "c", "2", "5", "6", "5", "category", "5", "10"));
      hutspot.setIngredients(ingredients1);
      //ingredients1.add(carrot);
      //ingredients1.add(onion);
      //hutspot.add(ingredients1);
      dishes.add(hutspot);

      ArrayList<Ingredient> ingredients2 = new ArrayList<Ingredient>();
      Dish carpaccio = new Dish(2, "carpaccio", 10.0,  ingredients2, 20.0, true);
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
    @GetMapping("api/savedish")
    public ResponseEntity<Dish> saveDish(@RequestBody final Dish dish) {
        List<Dish>  dishes = new ArrayList<>();
        dishService.saveDish(dish);
        Dish hutspot = new Dish(1);
        hutspot.setDescription("hutspot");
        hutspot.setSellingPrice(10.99);
        hutspot.setMargin(20.0);
        //ArrayList<String> ingredients1 = new ArrayList<>();
        ArrayList<Ingredient> ingredients1 = new ArrayList<Ingredient>();
        ingredients1.add(new Ingredient("onion", "A", "B", "1", "c", "2", "5", "6", "5", "category", "5", "10"));
        ingredients1.add(new Ingredient("carrot", "X", "Y", "2", "c", "2", "5", "6", "5", "category", "5", "10"));
        ingredients1.add(new Ingredient("potatoe", "Y", "Y", "2", "c", "2", "5", "6", "5", "category", "5", "10"));
        hutspot.setIngredients(ingredients1);
        //ingredients1.add(carrot);
        //ingredients1.add(onion);
        //hutspot.add(ingredients1);
        dishes.add(hutspot);

        ArrayList<Ingredient> ingredients2 = new ArrayList<Ingredient>();
        Dish carpaccio = new Dish(2, "carpaccio", 10.0,  ingredients2, 20.0, true);
        ingredients2.add(new Ingredient("rundercarpaccio", "bracheY", "supplierB", "3", "unitC", "1", "5", "6", "5", "category", "8", "10"));
        ingredients2.add(new Ingredient("balsamico-azijn", "bracheY", "supplierB", "3", "unitC", "1", "5", "6", "5", "category", "8", "10"));
        ingredients2.add(new Ingredient("rucola", "bracheY", "supplierB", "3", "unitC", "1", "5", "6", "5", "category", "8", "10"));
        ingredients2.add(new Ingredient("parmezaan", "bracheY", "supplierB", "3", "unitC", "1", "5", "6", "5", "category", "8", "10"));
        dishes.add(carpaccio);

        dishService.saveDish(hutspot);
        dishService.saveDish(carpaccio);

        return ResponseEntity.ok().body(dish);

    }

}
