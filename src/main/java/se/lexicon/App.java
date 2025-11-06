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
        System.out.println("All products:");
        System.out.println(Arrays.toString(vendingMachine.getProducts()));

        System.out.println();

        // print one product description
        System.out.print("One existing product: ");
        System.out.println(vendingMachine.getDescription(0));
        System.out.println();
        try {
            System.out.print("One none existing product: ");
            vendingMachine.getDescription(3);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // add currency
        vendingMachine.addCurrency(Currency.FIVE);
        vendingMachine.addCurrency(Currency.TEN);
        vendingMachine.addCurrency(Currency.TEN);
        vendingMachine.addCurrency(Currency.TWO);
        vendingMachine.addCurrency(Currency.TWO);

        System.out.println();

        // get balance
        System.out.println("Current balance: " + vendingMachine.getBalance());

        System.out.println();

        // request something not available
        try {
            System.out.println("Buy something not available: ");
            vendingMachine.request(3);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // request something too expensive
        try {
            System.out.println("Buy something too expensive: ");
            vendingMachine.request(1);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // request something NOT too expensive
        try {
            System.out.println("Buy something NOT too expensive: ");
            Product requested = vendingMachine.request(2);
            System.out.println("You brought: " + requested.examine());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // end session
        int change = vendingMachine.endSession();
        System.out.print("Your change: " + change);

        System.out.println();

        // get balance
        System.out.println("Current balance: " + vendingMachine.getBalance());
    }
}
