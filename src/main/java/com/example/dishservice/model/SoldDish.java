package com.example.dishservice.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sold_dishes")
public class SoldDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long dishId;
    private Long sellerId;
    private Long customerId;
    private String shippingCompany;
    private int quantitySold;
    private LocalDateTime soldAt;

    // Default constructor (required by JPA)
    public SoldDish() {
    }

    // All-args constructor (excluding ID since it's auto-generated)
    public SoldDish(Long dishId, Long sellerId, Long customerId, String shippingCompany, int quantitySold, LocalDateTime soldAt) {
        this.dishId = dishId;
        this.sellerId = sellerId;
        this.customerId = customerId;
        this.shippingCompany = shippingCompany;
        this.quantitySold = quantitySold;
        this.soldAt = soldAt;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public LocalDateTime getSoldAt() {
        return soldAt;
    }

    public void setSoldAt(LocalDateTime soldAt) {
        this.soldAt = soldAt;
    }
}
