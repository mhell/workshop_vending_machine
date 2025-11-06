package se.lexicon.model;

public final class Chips extends Product {
    public Chips(double price, String productName) {
        super(price, productName);
    }

    @Override
    public String examine() {
        return "Chips{" +
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
