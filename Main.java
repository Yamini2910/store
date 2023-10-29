import java.util.Scanner;
public class Main {
    Object savedData; 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Object savedData = DataManager.loadData();
         scanner = new Scanner(System.in);
        User user = null;
        CustomerMenu customerMenu = null;
        AdminMenu adminMenu = null;
        if (savedData != null) {
            if (savedData instanceof User) {
                user = (User) savedData;
            }
            if (savedData instanceof CustomerMenu) {
                customerMenu = (CustomerMenu) savedData;
            }
            if (savedData instanceof AdminMenu) {
                adminMenu = (AdminMenu) savedData;
            }
        } else {
            
            user = new User();
            customerMenu = new CustomerMenu();
            adminMenu = new AdminMenu();
        }
        while (true) {
            System.out.println("******** Welcome to The Detective Conan Store ********");
            System.out.println("1- Login");
            System.out.println("2- Register");
            System.out.println("3- Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                if (User.validateUser(username, password)) {
                    if (User.isAdmin()) {
                       AdminMenu.adminMenu(scanner);
                } else {
                      CustomerMenu.customerMenu(scanner);
                    }
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                }
            } else if (choice == 2) {
                System.out.print("Enter new username: ");
                String newUsername = scanner.nextLine();
                System.out.print("Enter password: ");
                String newPassword = scanner.nextLine();
                if (newPassword.length() == 5) {
           if (User.registerUser(newUsername, newPassword)) {
            System.out.println("Account created successfully. Please login.");
        } else {
            System.out.println("Registration failed. Username already exists.");
        }
    } else {
        System.out.println("Error: Password must be at least 5 characters long.");
    }
        }
        else if(choice ==3){
            System.out.println("Exiting the program. Goodbye!");
            System.exit(0);
        }
        DataManager.saveData(user);
        DataManager.saveData(customerMenu);
        DataManager.saveData(adminMenu);
    }
    }
}
