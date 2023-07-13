package com.shoeventory.posapi.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "merchant_id")
    private Long merchantId;

    @Column(name = "transaction_time")
    private LocalDateTime transactionTime;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    private List<Shoe> shoes;

    // Constructors, getters, and setters

    public Transaction(Long id, Long merchantId, LocalDateTime transactionTime, List<Shoe> shoes) {
        this.id = id;
        this.merchantId = merchantId;
        this.transactionTime = transactionTime;
        this.shoes = shoes;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public List<Shoe> getShoes() {
        return shoes;
    }

    public void setShoes(List<Shoe> shoes) {
        this.shoes = shoes;
    }
}