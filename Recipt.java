import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recipt {

    // Inner class to represent an item
    static class Item {
        String name;
        double price;

        Item(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    // Method to generate and display the receipt
    public static void generateReceipt(List<Item> items, double taxRate, double discount) {
        // Calculate subtotal
        double subtotal = 0;
        for (Item item : items) {
            subtotal += item.price;
        }

        // Calculate tax
        double tax = subtotal * taxRate / 100;

        // Calculate discount
        double discountAmount = subtotal * discount / 100;

        // Calculate final total
        double finalTotal = subtotal + tax - discountAmount;

        // Display receipt
        System.out.println("\nReceipt");
        System.out.println("------------------------------");
        for (Item item : items) {
            System.out.printf("%s: Rs.%.2f\n", item.name, item.price);
        }
        System.out.println("------------------------------");
        System.out.printf("Subtotal: Rs.%.2f\n", subtotal);
        System.out.printf("Tax (%.2f%%): Rs.%.2f\n", taxRate, tax);
        System.out.printf("Discount (%.2f%%): -Rs.%.2f\n", discount, discountAmount);
        System.out.println("------------------------------");
        System.out.printf("Total: Rs.%.2f\n", finalTotal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Item> items = new ArrayList<>();

        System.out.println("Enter the number of items:");
        int numberOfItems = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Get item details from the user
        for (int i = 0; i < numberOfItems; i++) {
            System.out.println("Enter the name of item " + (i + 1) + ":");
            String itemName = scanner.nextLine();
            System.out.println("Enter the price of " + itemName + ":");
            double itemPrice = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            items.add(new Item(itemName, itemPrice));
        }

        // Get tax rate and discount rate from the user
        System.out.println("Enter the tax rate (in percentage):");
        double taxRate = scanner.nextDouble();
        System.out.println("Enter the discount rate (in percentage):");
        double discount = scanner.nextDouble();

        // Generate and display the receipt
        generateReceipt(items, taxRate, discount);
    }
}
