public class Visitor {
    private String name;
    private int age;
    private String gender;
    private String visitorType;
    private String visitDate;

    public Visitor(String name, int age, String gender, String visitorType, String visitDate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.visitorType = visitorType;
        this.visitDate = visitDate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getVisitorType() {
        return visitorType;
    }

    public String getVisitDate() {
        return visitDate;
    }
}
