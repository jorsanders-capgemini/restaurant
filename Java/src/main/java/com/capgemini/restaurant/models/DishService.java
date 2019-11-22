package com.capgemini.restaurant.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    public void saveDish(Dish dish) {
        dishRepository.save(dish);
    }

    public Iterable<Dish> listAll() {
        return dishRepository.findAll();
    }
}
