package com.capgemini.restaurant.controllers;

import com.capgemini.restaurant.models.Dish;
import com.capgemini.restaurant.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DishController {
    @Autowired
    private DishService dishService;

    @CrossOrigin
    @GetMapping("api/dishes/{id}")
    public ResponseEntity<Dish> getDish(@PathVariable(required = true) long id) {
        return ResponseEntity.ok().body(new Dish(id));
    }

    @CrossOrigin
    // TODO: Putmapping
    @PostMapping(value = "api/dish/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity saveDish(@RequestBody final Dish dish) {
        dishService.save(dish);

        return ResponseEntity.ok().body(dish);
    }

    @CrossOrigin
    @GetMapping(value = "api/dishes", produces = "application/json")
    public ResponseEntity<Iterable<Dish>> listDishes() {
        Iterable<Dish> dishes = dishService.listAll();
        return new ResponseEntity<Iterable<Dish>>(dishes, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "api/dishes/findByDescription/{description}", produces = "application/json")
    public ResponseEntity<Iterable<Dish>> findDishesByDescription(@PathVariable(required = true) String description) {
        Iterable<Dish> dishes = dishService.findByDescription(description);
        return new ResponseEntity<Iterable<Dish>>(dishes, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "api/dishes/delete/{id}", produces = "application/json")
    public void deleteDish(@PathVariable long id) {
        dishService.deleteId(id);
    }
}
