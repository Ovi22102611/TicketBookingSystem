
/**
 * Write a description of class Event here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class Event {
    private String eventName;
    private Date eventDate;
    private List<Seat> seats;

    public Event(String eventName, Date eventDate) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.seats = new ArrayList<>();
    }

    // Method to add a seat to the event
    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    // Method to get a list of available seats
    public List<Seat> getAvailableSeats() {
        return seats.stream().filter(Seat::isAvailable).collect(Collectors.toList());
    }

    // Getters and Setters
    public String getEventName() {
        return eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}