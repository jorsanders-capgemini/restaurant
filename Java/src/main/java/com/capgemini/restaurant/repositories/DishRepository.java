package com.capgemini.restaurant.repositories;

import com.capgemini.restaurant.models.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends CrudRepository<Dish, Long> {

    Iterable<Dish> findByDescriptionContainingIgnoreCase(String description);

    void deleteById(long id);
}
