package se.lexicon.model;

public final class Chocolate extends Product {
    public Chocolate(double price, String productName) {
        super(price, productName);
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
        return getProductName() + " is eaten.";
    }
}
