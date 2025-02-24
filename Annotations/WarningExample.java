import java.util.ArrayList;

public class WarningExample {
    @SuppressWarnings("unchecked") // Suppress unchecked warnings
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // Raw type usage
        list.add("Hello");
        list.add(42);
        
        System.out.println(list);
    }
}
