public class AssignmentTwo {
    public static void main(String[] args) {
        // Create a new Ride object
        Ride rollerCoaster = new Ride("Roller Coaster", new Employee("Zhang San", 30, "Male", "Operator", 5000), 5);
        
        // Create some Visitor objects
        Visitor visitor1 = new Visitor("Li Si", 25, "Female", "VIP Ticket", "2024-12-01");
        Visitor visitor2 = new Visitor("Wang Wu", 28, "Male", "Regular Ticket", "2024-12-02");
        Visitor visitor3 = new Visitor("Zhao Liu", 35, "Female", "Regular Ticket", "2024-12-03");
        Visitor visitor4 = new Visitor("Sun Qi", 40, "Male", "VIP Ticket", "2024-12-04");
        Visitor visitor5 = new Visitor("Zhou Ba", 22, "Female", "Regular Ticket", "2024-12-05");

        // Add visitors to the queue
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // Print the visitors in the queue
        rollerCoaster.printQueue();

        // Remove one visitor (e.g., visitor3)
        rollerCoaster.removeVisitorFromQueue(visitor3);

        // Print the visitors in the queue again to verify visitor3 has been removed
        rollerCoaster.printQueue();

        // Run the ride for one cycle
        rollerCoaster.runOneCycle();

        // Print the ride history of visitors
        rollerCoaster.printRideHistory();
    }
}

