package ru.geekbrains.homework2;

import java.util.Random;

public class Product {
    private Long id;
    private String name;
    private double price;

    private static Random random = new Random();
    private static final int MIN_PRICE = 1;
    private static final int maxPrice = 1000;

    public Product(Long id) {
        this.id = id;
        this.name = String.format("Item %d", id);
        this.price = generateRandomPrice();
    }

    private double generateRandomPrice() {
        return MIN_PRICE + (maxPrice - MIN_PRICE) + random.nextDouble();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}