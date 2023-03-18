import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main12 {
    static boolean isFound = false;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Khoi tao ArrayList hoc vien va lop hoc
        ArrayList<Student> studentList1 = new ArrayList<>();
        ArrayList<Student> studentList2 = new ArrayList<>();
        ClassRoom classRoom1 = new ClassRoom("10A1", studentList1);
        ClassRoom classRoom2 = new ClassRoom("10A2", studentList2);

        // Nhap danh sach hoc vien
        System.out.print("Nhap so luong hoc sinh: ");
        int quantity = input.nextInt();
        input.nextLine();
        for (int i=0; i<quantity; ++i) {
            System.out.print("Chon lop hoc (10A1 / 10A2): ");
            String classInput = input.nextLine();
            if (classInput.equalsIgnoreCase("10A1")) {
                addStudent(input, studentList1);
            } else if (classInput.equalsIgnoreCase("10A2")) {
                addStudent(input, studentList2);
            }
        }

        // Hien thi thong tin moi lop hoc
        classRoom1.display();
        classRoom2.display();

        // Hien thi nhung hoc vien sinh nam 1985 va que o Thai Nguyen
        System.out.println("\nHoc vien sinh nam 1985 va que o Thai Nguyen:");
        searchStudent(input, studentList1);
        searchStudent(input, studentList2);
        if (!isFound) {
            System.out.println("\t(Khong co)");
        }

        input.close();
    }

    // Phuong thuc nay de nhap thong tin hoc vien va them vao danh sach hoc vien
    static void addStudent(Scanner input, ArrayList<Student> studentList) {        
        // Nhap thong tin hoc vien
        System.out.print("\tNhap ho va ten: ");
        String name = input.nextLine();
        System.out.print("\tNhap ngay thang nam sinh (dd/MM/yyyy): ");
        String birthday = input.nextLine();
        System.out.print("\tNhap que quan: ");
        String hometown = input.nextLine();

        // Them hoc vien vao ArrayList
        Student student = new Student(name, birthday, hometown);
        studentList.add(student);
    }

    // Phuong thuc nay de tim kiem hoc vien sinh nam 1985 va que o Thai Nguyen
    static void searchStudent(Scanner input, ArrayList<Student> studentList) {
        for (Student student: studentList) {
            if ((convertStringToLocalDate(student.getBirthday()).getYear() == 1985) 
                && (student.getHometown().equalsIgnoreCase("Thai Nguyen"))) {
                    student.display();
                    isFound = true;
                }
        }
    }

    // Khai bao date formatter dạng dd/MM/yyyy
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Convert from dd/MM/yyyy to LocalDate
    static LocalDate convertStringToLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, formatter);
    }
}