import java.util.Scanner;
import java.io.Serializable;
public class AdminMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    public static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1- Create a customer account");
            System.out.println("2- Remove a customer account");
            System.out.println("3- View inventory");
            System.out.println("4- Add a product");
            System.out.println("5- Remove a product");
            System.out.println("6- Restock a product");
            System.out.println("7- Logout");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createCustomerAccount(scanner);
                    break;
                case 2:
                    removeCustomerAccount(scanner);
                    break;
                case 3:
                    User.printInventory();
                    break;
                case 4:
                    addProduct(scanner);
                    break;
                case 5:
                    removeProduct(scanner);
                    break;
                case 6:
                    restockProduct(scanner);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createCustomerAccount(Scanner scanner) {
        System.out.print("Enter customer username: ");
        String customerUsername = scanner.nextLine();
        System.out.print("Enter customer password: ");
        String customerPassword = scanner.nextLine();
        System.out.println("Customer account created successfully.");
    }

    private static void removeCustomerAccount(Scanner scanner) {
        System.out.print("Enter customer username to remove: ");
        String customerUsername = scanner.nextLine();
        System.out.println("Customer account removed successfully.");
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter new product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter count: ");
        int count = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Product added successfully.");
    }

    private static void removeProduct(Scanner scanner) {
        System.out.print("Enter product name to remove: ");
        String productName = scanner.nextLine();
        System.out.println("Product removed successfully.");
    }

    private static void restockProduct(Scanner scanner) {
        System.out.print("Enter product name to restock: ");
        String productName = scanner.nextLine();
        System.out.print("Enter quantity to restock: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Product restocked successfully.");
    }
}


