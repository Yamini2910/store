import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.Map;
import java.util.Scanner;

public class Shopping {
    private static double balance = 100.0;
    private static Map<String, Integer> inventory;

    public static void setInventory(Map<String, Integer> inventory) {
        Shopping.inventory = inventory;
    }

    public static void shop(Scanner scanner) {
        System.out.print("Enter the product you want to purchase: ");
        String productName = scanner.nextLine();
        System.out.print("Enter the quantity you want to purchase: ");
        int quantityToPurchase = scanner.nextInt();
        scanner.nextLine(); 

        if (inventory.containsKey(productName)) {
            int availableQuantity = inventory.get(productName);
            if (availableQuantity >= quantityToPurchase) {
                inventory.put(productName, availableQuantity - quantityToPurchase);
                System.out.println("Purchase successful! Thank you for shopping with us.");
            } else {
                System.out.println("Sorry, the requested quantity is not available.");
            }
        } else {
            System.out.println("Product not found in the inventory.");
        }
    }
}


