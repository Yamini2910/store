import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.Serializable;

public class User implements Serializable {
    private static Map<String, String> users = new HashMap<>();
    private static Map<String, Integer> inventory = new HashMap<>(); 
    private static String currentUser;

    static {
        users.put("admin", "12345");
        inventory.put("Anywhere Ball Dispensing Belt", 50);
        inventory.put("Criminal tracking glasses", 30);
        inventory.put("Stun-Gun Wristwatch", 200);
    }
    private static final long serialVersionUID = 1L;

    public static void login(Scanner scanner) { 
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            currentUser = username;
            if (username.equals("admin")) {
                AdminMenu.adminMenu(scanner);
            } else {
                CustomerMenu.customerMenu(scanner);
            }
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }



    public static void register(Scanner scanner) {
        System.out.print("Enter new username: ");
        String newUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String newPassword = scanner.nextLine();
        users.put(newUsername, newPassword);
        System.out.println("Account created successfully. Please login.");
    }
    public static boolean registerUser(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, password);
            inventory.put(username, 0); 
            return true;
        }
        return false; 
    }
    public static boolean validateUser(String username, String password) {
    if (users.containsKey(username) && users.get(username).equals(password)) {
        currentUser = username;
        return true;
    }
    return false;
}
public static void printInventory() {
        System.out.println("Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println("Name: " + entry.getKey());
            System.out.println("Count: " + entry.getValue());
            System.out.println();
        }
    }
public static boolean isAdmin() {
    return currentUser.equals("admin");
}


    public static Map<String, Integer> getInventory() {
        return inventory;
    }
}
