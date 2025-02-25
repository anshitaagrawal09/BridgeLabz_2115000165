import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.util.List;

class Student {
    private String ID;
    private String Name;
    private String Age;
    private String Marks;

    public String getID() { return ID; }
    public void setID(String ID) { this.ID = ID; }
    public String getName() { return Name; }
    public void setName(String name) { Name = name; }
    public String getAge() { return Age; }
    public void setAge(String age) { Age = age; }
    public String getMarks() { return Marks; }
    public void setMarks(String marks) { Marks = marks; }
}

public class ParseCSV {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("students.csv");
            CsvToBean<Student> csvToBean = new CsvToBeanBuilder<Student>(reader)
                    .withType(Student.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<Student> students = csvToBean.parse();

            for (Student student : students) {
                System.out.println(student.getName() + " scored " + student.getMarks());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
