public class Visitor extends Person {
    private String ticketType;
    private boolean hasRidePass;

    // Default constructor
    public Visitor() {
        super();
        this.ticketType = "General";
        this.hasRidePass = false;
    }

    // Constructor with parameters
    public Visitor(String name, int age, String gender, String ticketType, boolean hasRidePass) {
        super(name, age, gender);
        this.ticketType = ticketType;
        this.hasRidePass = hasRidePass;
    }

    // Getters and setters
    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public boolean hasRidePass() {
        return hasRidePass;
    }

    public void setHasRidePass(boolean hasRidePass) {
        this.hasRidePass = hasRidePass;
    }
}

