import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

public class Ride implements RideInterface {
    private String rideName;
    private Employee rideOperator;
    private int maxRiders;  // Max visitors per cycle
    private int numOfCycles;  // Number of times the ride has been run
    private Queue<Visitor> rideQueue;  // Queue of visitors waiting to take the ride
    private LinkedList<Visitor> rideHistory;  // LinkedList for visitors who have taken the ride

    // Default constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideOperator = null;
        this.maxRiders = 1;  // At least one visitor is required to run the ride
        this.numOfCycles = 0;  // Default number of cycles is 0
        this.rideQueue = new LinkedList<>();  // Initialize the queue
        this.rideHistory = new LinkedList<>();  // Initialize the LinkedList for history
    }

    // Parameterized constructor
    public Ride(String rideName, Employee rideOperator, int maxRiders) {
        this.rideName = rideName;
        this.rideOperator = rideOperator;
        this.maxRiders = maxRiders;
        this.numOfCycles = 0;  // Default number of cycles is 0
        this.rideQueue = new LinkedList<>();  // Initialize the queue
        this.rideHistory = new LinkedList<>();  // Initialize the LinkedList for history
    }

    // Implementing RideInterface methods

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        rideQueue.add(visitor);
        System.out.println(visitor.getName() + " has joined the queue.");
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (rideQueue.remove(visitor)) {
            System.out.println(visitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println(visitor.getName() + " is not in the queue.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("Visitors in the queue:");
        if (rideQueue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            for (Visitor v : rideQueue) {
                System.out.println(v.getName());
            }
        }
    }

    @Override
    public void runOneCycle() {
        if (rideOperator == null) {
            System.out.println("No operator assigned. Ride cannot operate.");
            return;
        }

        if (rideQueue.isEmpty()) {
            System.out.println("The queue is empty. No visitors to take on the ride.");
            return;
        }

        // Determine how many visitors can take the ride in this cycle
        int riders = Math.min(maxRiders, rideQueue.size());
        for (int i = 0; i < riders; i++) {
            Visitor visitor = rideQueue.poll();  // Remove visitor from queue
            addVisitorToHistory(visitor);  // Add visitor to the ride history
        }

        // Increment the number of cycles after each cycle run
        numOfCycles++;
        System.out.println("The ride has completed one cycle with " + riders + " visitors.");
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);  // Add visitor to the ride history
        System.out.println(visitor.getName() + " has been added to the ride history.");
    }

    @Override
    public void checkVisitorFromHistory(Visitor visitor) {
        if (rideHistory.contains(visitor)) {
            System.out.println(visitor.getName() + " has already ridden this ride.");
        } else {
            System.out.println(visitor.getName() + " has not ridden this ride.");
        }
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();  // Return the number of visitors who have taken the ride
    }

    @Override
    public void printRideHistory() {
        System.out.println("Visitors who have taken the ride:");
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have taken the ride yet.");
        } else {
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                System.out.println(visitor.getName());
            }
        }
    }

    // Export the ride history to a file
    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getGender() + "," +
                        visitor.getVisitorType() + "," + visitor.getVisitDate());
                writer.newLine();
            }
            System.out.println("Ride history has been successfully exported to " + filename);
        } catch (IOException e) {
            System.out.println("Error while exporting ride history: " + e.getMessage());
        }
    }

    // Getter and Setter methods
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public Employee getRideOperator() {
        return rideOperator;
    }

    public void setRideOperator(Employee rideOperator) {
        this.rideOperator = rideOperator;
    }

    public int getMaxRiders() {
        return maxRiders;
    }

    public void setMaxRiders(int maxRiders) {
        this.maxRiders = maxRiders;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }

    // Sort the ride history
    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("The ride history has been sorted.");
    }
}
