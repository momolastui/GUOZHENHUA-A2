import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private Employee rideOperator;
    private int maxRiders;
    private Queue<Visitor> rideQueue;  // Waiting queue for visitors
    private LinkedList<Visitor> rideHistory;  // History of visitors who have taken the ride

    // Constructor with parameters
    public Ride(String rideName, Employee rideOperator, int maxRiders) {
        this.rideName = rideName;
        this.rideOperator = rideOperator;
        this.maxRiders = maxRiders;
        this.rideQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        rideQueue.add(visitor);
        System.out.println(visitor.getName() + " added to the queue for " + rideName);
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (rideQueue.remove(visitor)) {
            System.out.println(visitor.getName() + " removed from the queue.");
        } else {
            System.out.println(visitor.getName() + " not found in the queue.");
        }
    }

    @Override
    public void printQueue() {
        if (rideQueue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("Visitors in the queue for " + rideName + ":");
            for (Visitor visitor : rideQueue) {
                System.out.println(visitor.getName());
            }
        }
    }

    @Override
    public void runOneCycle() {
        if (rideOperator == null) {
            System.out.println("Ride cannot be run without an operator.");
            return;
        }

        if (rideQueue.isEmpty()) {
            System.out.println("No visitors in the queue.");
            return;
        }

        int riders = Math.min(maxRiders, rideQueue.size());
        for (int i = 0; i < riders; i++) {
            Visitor visitor = rideQueue.poll();  // Remove visitor from queue
            addVisitorToHistory(visitor);  // Add to history
            System.out.println(visitor.getName() + " is taking the ride.");
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " added to the ride history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
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
            System.out.println("Visitors who have taken the " + rideName + ":");
            for (Visitor visitor : rideHistory) {
                System.out.println(visitor.getName());
            }
        }
    }

    public String getRideName() {
        return rideName;
    }

    public Employee getRideOperator() {
        return rideOperator;
    }

    public int getMaxRiders() {
        return maxRiders;
    }
}
