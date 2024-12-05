import java.util.*;

public class AssignmentTwo {
    public static void main(String[] args) {
        partThree();
        partFourA();
        partFourB();
        partFive();
        partSix();
        partSeven();
    }

    // Part 3: Queue Interface Demonstration
    public static void partThree() {
        System.out.println("\n--- Part 3: Queue Interface Demonstration ---");
        Employee operator = new Employee("Jane Smith", 35, "123 Park St", "Ride Operator", 45000);
        Ride rollerCoaster = new Ride("Roller Coaster", "Thrill", operator, 3);

        // Create Visitors and add them to the queue
        rollerCoaster.addVisitorToQueue(new Visitor("Mark Taylor", 25, "456 Elm St", true, 101));
        rollerCoaster.addVisitorToQueue(new Visitor("Alice Brown", 22, "789 Oak St", true, 102));
        rollerCoaster.addVisitorToQueue(new Visitor("John Doe", 30, "101 Pine St", true, 103));
        rollerCoaster.addVisitorToQueue(new Visitor("Emily White", 18, "202 Maple St", true, 104));
        rollerCoaster.addVisitorToQueue(new Visitor("Chris Green", 27, "303 Birch St", true, 105));

        // Print all Visitors in the Queue
        rollerCoaster.printQueue();

        // Remove a Visitor
        rollerCoaster.removeVisitorFromQueue(new Visitor("John Doe", 30, "101 Pine St", true, 103));

        // Print all Visitors in the Queue after removal
        rollerCoaster.printQueue();
    }

    // Part 4A: Ride History Collection Demonstration
    public static void partFourA() {
        System.out.println("\n--- Part 4A: Ride History Collection Demonstration ---");
        Employee operator = new Employee("John Smith", 30, "456 Elm St", "Ride Operator", 45000);
        Ride rollerCoaster = new Ride("Roller Coaster", "Thrill", operator, 3);

        // Add Visitors to Ride History
        Visitor visitor1 = new Visitor("Mark Taylor", 25, "456 Elm St", true, 101);
        Visitor visitor2 = new Visitor("Alice Brown", 22, "789 Oak St", true, 102);
        Visitor visitor3 = new Visitor("John Doe", 30, "101 Pine St", true, 103);
        Visitor visitor4 = new Visitor("Emily White", 18, "202 Maple St", true, 104);
        Visitor visitor5 = new Visitor("Chris Green", 27, "303 Birch St", true, 105);

        rollerCoaster.addVisitorToHistory(visitor1);
        rollerCoaster.addVisitorToHistory(visitor2);
        rollerCoaster.addVisitorToHistory(visitor3);
        rollerCoaster.addVisitorToHistory(visitor4);
        rollerCoaster.addVisitorToHistory(visitor5);

        // Check if a Visitor is in the history
        System.out.println("Is Mark Taylor in ride history? " + rollerCoaster.checkVisitorFromHistory(visitor1));

        // Print the number of Visitors in history
        System.out.println("Number of visitors in ride history: " + rollerCoaster.numberOfVisitors());

        // Print all Visitors in history
        rollerCoaster.printRideHistory();
    }

    // Part 4B: Sorting Ride History
    public static void partFourB() {
        System.out.println("\n--- Part 4B: Sorting Ride History ---");
        Employee operator = new Employee("John Smith", 30, "456 Elm St", "Ride Operator", 45000);
        Ride rollerCoaster = new Ride("Roller Coaster", "Thrill", operator, 3);

        // Add Visitors to Ride History
        rollerCoaster.addVisitorToHistory(new Visitor("Mark Taylor", 25, "456 Elm St", true, 101));
        rollerCoaster.addVisitorToHistory(new Visitor("Alice Brown", 22, "789 Oak St", true, 102));
        rollerCoaster.addVisitorToHistory(new Visitor("John Doe", 30, "101 Pine St", true, 103));
        rollerCoaster.addVisitorToHistory(new Visitor("Emily White", 18, "202 Maple St", true, 104));
        rollerCoaster.addVisitorToHistory(new Visitor("Chris Green", 27, "303 Birch St", true, 105));

        // Print all Visitors in history before sorting
        System.out.println("\nRide history before sorting:");
        rollerCoaster.printRideHistory();

        // Sort Visitors in history using VisitorComparator
        LinkedList<Visitor> rideHistory = rollerCoaster.getRideHistory();  // 获取历史记录
        Collections.sort(rideHistory, new VisitorComparator());

        // Print all Visitors in history after sorting
        System.out.println("\nRide history after sorting:");
        rollerCoaster.printRideHistory();
    }

