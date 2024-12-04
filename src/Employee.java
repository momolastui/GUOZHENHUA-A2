public class Employee extends Person {
    private String jobTitle;
    private int employeeID;

    // 默认构造函数
    public Employee() {
        super(); // 调用 Person 的构造函数
        this.jobTitle = "未知";
        this.employeeID = 0;
    }

    // 参数化构造函数
    public Employee(String name, int age, String address, String jobTitle, int employeeID) {
        super(name, age, address); // 调用 Person 的构造函数
        this.jobTitle = jobTitle;
        this.employeeID = employeeID;
    }

    // Getter 和 Setter 方法
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}

