package se.lexicon.model;

//TODO: use

public class Chocolate implements Product {
    private final int id;
    private double price;
    private String productName;

    public Chocolate(double price, String productName) {
        this.id = Product.nextId();
        this.price = price;
        this.productName = productName;
    }

    @Override
    public String examine() {
        return "Chocolate{" +
                "id=" + getId() +
                ", price=" + getPrice() +
                ", productName='" + getProductName() + '\'' +
                '}';
    }

    @Override
    public String use() {
        return "Chocolate is eaten.";
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public void setProductName(String productName) {
        this.productName = productName;
    }
}
