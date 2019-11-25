package com.capgemini.restaurant.repositories;

import com.capgemini.restaurant.models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    Iterable<Ingredient> findByNameContainingIgnoreCase(String name);

    void deleteById(long id);
}
