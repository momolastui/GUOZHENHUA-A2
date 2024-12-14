import java.util.Objects;

public class Visitor extends Person {
    private boolean isVIP;  // Indicates whether the visitor is a VIP
    private int visitorID;  // The unique ID of the visitor

    // Constructor
    public Visitor(String name, int age, String address, boolean isVIP, int visitorID) {
        super(name, age, address);  // Call the parent class constructor to initialize name, age, and address
        this.isVIP = isVIP;
        this.visitorID = visitorID;
    }

    // Getter and Setter methods
    public boolean getIsVIP() {
        return isVIP;
    }

    public void setIsVIP(boolean isVIP) {
        this.isVIP = isVIP;
    }

    public int getVisitorID() {
        return visitorID;
    }

    public void setVisitorID(int visitorID) {
        this.visitorID = visitorID;
    }

    // Override the toString method for easy output of visitor information
    @Override
    public String toString() {
        return String.format("Visitor{name='%s', age=%d, address='%s', isVIP=%b, visitorID=%d}",
                getName(), getAge(), getAddress(), isVIP, visitorID);
    }

    // Override the equals method to ensure visitors are compared by visitorID
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // If it's the same object, return true directly
        if (obj == null || getClass() != obj.getClass()) return false;  // Null object or type mismatch returns false
        Visitor visitor = (Visitor) obj;  // Cast to Visitor class
        return visitorID == visitor.visitorID;  // Compare based on visitorID
    }

    // Override the hashCode method to be consistent with equals
    @Override
    public int hashCode() {
        return Objects.hash(visitorID);  // Generate a unique hash code using visitorID
    }

    // Determine if the visitor is a VIP
    public boolean isVIP() {
        return this.isVIP;  // Return the VIP status of the visitor
    }
}