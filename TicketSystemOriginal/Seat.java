
/**
 * Write a description of class Seat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Seat {
    private int seatNumber;
    private String status; // "available", "held", "sold"
    private double price;

    public Seat(int seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
        this.status = "available";
    }

    // Methods to manage seat status
    public boolean isAvailable() {
        return status.equals("available");
    }

    public void holdSeat() {
        this.status = "held";
    }

    public void releaseSeat() {
        this.status = "available";
    }

    public void sellSeat() {
        this.status = "sold";
    }

    // Getters and Setters
    public int getSeatNumber() {
        return seatNumber;
    }

    public String getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}