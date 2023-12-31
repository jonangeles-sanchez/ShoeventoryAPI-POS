package com.shoeventory.posapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String transactionTime;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    private List<Shoe> shoes;

    // Constructors, getters, and setters

    public Transaction() {
    }

    public Transaction(Long id, Long merchantId, String transactionTime, List<Shoe> shoes) {
        this.id = id;
        this.merchantId = merchantId;
        this.transactionTime = transactionTime;
        this.shoes = shoes;
    }

    public Transaction(Long merchantId, String transactionTime) {
        this.merchantId = merchantId;
        this.transactionTime = transactionTime;
        this.shoes = shoes;
    }

    public Transaction(Long merchantId, String transactionTime, List<Shoe> shoes) {
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

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public List<Shoe> getShoes() {
        return shoes;
    }

    public void setShoes(List<Shoe> shoes) {
        this.shoes = shoes;
    }

    @Override
    public String toString() {
        return "Transaction[id=" + id + ", merchantId=" + merchantId + ", transactionTime=" + transactionTime +
                ", shoes=" + shoes + "]";
    }
}