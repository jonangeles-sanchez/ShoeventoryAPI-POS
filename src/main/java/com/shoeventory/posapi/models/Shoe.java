package com.shoeventory.posapi.models;

import com.shoeventory.posapi.models.Transaction;
import jakarta.persistence.*;

@Entity
public class Shoe {
    @Id
    @SequenceGenerator(
            name = "shoe_sequence",
            sequenceName = "shoe_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shoe_sequence"
    )
    private Integer id;
    private String manufacturer;
    private String type;
    private String name;
    private String color;
    private String size;
    private Integer quantity;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    // Constructors, getters, and setters


    public Shoe(String manufacturer, String type, String name, String color, String size, Integer quantity, Integer price, Transaction transaction) {
        this.manufacturer = manufacturer;
        this.type = type;
        this.name = name;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.transaction = transaction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}