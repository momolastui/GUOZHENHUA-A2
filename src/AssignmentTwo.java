public class AssignmentTwo {
    public static void main(String[] args) {
        partFourA();  // Call partFourA to demonstrate the functionality
        partFourB();  // Call partFourB to demonstrate sorting functionality
    }

    public static void partFourA() {
        // Create a new Ride object
        Ride rollerCoaster = new Ride("Roller Coaster", new Employee("Zhang San", 30, "Male", "Operator", 5000), 5);

        // Create some Visitor objects
        Visitor visitor1 = new Visitor("Li Si", 25, "Female", "VIP", "2024-12-01");
        Visitor visitor2 = new Visitor("Wang Wu", 28, "Male", "Regular", "2024-12-02");
        Visitor visitor3 = new Visitor("Zhao Liu", 35, "Female", "Regular", "2024-12-03");
        Visitor visitor4 = new Visitor("Sun Qi", 40, "Male", "VIP", "2024-12-04");
        Visitor visitor5 = new Visitor("Zhou Ba", 22, "Female", "Regular", "2024-12-05");

        // Add visitors to the ride history
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // Run the ride for one cycle
        rollerCoaster.runOneCycle();

        // Print the ride history
        rollerCoaster.printRideHistory();

        // Check if a visitor is in the history
        rollerCoaster.checkVisitorFromHistory(visitor1);

        // Print the number of visitors in the ride history
        System.out.println("Number of visitors: " + rollerCoaster.numberOfVisitors());
    }

    public static void partFourB() {
        // Create a new Ride object
        Ride rollerCoaster = new Ride("Roller Coaster", new Employee("Zhang San", 30, "Male", "Operator", 5000), 5);

        // Create some Visitor objects and add them to the queue
        Visitor visitor1 = new Visitor("Li Si", 25, "Female", "VIP", "2024-12-01");
        Visitor visitor2 = new Visitor("Wang Wu", 28, "Male", "Regular", "2024-12-02");
        Visitor visitor3 = new Visitor("Zhao Liu", 35, "Female", "Regular", "2024-12-03");
        Visitor visitor4 = new Visitor("Sun Qi", 40, "Male", "VIP", "2024-12-04");
        Visitor visitor5 = new Visitor("Zhou Ba", 22, "Female", "Regular", "2024-12-05");

        // Add visitors to the ride queue
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // Run the ride for one cycle
        rollerCoaster.runOneCycle();

        // Sort the ride history
        rollerCoaster.sortRideHistory();

        // Print the sorted ride history
        rollerCoaster.printRideHistory();
    }
}


