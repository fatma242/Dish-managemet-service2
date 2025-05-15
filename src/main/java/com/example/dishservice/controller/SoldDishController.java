package com.example.dishservice.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dishservice.model.SoldDish;
import com.example.dishservice.service.SoldDishService;

@RestController
@RequestMapping("/api/sold-dishes")
public class SoldDishController {

    private final SoldDishService soldDishService;

    public SoldDishController(SoldDishService soldDishService) {
        this.soldDishService = soldDishService;
    }

    @GetMapping("/seller/{sellerId}")
    public List<SoldDish> getSoldDishesBySeller(@PathVariable Long sellerId) {
        return soldDishService.getSoldDishesBySeller(sellerId);
    }

    @PostMapping
    public SoldDish recordSoldDish(@RequestBody SoldDish soldDish) {
        return soldDishService.recordSale(soldDish);
    }
}
