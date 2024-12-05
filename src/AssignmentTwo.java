import java.util.*;

public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }

    public void partThree() {
        Ride ride = new Ride("Roller Coaster", new Employee("John", 30), 5);
        
        // Adding 5 visitors to the queue
        ride.addVisitorToQueue(new Visitor("Alice", 25, "Female", "Adult", "2024-12-01"));
        ride.addVisitorToQueue(new Visitor("Bob", 30, "Male", "Adult", "2024-12-01"));
        ride.addVisitorToQueue(new Visitor("Charlie", 10, "Male", "Child", "2024-12-01"));
        ride.addVisitorToQueue(new Visitor("David", 40, "Male", "Senior", "2024-12-01"));
        ride.addVisitorToQueue(new Visitor("Eva", 35, "Female", "Adult", "2024-12-01"));

        // Remove a visitor from the queue
        ride.removeVisitorFromQueue();
        
        // Print all visitors in the queue
        ride.printQueue();
    }

    public void partFourA() {
        Ride ride = new Ride("Ferris Wheel", new Employee("Lucy", 28), 4);

        // Adding 5 visitors to the history
        ride.addVisitorToHistory(new Visitor("Alice", 25, "Female", "Adult", "2024-12-01"));
        ride.addVisitorToHistory(new Visitor("Bob", 30, "Male", "Adult", "2024-12-01"));
        ride.addVisitorToHistory(new Visitor("Charlie", 10, "Male", "Child", "2024-12-01"));
        ride.addVisitorToHistory(new Visitor("David", 40, "Male", "Senior", "2024-12-01"));
        ride.addVisitorToHistory(new Visitor("Eva", 35, "Female", "Adult", "2024-12-01"));

        // Check if a visitor is in the history
        System.out.println("Is Alice in the history? " + ride.checkVisitorFromHistory(new Visitor("Alice", 25, "Female", "Adult", "2024-12-01")));

        // Print the number of visitors in the history
        System.out.println("Total visitors in history: " + ride.numberOfVisitors());

        // Print all visitors in the history
        ride.printRideHistory();
    }

    public void partFourB() {
        Ride ride = new Ride("Log Flume", new Employee("Mark", 32), 3);

        // Adding 5 visitors to the collection
        ride.addVisitorToHistory(new Visitor("Alice", 25, "Female", "Adult", "2024-12-01"));
        ride.addVisitorToHistory(new Visitor("Bob", 30, "Male", "Adult", "2024-12-01"));
        ride.addVisitorToHistory(new Visitor("Charlie", 10, "Male", "Child", "2024-12-01"));
        ride.addVisitorToHistory(new Visitor("David", 40, "Male", "Senior", "2024-12-01"));
        ride.addVisitorToHistory(new Visitor("Eva", 35, "Female", "Adult", "2024-12-01"));

        // Sort the collection
        ride.sortRideHistory(new VisitorComparator());

        // Print all visitors after sorting
        ride.printRideHistory();
    }

    public void partFive() {
        Ride ride = new Ride("Space Shuttle", new Employee("Sam", 38), 3);

        // Add 10 visitors to the queue
        for (int i = 1; i <= 10; i++) {
            ride.addVisitorToQueue(new Visitor("Visitor" + i, 20 + i, "Male", "Adult", "2024-12-01"));
        }

        // Print the queue before running the cycle
        System.out.println("Visitors in the queue before the cycle:");
        ride.printQueue();

        // Run one cycle
        ride.runOneCycle();

        // Print the queue and history after one cycle
        System.out.println("Visitors in the queue after the cycle:");
        ride.printQueue();

        System.out.println("Visitors who took the ride:");
        ride.printRideHistory();
    }

    public void partSix() {
        Ride ride = new Ride("Carousel", new Employee("Nina", 26), 3);

        // Add 5 visitors to the ride history
        for (int i = 1; i <= 5; i++) {
            ride.addVisitorToHistory(new Visitor("Visitor" + i, 20 + i, "Female", "Adult", "2024-12-01"));
        }

        // Export the visitors to a file
        ride.exportRideHistory("rideHistory.csv");
    }

    public void partSeven() {
        Ride ride = new Ride("Haunted House", new Employee("George", 50), 3);

        // Import the visitors from the file
        ride.importRideHistory("rideHistory.csv");

        // Print the number of visitors in the ride history
        System.out.println("Total visitors after import: " + ride.numberOfVisitors());

        // Print all visitors in the ride history
        ride.printRideHistory();
    }
}
