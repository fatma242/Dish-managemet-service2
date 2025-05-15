package com.example.dishservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dishservice.model.Dish;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class DishService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Dish> getDishesBySeller(Long sellerId) {
        String jpql = "SELECT d FROM Dish d WHERE d.sellerId = :sellerId";
        return entityManager.createQuery(jpql, Dish.class)
                .setParameter("sellerId", sellerId)
                .getResultList();
    }
    
    public Dish addDish(Dish dish) {
        entityManager.persist(dish);
        return dish;
    }

    public Dish updateDish(String name, Dish updatedDish) {
        Dish existingDish = getDishByName(name);
        if (existingDish == null) {
            throw new RuntimeException("Dish not found");
        }
        existingDish.setName(updatedDish.getName());
        existingDish.setDescription(updatedDish.getDescription());
        existingDish.setPrice(updatedDish.getPrice());
        existingDish.setQuantity(updatedDish.getQuantity());

        return entityManager.merge(existingDish);
    }


    public Dish getDishByName(String name) {
        String jpql = "SELECT d FROM Dish d WHERE d.name = :name";
        return entityManager.createQuery(jpql, Dish.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
