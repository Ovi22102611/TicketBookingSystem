
/**
 * Write a description of class Ticket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ticket {
    private Seat seat;
    private double price;
    private double discount;

    public Ticket(Seat seat, Promotion promotion) {
        this.seat = seat;
        this.discount = promotion.getDiscount();
        this.price = seat.getPrice() - discount;
    }

    // Method to get the final price of the ticket
    public double getFinalPrice() {
        return this.price;
    }

    // Getters
    public Seat getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    // Setters
    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}