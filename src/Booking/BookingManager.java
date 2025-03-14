package booking;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingManager {
    private static List<Booking> bookings = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void planJourney() {
        System.out.println("\n=== Plan Your Journey ===");
        System.out.print("Enter source: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter travel date (YYYY-MM-DD): ");
        LocalDate travelDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter number of passengers: ");
        int passengers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        double baseFare = 500.0;
        double totalFare = baseFare * passengers;
        if (travelDate.getDayOfWeek() == DayOfWeek.SATURDAY || travelDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            totalFare += 200; // Surge Pricing
        }
        totalFare += totalFare * 0.05; // GST 5%

        bookings.add(new Booking(source, destination, travelDate, passengers, totalFare));
        System.out.println("✅ Booking confirmed! Total Fare: Rs. " + totalFare + "\n");
    }
}
