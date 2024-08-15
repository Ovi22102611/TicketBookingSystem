
/**
 * Write a description of class TicketMachineSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

public class TicketMachineSystem {
    private List<Event> events;
    private Payment payment;

    public TicketMachineSystem() {
        this.events = new ArrayList<>();
        this.payment = new Payment();
    }

    // Method to add an event to the system
    public void addEvent(Event event) {
        events.add(event);
    }

    // Method to find an event by its name
    public Event findEvent(String eventName) {
        return events.stream().filter(event -> event.getEventName().equals(eventName)).findFirst().orElse(null);
    }

    // Method to book a seat for a consumer
    public void bookSeat(Consumer consumer, String eventName, int seatNumber, String cardNumber, Promotion promotion) {
        Event event = findEvent(eventName);
        if (event != null) {
            Seat selectedSeat = event.getAvailableSeats().stream()
                    .filter(seat -> seat.getSeatNumber() == seatNumber)
                    .findFirst()
                    .orElse(null);

            if (selectedSeat != null) {
                selectedSeat.holdSeat(); // Holds the seat temporarily
                Ticket ticket = new Ticket(selectedSeat, promotion);
                if (payment.processCreditCard(cardNumber, ticket.getFinalPrice())) {
                    selectedSeat.sellSeat(); // Sells the seat if payment is successful
                    System.out.println("Ticket booked successfully for " + consumer.getName());
                } else {
                    selectedSeat.releaseSeat(); // Releases the seat if payment fails
                    System.out.println("Payment failed.");
                }
            } else {
                System.out.println("Seat not available.");
            }
        } else {
            System.out.println("Event not found.");
        }
    }

    // Main method to run the system
    public static void main(String[] args) {
        // Set up the system
        TicketMachineSystem system = new TicketMachineSystem();
        
        // Create a specific date using Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JULY, 20); // Setting the date to July 20, 2023
        Date eventDate = calendar.getTime();

        // Create a sample event with the specified date
        Event concert = new Event("Rock Concert", eventDate);

        // Add the event to the system
        system.addEvent(concert);

        // (Optional) Print out the event's details to verify
        System.out.println("Event: " + concert.getEventName() + ", Date: " + concert.getEventDate());

        // Continue with other system operations like booking a seat...
        // Example: Create a consumer and book a seat
        Consumer john = new Consumer("John Doe", "john@example.com", "password123");
        Promotion studentDiscount = new Promotion("Student Discount", 10.00);
        system.bookSeat(john, "Rock Concert", 1, "1234-5678-9012-3456", studentDiscount);
    }
}