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

    // Print helper function to avoid repetitive code
    private void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor == null) {
            printMessage("Cannot add null visitor to the queue.");
            return;
        }
        if (visitorQueue.size() < maxRider) {
            visitorQueue.add(visitor);
            printMessage(visitor.getName() + " added to queue.");
        } else {
            printMessage("Queue is full. Cannot add " + visitor.getName());
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (visitor == null) {
            printMessage("Cannot remove null visitor from the queue.");
            return;
        }
        if (visitorQueue.remove(visitor)) {
            printMessage(visitor.getName() + " has been removed from the queue.");
        } else {
            printMessage("Visitor not found in queue.");
        }
    }

    @Override
    public void printQueue() {
        if (visitorQueue.isEmpty()) {
            printMessage("No visitors in the queue.");
            return;
        }
        printMessage("Visitors in the queue:");
        for (Visitor v : visitorQueue) {
            printMessage(v.toString());
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        printMessage(visitor.getName() + " added to ride history.");
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
            printMessage("No visitors have taken the ride yet.");
            return;
        }
        printMessage("Visitors in the ride history:");
        for (Visitor v : rideHistory) {
            printMessage(v.toString());
        }
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            printMessage("No ride operator assigned. Ride cannot be run.");
            return;
        }
        if (visitorQueue.isEmpty()) {
            printMessage("No visitors in the queue. Ride cannot be run.");
            return;
        }

        int count = 0;
        while (!visitorQueue.isEmpty() && count < maxRider) {
            Visitor visitor = visitorQueue.poll();
            addVisitorToHistory(visitor);  // Add visitor to history
            count++;
        }

        numOfCycles++;
        printMessage("Ride cycle completed. " + count + " visitors took the ride.");
    }

    // Export ride history to a file
    public void exportRideHistory(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getAddress() + "," +
                        visitor.isVIP() + "," + visitor.getVisitorID());
                writer.newLine();
            }
            printMessage("Ride history exported to " + fileName);
        } catch (IOException e) {
            printMessage("Error exporting ride history: " + e.getMessage());
        }
    }

    // Import ride history from a file
    public void importRideHistory(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 5) {
                    printMessage("Skipping invalid line: " + line);
                    continue; // Skip invalid lines
                }
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String address = data[2];
                boolean isVIP = Boolean.parseBoolean(data[3]);
                int visitorID = Integer.parseInt(data[4]);

                Visitor visitor = new Visitor(name, age, address, isVIP, visitorID);
                addVisitorToHistory(visitor);
            }
            printMessage("Ride history imported from " + fileName);
        } catch (IOException e) {
            printMessage("Error importing ride history: " + e.getMessage());
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

    public void setVisitorQueue(Queue<Visitor> visitorQueue) {
        this.visitorQueue = visitorQueue;
    }

    public void setRideHistory(LinkedList<Visitor> rideHistory) {
        this.rideHistory = rideHistory;
    }
}
