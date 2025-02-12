
//Student Node Class
class StudentNode{
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    // Constructor
    public StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
class StudentRecordManagement{
    private StudentNode head;
    //Add a student
    public void addStudentAtFirst(int rollNumber, String name, int age, String grade){
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        newNode.next=head;
        head=newNode;
    }
    public void addStudentAtLast(int rollNumber, String name, int age, String grade){
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
         if (head == null) {
            head = newNode;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public void addStudentAtIndex(int rollNumber, String name, int age, String grade,int position){
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if(position==1){
            addStudentAtFirst(rollNumber,name,age,grade);
            return;
        }
        int count=0;//size
        StudentNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        if(position==count+1){//insert at end
            addStudentAtLast(rollNumber, name, age, grade);
            return;
        }
        //Add at particular index
        temp=head;
        for (int i = 1; i < position-1; i++) {
            temp = temp.next;
        }
        //now temp is at prev index
        newNode.next=temp.next;
        temp.next=newNode;

    }

    //To delete student record by roll number
    public void deleteStudentRecord(int rollNumber){
        if(head==null){
            return;
        }
        if(head.rollNumber==rollNumber){
            head=head.next;
            return;
        }
        StudentNode temp=head;
        while(temp.next!=null&&temp.next.rollNumber!=rollNumber){
            temp=temp.next;
        }
        //now temp is at previous node from the node we have to delete
        if(temp.next==null){
            return;
        }
        temp.next=temp.next.next;
    }
    public StudentNode searchStudent(int rollNumber){
        StudentNode temp=head;
        while(temp!=null){
            if(temp.rollNumber==rollNumber){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
    public void displayStudents(){
        StudentNode temp=head;
        while(temp!=null){
            System.out.println("Roll No.: "+temp.rollNumber+" Name: "+temp.name+" Age: "+temp.age+" Grade: "+temp.grade);
            temp=temp.next;
        }
    }
    //Update Student Grade
    public void updateGrade(int rollNumber,String grade){
        StudentNode temp=head;
        while(temp!=null){
            if(temp.rollNumber==rollNumber){
                temp.grade=grade;
                return;
            }
            temp=temp.next;
        }
        System.out.println("Student not found!");
    }

}

public class StudentRecordSystem {
    public static void main(String[] args) {
        StudentRecordManagement studentList = new StudentRecordManagement();
        studentList.addStudentAtFirst(1,"Anshita",21,"A+");
        studentList.addStudentAtLast(2,"Ayush",24,"A");
        studentList.addStudentAtFirst(3,"Palak",18,"O");
        studentList.displayStudents();
        System.out.println("------------------------------------------------");
        studentList.addStudentAtIndex(4,"Kanchan",48,"A",2);
        studentList.displayStudents();
        System.out.println(studentList.searchStudent(2));
        studentList.updateGrade(2,"O");
        System.out.println("------------------------------------------------");
        studentList.displayStudents();
        studentList.deleteStudentRecord(1);
        System.out.println("------------------------------------------------");
        studentList.displayStudents();
    }
}

