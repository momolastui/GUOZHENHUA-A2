import java.io.*;
import java.util.*;

public class AssignmentTwo {

    public static void main(String[] args) {
        partSix();  // Demonstrate the exportRideHistory feature in partSix()
    }

    public static void partSix() {
        // Create a new Ride object
        Ride rollerCoaster = new Ride("Roller Coaster", new Employee("Zhang San", 30, "Male", "Operator", 5000), 5);

        // Create some Visitor objects
        Visitor visitor1 = new Visitor("Li Si", 25, "Female", "VIP", "2024-12-01");
        Visitor visitor2 = new Visitor("Wang Wu", 28, "Male", "Regular", "2024-12-02");
        Visitor visitor3 = new Visitor("Zhao Liu", 35, "Female", "Regular", "2024-12-03");
        Visitor visitor4 = new Visitor("Sun Qi", 40, "Male", "VIP", "2024-12-04");
        Visitor visitor5 = new Visitor("Zhou Ba", 22, "Female", "Regular", "2024-12-05");

        // Add visitors to the ride history (i.e., they have taken the ride)
        rollerCoaster.addVisitorToHistory(visitor1);
        rollerCoaster.addVisitorToHistory(visitor2);
        rollerCoaster.addVisitorToHistory(visitor3);
        rollerCoaster.addVisitorToHistory(visitor4);
        rollerCoaster.addVisitorToHistory(visitor5);

        // Export the ride history to a file
        String filename = "rideHistory.csv";
        rollerCoaster.exportRideHistory(filename);

        // Optionally, print the history before and after exporting (for verification)
        rollerCoaster.printRideHistory();
    }

    // Method to write visitor data to a file
    public static void exportVisitorsToFile(List<Visitor> visitors, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : visitors) {
                writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getGender() + "," +
                        visitor.getVisitorType() + "," + visitor.getVisitDate());
                writer.newLine();
            }
            System.out.println("Visitor data has been exported to " + filename);
        } catch (IOException e) {
            System.out.println("Error while exporting data: " + e.getMessage());
        }
    }

    // Method to read visitor data from a file and restore it
    public static List<Visitor> importVisitorsFromFile(String filename) {
        List<Visitor> visitors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Visitor visitor = new Visitor(data[0], Integer.parseInt(data[1]), data[2], data[3], data[4]);
                visitors.add(visitor);
            }
            System.out.println("Visitor data has been imported from " + filename);
        } catch (IOException e) {
            System.out.println("Error while importing data: " + e.getMessage());
        }
        return visitors;
    }
}
