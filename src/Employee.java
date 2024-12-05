public class Employee extends Person {
    private String jobTitle;
    private double salary;

    // Default constructor
    public Employee() {
        super("", 0, "");
        this.jobTitle = "";
        this.salary = 0.0;
    }

    // Parameterized constructor
    public Employee(String name, int age, String address, String jobTitle, double salary) {
        super(name, age, address);
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    // Getters and Setters
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Employee{name='%s', age=%d, address='%s', jobTitle='%s', salary=%.2f}",
                getName(), getAge(), getAddress(), jobTitle, salary);
    }
}
