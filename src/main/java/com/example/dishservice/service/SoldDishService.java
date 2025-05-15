package com.example.dishservice.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dishservice.model.SoldDish;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class SoldDishService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<SoldDish> getSoldDishesBySeller(Long sellerId) {
        String jpql = "SELECT s FROM SoldDish s WHERE s.sellerId = :sellerId";
        return entityManager.createQuery(jpql, SoldDish.class)
                .setParameter("sellerId", sellerId)
                .getResultList();
    }

    public SoldDish recordSale(SoldDish soldDish) {
        entityManager.persist(soldDish);
        return soldDish;
    }
}
