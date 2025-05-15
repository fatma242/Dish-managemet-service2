package com.example.dishservice.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.dishservice.model.Dish;
import com.example.dishservice.service.DishService;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api/dishes")
public class DishController {

    private final DishService dishService;


    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<List<Dish>> getSellerDishes(@PathVariable Long sellerId) {
        try {
            List<Dish> dishes = dishService.getDishesBySeller(sellerId);
            return ResponseEntity.ok(dishes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addDish(@RequestBody Dish dish) {
        try {
            Dish savedDish = dishService.addDish(dish);
            return ResponseEntity.ok(savedDish); // Return 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("dish already exist"); // Return 409 Conflict
        }

    }

    @PutMapping("/{name}")
    public ResponseEntity<?> updateDish(@PathVariable String name, @RequestBody Dish dish) {
        try {
            Dish updatedDish = dishService.updateDish(name, dish);
            return ResponseEntity.ok(updatedDish);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dish not found");
        }
    }
}
