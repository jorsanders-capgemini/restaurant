package com.capgemini.restaurant.controllers;

import com.capgemini.restaurant.models.Dish;
import com.capgemini.restaurant.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DishController {
    private DishService dishService;

    @Autowired
    DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @CrossOrigin
    @GetMapping(value = "api/dishes", produces = "application/json")
    public ResponseEntity<Iterable<Dish>> listAll() {
        Iterable<Dish> dishes = dishService.listAll();
        return new ResponseEntity<Iterable<Dish>>(dishes, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping
    public void create(){
       //todo
    }

    @CrossOrigin
    @GetMapping("api/dishes/{id}")
    public ResponseEntity<Dish> getDish(@PathVariable(required = true) long id) {
        // TODO get from service
        return ResponseEntity.ok().body(new Dish(id));
    }

    @CrossOrigin
    @PutMapping(value = "api/dish/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity saveDish(@RequestBody final Dish dish) {
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
