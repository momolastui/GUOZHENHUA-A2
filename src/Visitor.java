public class Visitor extends Person {
    private boolean isVIP;
    private int visitorID;

    // Constructor
    public Visitor(String name, int age, String address, boolean isVIP, int visitorID) {
        super(name, age, address);
        this.isVIP = isVIP;
        this.visitorID = visitorID;
    }

    // Getter and Setter methods
    public boolean isVIP() {
        return isVIP;
    }

    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }

    public int getVisitorID() {
        return visitorID;
    }

    public void setVisitorID(int visitorID) {
        this.visitorID = visitorID;
    }

    @Override
    public String toString() {
        return String.format("Visitor{name='%s', age=%d, address='%s', isVIP=%b, visitorID=%d}",
                getName(), getAge(), getAddress(), isVIP, visitorID);
    }

    // Override equals and hashCode methods for proper comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Visitor visitor = (Visitor) obj;
        return visitorID == visitor.visitorID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitorID);
    }
}
