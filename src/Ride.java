import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private Employee rideOperator;
    private int maxRiders;
    private Queue<Visitor> rideQueue;
    private LinkedList<Visitor> rideHistory;

    // Default constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideOperator = null; // Default operator is null
        this.maxRiders = 10; // Default max riders is 10
        this.rideQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Parameterized constructor
    public Ride(String rideName, Employee rideOperator, int maxRiders) {
        this.rideName = rideName;
        this.rideOperator = rideOperator;
        this.maxRiders = maxRiders;
        this.rideQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Implementing the RideInterface methods

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        rideQueue.add(visitor);
        System.out.println(visitor.getName() + " has been added to the queue.");
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
        if (rideQueue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("Visitors in the queue:");
            for (Visitor v : rideQueue) {
                System.out.println(v.getName());
            }
        }
    }

    @Override
    public void runOneCycle() {
        if (rideOperator == null) {
            System.out.println("No ride operator assigned, cannot run the ride.");
            return;
        }

        if (rideQueue.isEmpty()) {
            System.out.println("The queue is empty, cannot run the ride.");
            return;
        }

        int riders = Math.min(maxRiders, rideQueue.size());
        for (int i = 0; i < riders; i++) {
            Visitor visitor = rideQueue.poll();  // Remove from queue
            addVisitorToHistory(visitor);        // Add to ride history
        }

        System.out.println("Ride cycle completed. " + riders + " visitors took the ride.");
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " has been added to the ride history.");
    }

    @Override
    public void checkVisitorFromHistory(Visitor visitor) {
        if (rideHistory.contains(visitor)) {
            System.out.println(visitor.getName() + " has already taken the ride.");
        } else {
            System.out.println(visitor.getName() + " has not taken the ride.");
        }
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have taken the ride yet.");
        } else {
            System.out.println("Visitors who have taken the ride:");
            for (Visitor v : rideHistory) {
                System.out.println(v.getName());
            }
        }
    }

    // Getters and Setters
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
}
