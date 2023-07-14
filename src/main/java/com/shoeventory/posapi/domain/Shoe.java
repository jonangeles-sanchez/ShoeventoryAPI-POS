package com.shoeventory.posapi.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "shoes")
public class Shoe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String manufacturer;

    @Column
    private String type;

    @Column
    private String name;

    @Column
    private String color;

    @Column
    private double size;

    @Column
    private int quantity;

    @Column
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    // Constructors, getters, and setters

    public Shoe(Long id, String manufacturer, String type, String name, String color, double size, int quantity, double price, Transaction transaction) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.type = type;
        this.name = name;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.transaction = transaction;
    }

    public Shoe(String manufacturer, String type, String name, String color, double size, int quantity, double price, Transaction transaction) {
        this.manufacturer = manufacturer;
        this.type = type;
        this.name = name;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.transaction = transaction;
    }

    public Shoe(String manufacturer, String type, String name, String color, double size, int quantity, double price) {
        this.manufacturer = manufacturer;
        this.type = type;
        this.name = name;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Shoe[id=" + id + ", manufacturer=" + manufacturer + ", type=" + type +
                ", name=" + name + ", color=" + color + ", size=" + size +
                ", quantity=" + quantity + ", price=" + price + "]";
    }
}