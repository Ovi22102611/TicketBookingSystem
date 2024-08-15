
/**
 * Write a description of class Agent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.List;

public class Agent extends User {
    private List<Seat> assignedSeats; // List of seats assigned to this agent

    public Agent(String name, String email, String password) {
        super(name, email, password); // Call the constructor of the parent User class
        this.assignedSeats = new ArrayList<>(); // Initialize the list of assigned seats
    }

    // Method to add a seat to the agent's assigned seats list
    public void addAssignedSeat(Seat seat) {
        if (seat != null) { // Check to avoid adding null objects
            assignedSeats.add(seat);
        }
    }

    // Getter for the list of assigned seats
    public List<Seat> getAssignedSeats() {
        return new ArrayList<>(assignedSeats); // Return a copy to prevent external modification
    }
}