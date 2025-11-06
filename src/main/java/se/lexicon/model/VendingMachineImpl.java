package se.lexicon.model;

import java.util.Arrays;

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
        int foundPos = -1;
        for (Product product : products) {
            if (product.getId() == id) {
                foundPos = id;
                break;
            }
        }
        // the product was not found
        if(foundPos == -1) throw new RuntimeException("Product was not found");

        // the product was found
        Product foundProduct = products[foundPos];
        // check balance
        if (getBalance() > foundProduct.getPrice()) {
            // remove price from depositPool
            depositPool -= (int) Math.ceil(foundProduct.getPrice());
            // remove the product from products
            Product[] newProducts = Arrays.copyOf(products, products.length - 1);
            // if not found at the end of the array
            if (foundPos != products.length - 1) {
                // remove found product by merging with offset
                System.arraycopy(products, foundPos + 1, newProducts, foundPos, products.length - foundPos);
                // reassign products
            }
            products = newProducts;
            // return the product
            return foundProduct;
        } else {
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
