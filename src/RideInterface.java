
public interface RideInterface {
    // Method to add a visitor to the queue
    void addVisitorToQueue(Visitor visitor);

    // Method to remove a visitor from the queue
    void removeVisitorFromQueue(Visitor visitor);

    // Method to print all visitors in the queue
    void printQueue();

    // Method to run the ride for one cycle (move visitors from queue to history)
    void runOneCycle();

    // Method to add a visitor to the ride history
    void addVisitorToHistory(Visitor visitor);

    // Method to check if a visitor is in the ride history
    void checkVisitorFromHistory(Visitor visitor);

    // Method to get the number of visitors in the ride history
    int numberOfVisitors();

    // Method to print all visitors who have taken the ride
    void printRideHistory();
}
