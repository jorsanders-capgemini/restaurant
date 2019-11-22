package com.capgemini.restaurant.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends CrudRepository<Dish, Long> {

    Iterable<Dish> findByDescription(String description);

    Iterable<Dish> findByDescriptionContainingIgnoreCase(String description);

}
