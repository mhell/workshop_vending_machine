package se.lexicon;

import se.lexicon.model.*;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Product soda = new Soda(23, "Coca Cola");
        Product chips = new Chips(30, "Potato");
        Product chocolate = new Chocolate(15, "Mars");

        Product[] products = new Product[]{soda, chips, chocolate};

        VendingMachineImpl vendingMachine = new VendingMachineImpl(products);

        // print all products
        System.out.println(Arrays.toString(vendingMachine.getProducts()));

        // print one product description
        System.out.println(vendingMachine.getDescription(0));

        // add currency
        vendingMachine.addCurrency(Currency.FIVE);
        vendingMachine.addCurrency(Currency.TEN);
        vendingMachine.addCurrency(Currency.TEN);
        vendingMachine.addCurrency(Currency.TWO);
        vendingMachine.addCurrency(Currency.TWO);

        // get balance
        System.out.println(vendingMachine.getBalance());

        // request something too expensive
        try {
            Product requested = vendingMachine.request(1);
            System.out.println("You brought: " + requested.getProductName());
        } catch (RuntimeException e) {
            System.out.println("Too expensive!");
        }

        // request something NOT too expensive
        try {
            Product requested = vendingMachine.request(2);
            System.out.println("You brought: " + requested.getProductName());
        } catch (RuntimeException e) {
            System.out.println("Too expensive!");
        }

        // end session
        int change = vendingMachine.endSession();
        System.out.println("change: " + change);

        // get balance
        System.out.println(vendingMachine.getBalance());
    }
}
