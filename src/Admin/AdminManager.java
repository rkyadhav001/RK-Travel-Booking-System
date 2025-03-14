package admin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminManager {
    private static Map<String, Admin> adminUsers = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void registerAdmin() {
        System.out.println("\n=== Admin Registration ===");
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter mobile number: ");
        String mobile = scanner.nextLine();
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        adminUsers.put(email, new Admin(firstName, lastName, mobile, gender, email, password));
        System.out.println("✅ Admin registered successfully!\n");
    }

    public static void loginAdmin() {
        System.out.println("\n=== Admin Login ===");
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Admin admin = adminUsers.get(email);
        if (admin == null) {
            System.out.println("❌ Admin not found!");
            return;
        }

        if (admin.isLocked()) {
            System.out.println("❌ Account is locked due to multiple failed login attempts.");
            return;
        }

        if (!admin.getPassword().equals(password)) {
            admin.incrementFailedCount();
            if (admin.getFailedCount() >= 5) {
                admin.lockAccount();
                System.out.println("❌ Too many failed attempts! Account is now locked.");
            } else {
                System.out.println("❌ Incorrect password! Attempts left: " + (5 - admin.getFailedCount()));
            }
            return;
        }

        System.out.println("✅ Login successful! Welcome, " + email + "\n");
    }
}
