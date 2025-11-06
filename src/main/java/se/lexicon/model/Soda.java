package se.lexicon.model;

public final class Soda extends Product {
    public Soda(double price, String productName) {
        super(price, productName);
    }

    @Override
    public String examine() {
        return "Soda{" +
                "id=" + getId() +
                ", price=" + getPrice() +
                ", productName='" + getProductName() + '\'' +
                '}';
    }

    @Override
    public String use() {
        return getProductName() + " is drunk.";
    }
}
