package se.lexicon.model;

public interface VendingMachine {
    void addCurrency(Currency amount);
    int getBalance();
    Product request(int id);
    int endSession();
    String getDescription(int id);
    String[] getProducts();
}
