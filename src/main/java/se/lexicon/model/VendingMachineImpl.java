package se.lexicon.model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

public class VendingMachineImpl implements VendingMachine {
    private Product[] products;
    private int depositPool;

    public VendingMachineImpl(Product[] products) {
        this.products = products;
    }

    @Override
    public void addCurrency(Currency amount) {
        depositPool += amount.getValue();
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        // check if product exists
        int indexFoundAt = -1;
        for (Product product : products) {
            if (product.getId() == id) {
                indexFoundAt = id;
                break;
            }
        }
        // if not found
        if (indexFoundAt == -1) throw new RuntimeException("Product was not found");

        // if found
        // get the product
        Product foundProduct = products[indexFoundAt];

        // check balance
        if (getBalance() > foundProduct.getPrice()) {
            // remove price from balance
            depositPool -= (int) Math.ceil(foundProduct.getPrice());

            // remove the product from array
            Product[] newProducts = new Product[products.length - 1];
            for (int i = 0, j = 0; i < products.length; i++) {
                if (products[i] != foundProduct) {
                    newProducts[j] = products[i];
                    j++;
                }
            }
            products = newProducts;

            // return the product
            return foundProduct;
        }
        else {
            throw new RuntimeException("Insufficient balance");
        }
    }

    @Override
    public int endSession() {
        int temp = depositPool;
        depositPool = 0;
        return temp;
    }

    @Override
    public String getDescription(int id) {
        // find product with id in products
        for (Product product : products) {
            if (product.getId() == id)
                // return found product
                return product.examine();
        }
        // product was not found
        throw new RuntimeException("Product was not found");
    }

    @Override
    public String[] getProducts() {
        String[] descriptions = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            descriptions[i] = products[i].examine();
        }
        return descriptions;
    }
}
