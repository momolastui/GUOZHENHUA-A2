import java.io.*;
import java.util.*;

public class Ride implements RideInterface {
    private final String rideName;
    private final String rideType;
    private Employee operator;
    private int maxRider;
    private int numOfCycles;
    private Queue<Visitor> visitorQueue;
    private LinkedList<Visitor> rideHistory;

    // Constructor with all parameters
    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.maxRider = maxRider;
        this.numOfCycles = 0;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Constructor with only name and type
    public Ride(String rideName, String rideType) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitorQueue.size() < maxRider) {
            visitorQueue.add(visitor);
            System.out.println(visitor.getName() + " added to queue.");
        } else {
            System.out.println("Queue is full. Cannot add " + visitor.getName());
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (visitorQueue.remove(visitor)) {
            System.out.println(visitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println("Visitor not found in queue.");
        }
    }

    @Override
    public void printQueue() {
        if (visitorQueue.isEmpty()) {
            System.out.println("No visitors in the queue.");
            return;
        }
        System.out.println("Visitors in the queue:");
        for (Visitor v : visitorQueue) {
            System.out.println(v);
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " added to ride history.");
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
            return;
        }
        System.out.println("Visitors in the ride history:");
        for (Visitor v : rideHistory) {
            System.out.println(v);
        }
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("No ride operator assigned. Ride cannot be run.");
            return;
        }
        if (visitorQueue.isEmpty()) {
            System.out.println("No visitors in the queue. Ride cannot be run.");
            return;
        }

        int count = 0;
        while (!visitorQueue.isEmpty() && count < maxRider) {
            Visitor visitor = visitorQueue.poll();
            addVisitorToHistory(visitor);  // Add visitor to history
            count++;
        }

        numOfCycles++;
        System.out.println("Ride cycle completed. " + count + " visitors took the ride.");
    }

    public void exportRideHistory(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getAddress() + "," +
                        visitor.isVIP() + "," + visitor.getVisitorID());
                writer.newLine();
            }
            System.out.println("Ride history exported to " + fileName);
        } catch (IOException e) {
            System.out.println("Error exporting ride history: " + e.getMessage());
        }
    }

    public void importRideHistory(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String address = data[2];
                boolean isVIP = Boolean.parseBoolean(data[3]);
                int visitorID = Integer.parseInt(data[4]);

                Visitor visitor = new Visitor(name, age, address, isVIP, visitorID);
                addVisitorToHistory(visitor);
            }
            System.out.println("Ride history imported from " + fileName);
        } catch (IOException e) {
            System.out.println("Error importing ride history: " + e.getMessage());
        }
    }

    // Getters and Setters for Ride attributes
    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    public Queue<Visitor> getVisitorQueue() {
        return visitorQueue;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }

    public String getRideName() {
        return rideName;
    }

    public String getRideType() {
        return rideType;
    }
}