    // Part 5: Running a Ride Cycle
    public static void partFive() {
        System.out.println("\n--- Part 5: Running a Ride Cycle ---");
        Employee operator = new Employee("Jane Smith", 35, "123 Park St", "Ride Operator", 45000);
        Ride rollerCoaster = new Ride("Roller Coaster", "Thrill", operator, 3);

        // Add 10 Visitors to the Queue
        rollerCoaster.addVisitorToQueue(new Visitor("Mark Taylor", 25, "456 Elm St", true, 101));
        rollerCoaster.addVisitorToQueue(new Visitor("Alice Brown", 22, "789 Oak St", true, 102));
        rollerCoaster.addVisitorToQueue(new Visitor("John Doe", 30, "101 Pine St", true, 103));
        rollerCoaster.addVisitorToQueue(new Visitor("Emily White", 18, "202 Maple St", true, 104));
        rollerCoaster.addVisitorToQueue(new Visitor("Chris Green", 27, "303 Birch St", true, 105));
        rollerCoaster.addVisitorToQueue(new Visitor("Lily Adams", 24, "404 Cedar St", true, 106));
        rollerCoaster.addVisitorToQueue(new Visitor("Ethan Clark", 29, "505 Spruce St", true, 107));
        rollerCoaster.addVisitorToQueue(new Visitor("Sophia Lee", 21, "606 Pine St", true, 108));
        rollerCoaster.addVisitorToQueue(new Visitor("Noah Harris", 26, "707 Oak St", true, 109));
        rollerCoaster.addVisitorToQueue(new Visitor("Olivia Walker", 23, "808 Birch St", true, 110));

        // Print all Visitors in the Queue before running the cycle
        System.out.println("\nVisitors in the Queue before running the cycle:");
        rollerCoaster.printQueue();

        // Run one cycle of the ride
        rollerCoaster.runOneCycle();

        // Print all Visitors in the Queue after running one cycle
        System.out.println("\nVisitors in the Queue after running one cycle:");
        rollerCoaster.printQueue();

        // Print the Ride History after one cycle
        System.out.println("\nRide History after running one cycle:");
        rollerCoaster.printRideHistory();
    }

    // Part 6: Export Ride History to File
    public static void partSix() {
        System.out.println("\n--- Part 6: Export Ride History to File ---");
        Employee operator = new Employee("Jane Smith", 35, "123 Park St", "Ride Operator", 45000);
        Ride rollerCoaster = new Ride("Roller Coaster", "Thrill", operator, 3);

        // Add Visitors to Ride history
        rollerCoaster.addVisitorToHistory(new Visitor("Mark Taylor", 25, "456 Elm St", true, 101));
        rollerCoaster.addVisitorToHistory(new Visitor("Alice Brown", 22, "789 Oak St", true, 102));
        rollerCoaster.addVisitorToHistory(new Visitor("John Doe", 30, "101 Pine St", true, 103));
        rollerCoaster.addVisitorToHistory(new Visitor("Emily White", 18, "202 Maple St", true, 104));
        rollerCoaster.addVisitorToHistory(new Visitor("Chris Green", 27, "303 Birch St", true, 105));

        // Export Ride History to a file
        rollerCoaster.exportRideHistory("ride_history.csv");
    }

    // Part 7: Import Ride History from File
    public static void partSeven() {
        System.out.println("\n--- Part 7: Import Ride History from File ---");
        Employee operator = new Employee("Jane Smith", 35, "123 Park St", "Ride Operator", 45000);
        Ride rollerCoaster = new Ride("Roller Coaster", "Thrill", operator, 3);

        // Import Ride History from the file
        rollerCoaster.importRideHistory("ride_history.csv");

        // Print the number of Visitors imported
        System.out.println("Number of Visitors in the ride history: " + rollerCoaster.numberOfVisitors());

        // Print all Visitors in the LinkedList
        rollerCoaster.printRideHistory();
    }
}
