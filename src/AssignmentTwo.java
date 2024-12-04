import java.io.*;
import java.util.*;

public class AssignmentTwo {

    public static void main(String[] args) {
        partSeven();  // Demonstrate the importRideHistory functionality in partSeven()
    }

    public static void partSeven() {
        // Create a new Ride object
        Ride rollerCoaster = new Ride("Roller Coaster", new Employee("Zhang San", 30, "Male", "Operator", 5000), 5);

        // Import the ride history from a file
        String filename = "rideHistory.csv";
        rollerCoaster.importRideHistory(filename);

        // Print the number of visitors in the LinkedList
        System.out.println("Total visitors in ride history: " + rollerCoaster.numberOfVisitors());

        // Print all visitors in the LinkedList to confirm correct import
        rollerCoaster.printRideHistory();
    }

    // Method to write visitor data to a file (for demonstration purposes)
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

    // Method to read visitor data from a file and restore it (for demonstration purposes)
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
