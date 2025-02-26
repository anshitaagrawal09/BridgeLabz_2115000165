import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Employee {
    public String name;
    public int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJsonArray {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 28),
                new Employee("Bob", 32)
        );

        String json = objectMapper.writeValueAsString(employees);
        System.out.println(json);
    }
}
