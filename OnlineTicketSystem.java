
// Node class representing a booked ticket
class TicketNode {
    int ticketID;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    TicketNode next;
    // Constructor
    public TicketNode(int ticketID, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

// Circular Linked List for Ticket Reservation System
class TicketReservationSystem {
    private TicketNode head = null;
    private TicketNode tail = null;
    private int totalTickets = 0;

    // Add a new ticket reservation at the end
    public void bookTicket(int ticketID, String customerName, String movieName, int seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketID, customerName, movieName, seatNumber, bookingTime);
       
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            tail.next = head; // Circular link
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; // Maintain circular structure
        }
        totalTickets++;
    }

    // Remove a ticket by Ticket ID
    public void cancelTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode current = head, prev = null;

        // Search for the ticket to remove
        do {
            if (current.ticketID == ticketID) {
                if (current == head && current == tail) { // Only one ticket in the list
                    head = tail = null;
                } else if (current == head) { // Removing head
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) { // Removing tail
                    prev.next = head;
                    tail = prev;
                } else { // Removing from middle
                    prev.next = current.next;
                }
                totalTickets--;
                System.out.println("Ticket " + ticketID + " cancelled.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket not found.");
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = head;
        System.out.println("Booked Tickets:");
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName +", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber +", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket Found - ID: " + temp.ticketID + ", Customer: " + temp.customerName +", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber +", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for: " + query);
        }
    }

    // Get total number of booked tickets
    public int getTotalTickets() {
        return totalTickets;
    }
}

// Main class to test the Ticket Reservation System
public class OnlineTicketSystem {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Booking tickets
        system.bookTicket(101, "Alice", "Inception", 5, "10:00 AM");
        system.bookTicket(102, "Bob", "Interstellar", 8, "2:00 PM");
        system.bookTicket(103, "Charlie", "Inception", 12, "6:00 PM");

        // Display all tickets
        system.displayTickets();

        // Search for a ticket
        system.searchTicket("Inception");

        // Cancel a ticket
        system.cancelTicket(102);

        // Display all tickets after cancellation
        system.displayTickets();

        // Get total tickets
        System.out.println("Total Tickets Booked: " + system.getTotalTickets());
    }
}

