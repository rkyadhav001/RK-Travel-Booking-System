import admin.AdminManager;
import booking.BookingManager;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        displayLogo(); // Load company logo
        showMenu(); // Display options
    }
private static void displayLogo() {
    try {
        String logoPath = Paths.get("assets/logo.txt").toString(); // Moves one level up from bin/
        String logo = new String(Files.readAllBytes(Paths.get(logoPath)));
        System.out.println(logo);
    } catch (IOException e) {
        System.out.println("Error: Unable to load company logo. Exiting...");
        System.exit(1);
    }
}


    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== RK Travels Booking System ===");
            System.out.println("1. Admin Registration");
            System.out.println("2. Lock Account");
            System.out.println("3. Plan Journey");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
          switch (choice) {
    case 1:
        AdminManager.registerAdmin();  // Calls actual method
        break;
    case 2:
        AdminManager.loginAdmin();  // Calls login method
        break;
    case 3:
        BookingManager.planJourney();  // Calls journey booking method
        break;
    case 4:
        System.out.println("Exiting... Thank you for using RK Travels!");
        scanner.close();
        System.exit(0);
    default:
        System.out.println("Invalid choice. Try again.");
}

        }
    }
}
