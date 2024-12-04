import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // First, compare by age (ascending order)
        if (v1.getAge() != v2.getAge()) {
            return Integer.compare(v1.getAge(), v2.getAge());
        }
        // If ages are equal, compare by name (alphabetical order)
        return v1.getName().compareTo(v2.getName());
    }
}
