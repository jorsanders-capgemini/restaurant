package com.capgemini.restaurant.services;

import com.capgemini.restaurant.models.Dish;
import com.capgemini.restaurant.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    public void save(Dish dish) {
        dishRepository.save(dish);
    }

    public Iterable<Dish> listAll() {
        return dishRepository.findAll();
    }

    public Iterable<Dish> findByDescription(String description) {
        return dishRepository.findByDescriptionContainingIgnoreCase(description);
    }

    public void deleteId(Long id) {
        dishRepository.deleteById(id);
    }
}
