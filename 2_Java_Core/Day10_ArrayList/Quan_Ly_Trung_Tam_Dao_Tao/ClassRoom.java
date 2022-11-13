package Day10_ArrayList.Quan_Ly_Trung_Tam_Dao_Tao;

import java.util.ArrayList;

public class ClassRoom {
    private String subject;
    private String teacherName;
    private ArrayList<Student> studentList;

    // Constructor
    public ClassRoom(String subject, String teacherName, ArrayList<Student> studentList) {
        this.subject = subject;
        this.teacherName = teacherName;
        this.studentList = studentList;
    }

    // Display ClassRoom info, including Student list
    public void display() {
        System.out.println("Lop " + subject + " - Teacher: " + teacherName);
        System.out.println("Students:");
        for (Student student: studentList) {
            student.display();
        }
    }
}