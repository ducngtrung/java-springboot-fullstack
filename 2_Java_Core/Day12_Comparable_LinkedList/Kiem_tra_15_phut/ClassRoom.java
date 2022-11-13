import java.util.ArrayList;

public class ClassRoom {
    private String classRoom;
    private ArrayList<Student> studentList;

    // Constructor
    public ClassRoom(String classRoom, ArrayList<Student> studentList) {
        this.classRoom = classRoom;
        this.studentList = studentList;
    }

    // Display ClassRoom info, including Student list
    public void display() {
        System.out.println("\nLop " + classRoom);
        System.out.println("Hoc vien:");
        for (Student student: studentList) {
            student.display();
        }
    }
}