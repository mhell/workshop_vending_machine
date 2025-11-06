package se.lexicon.model;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Product {
    private static final AtomicInteger SEQUENCER = new AtomicInteger(0);
    private final int id;
    private double price;
    private String productName;

    public Product(double price, String productName) {
        this.id = nextId();
        setPrice(price);
        setProductName(productName);
    }

    private static int nextId() {
        return SEQUENCER.getAndIncrement();
    }

    public abstract String examine();
    public abstract String use();

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}