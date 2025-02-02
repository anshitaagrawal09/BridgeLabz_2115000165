public class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;
    // Default constructor
    public HotelBooking() {
        this.guestName = "Unknown";
        this.roomType = "Standard";
        this.nights = 1;
    }
    // Parameterized constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }
    // Copy constructor (Clones another booking)
    public HotelBooking(HotelBooking anotherBooking) {
        this.guestName = anotherBooking.guestName;
        this.roomType = anotherBooking.roomType;
        this.nights = anotherBooking.nights;
    }
    // Getter methods
    public String getGuestName() {
        return guestName;
    }
    public String getRoomType() {
        return roomType;
    }
    public int getNights() {
        return nights;
    }
    // Setter methods
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public void setNights(int nights) {
        this.nights = nights;
    }
    // Display booking details
    public void displayBookingDetails() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }
    public static void main(String[] args) {
        // Using default constructor
        HotelBooking booking1 = new HotelBooking();
        // Using parameterized constructor
        HotelBooking booking2 = new HotelBooking("Alice Johnson", "Suite", 3);
        // Using copy constructor to clone booking2
        HotelBooking booking3 = new HotelBooking(booking2);
        // Display booking details
        System.out.println("Booking 1 (Default):");
        booking1.displayBookingDetails();        
        System.out.println("\nBooking 2 (Parameterized):");
        booking2.displayBookingDetails();        
        System.out.println("\nBooking 3 (Cloned from Booking 2):");
        booking3.displayBookingDetails();
    }
}
