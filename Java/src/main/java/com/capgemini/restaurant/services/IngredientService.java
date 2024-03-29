package com.capgemini.restaurant.services;

import com.capgemini.restaurant.models.Ingredient;
import com.capgemini.restaurant.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public void save(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public Iterable<Ingredient> listAll() {
        return ingredientRepository.findAll();
    }

    public Iterable<Ingredient> findByDescription(String name) {
        return ingredientRepository.findByNameContainingIgnoreCase(name);
    }

    public void deleteId(Long id) {
        ingredientRepository.deleteById(id);
    }
}
