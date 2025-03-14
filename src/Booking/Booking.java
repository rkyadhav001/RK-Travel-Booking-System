package booking;

import java.time.LocalDate;

public class Booking {
    private String source, destination;
    private LocalDate travelDate;
    private int passengers;
    private double fare;

    public Booking(String source, String destination, LocalDate travelDate, int passengers, double fare) {
        this.source = source;
        this.destination = destination;
        this.travelDate = travelDate;
        this.passengers = passengers;
        this.fare = fare;
    }
}
