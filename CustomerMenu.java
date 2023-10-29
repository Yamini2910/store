import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.Serializable;
public class CustomerMenu implements Serializable {
    private static final long serialVersionUID = 1L;

private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Integer> inventory = new HashMap<>();
    private static Map<String, Integer> shoppingCart = new HashMap<>();
    private static double balance = 100;

    static {
        inventory.put("Bottle", 35);
        inventory.put("Charger", 30);
        inventory.put("Watch", 200);
        inventory.put("pen",5);
        inventory.put("shampoo",25);
    }

    public static void customerMenu(Scanner scanner) {

        while (true) {
            System.out.println("Customer Menu:");
            System.out.println("1- Shop the store");
            System.out.println("2- View and checkout shopping cart");
            System.out.println("3- View balance");
            System.out.println("4- Add balance");
            System.out.println("5- Logout");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    shop();
                    break;
                case 2:
                    viewAndCheckoutCart();
                    break;
                case 3:
                    viewBalance();
                    break;
                case 4:
                    addBalance();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void shop() {
        System.out.println("******** Shop the store ********");
        viewProducts();

        System.out.print("Enter the product you want to add to your cart: ");
        String productName = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        if (inventory.containsKey(productName)) {
            int availableQuantity = inventory.get(productName);
            if (availableQuantity >= quantity) {
                addToCart(productName, quantity);
                System.out.println("Success: The product has been added to your shopping cart.");
            } else {
                System.out.println("Error: The requested quantity is not available.");
            }
        } else {
            System.out.println("Error: Product not found in the inventory.");
        }
    }

    private static void addToCart(String productName, int quantity) {
        if (shoppingCart.containsKey(productName)) {
            int currentQuantity = shoppingCart.get(productName);
            shoppingCart.put(productName, currentQuantity + quantity);
        } else {
            shoppingCart.put(productName, quantity);
        }
    }

    private static void viewAndCheckoutCart() {
        System.out.println("******** View and checkout shopping cart ********");
        double total = 0.0;

        for (Map.Entry<String, Integer> entry : shoppingCart.entrySet()) {
String productName = entry.getKey();
            int quantity = entry.getValue();
            int price = getPrice(productName);
            double itemTotal = price * quantity;

            System.out.println("Name: " + productName);
            System.out.println("Count: " + quantity);
            System.out.println("Price: $" + price);
            System.out.println("Total: $" + itemTotal);
            System.out.println();
            total += itemTotal;
        }

        System.out.println("Your balance: $" + balance);
        System.out.println("Total: $" + total);

        System.out.print("Checkout (Y/N)? ");
        String checkoutChoice = scanner.nextLine();
        if (checkoutChoice.equalsIgnoreCase("Y")) {
            if (total <= balance) {
                balance -= total;
                shoppingCart.clear();
                System.out.println("Thank you for shopping at The Detective Conan Store");
                System.out.println("Your new balance: $" + balance);
            } else {
                System.out.println("Error: Insufficient balance. Remove items from your cart or add more balance.");
            }
        }
    }

    private static int getPrice(String productName) {
        if (inventory.containsKey(productName)) {
            return inventory.get(productName);
        } else {
            System.out.println("Product not found");
        }
        return 0;
    }

    private static void viewBalance() {
        System.out.println("Your current balance: $" + balance);
    }private static void addBalance() {
        System.out.println("Welcome to the Detective Conan Store Mini Game!");
        System.out.println("Guess the number between 1 and 10 to win $100.");

        int randomNumber = (int) (Math.random() * 10) + 1;
        System.out.print("Enter your guess: ");
        int userGuess = scanner.nextInt();

        if (userGuess == randomNumber) {
            balance += 100;
            System.out.println("Congratulations! You won $100. Your new balance: $" + balance);
        } else {
            System.out.println("Sorry, you didn't guess correctly. Your balance remains unchanged.");
        }
    }
    private static void viewProducts() {
        System.out.println("Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println("Name: " + entry.getKey());
            System.out.println("Count: " + entry.getValue());
            System.out.println();
        }
    }
}
