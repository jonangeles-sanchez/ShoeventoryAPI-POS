package com.shoeventory.posapi.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Transaction {

    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence"
    )
    private Integer id;
    private Integer merchantId;
    private Integer time;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    private Set<Shoe> shoes;
    private Double total;
    private Integer pairsSold;

    // Constructors, getters, and setters


    public Transaction(Integer merchantId, Integer time, Set<Shoe> shoes) {
        this.merchantId = merchantId;
        this.time = time;
        this.shoes = shoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Set<Shoe> getShoes() {
        return shoes;
    }

    public void setShoes(Set<Shoe> shoes) {
        this.shoes = shoes;
    }
}
