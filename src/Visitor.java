public class Visitor extends Person {
    private String visitorType;
    private String visitDate;

    // Default constructor
    public Visitor() {
        super();  // Call Person's constructor
        this.visitorType = "Regular";
        this.visitDate = "Unknown";
    }

    // Parameterized constructor
    public Visitor(String name, int age, String gender, String visitorType, String visitDate) {
        super(name, age, gender);  // Call Person's constructor
        this.visitorType = visitorType;
        this.visitDate = visitDate;
    }

    // Getters and setters
    public String getVisitorType() {
        return visitorType;
    }

    public void setVisitorType(String visitorType) {
        this.visitorType = visitorType;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }
}

