package Day10_ArrayList.Quan_Ly_Trung_Tam_Dao_Tao;

import java.util.ArrayList;
import java.util.Scanner;

public class SchoolManagement {
    static boolean isContinue = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Khoi tao hoc vien
        Student student1 = new Student("001", "Nguyen Trung Duc", 28, "Gioi");
        Student student2 = new Student("002", "Vuong Khanh Huyen", 26, "Kha");
        Student student3 = new Student("003", "Dang Duc Thang", 30, "Gioi");
        Student student4 = new Student("004", "Ngo Huu Hung", 27, "Kha");
        Student student5 = new Student("005", "Nguyen Hai Dang", 25, "Trung Binh");
        Student student6 = new Student("006", "Nguyen Thi Trinh", 24, "Kha");

        // Khoi tao ArrayList hoc vien
        ArrayList<Student> studentList1 = new ArrayList<>();
        studentList1.add(student1);
        studentList1.add(student2);
        studentList1.add(student3);
        ArrayList<Student> studentList2 = new ArrayList<>();
        studentList2.add(student4);
        studentList2.add(student5);
        studentList2.add(student6);

        // Khoi tao lop hoc
        ClassRoom classRoom1 = new ClassRoom("Java", "Nguyen Xuan Nam", studentList1);
        ClassRoom classRoom2 = new ClassRoom("Front-end", "Tao Thuy Quynh", studentList2);

        // Khoi tao ArrayList lop hoc
        ArrayList<ClassRoom> classRoomList = new ArrayList<>();
        classRoomList.add(classRoom1);
        classRoomList.add(classRoom2);
        
        // Khoi tao trung tam     
        School Techmaster = new School("Tran Thanh Huong", classRoomList);

        // Hien thi thong tin trung tam
        Techmaster.display();

        // Them hoc vien vao lop hoc
        System.out.println("\nTHEM HOC VIEN VAO LOP HOC");
        isContinue = true;
        while (isContinue) {
            System.out.print("Chon lop hoc (Java / Front-end): ");
            String classInput = scanner.nextLine();
            if (classInput.equalsIgnoreCase("java")) {
                addStudent(scanner, studentList1);
            } else if (classInput.equalsIgnoreCase("front-end")) {
                addStudent(scanner, studentList2);
            }
            checkContinue(scanner);
        }
        Techmaster.display();
        
        // Cap nhat thong tin hoc luc cua hoc vien dua vao id
        System.out.println("\nCAP NHAT THONG TIN HOC LUC");
        isContinue = true;
        while (isContinue) {
            System.out.print("Nhap id hoc vien can cap nhat: ");
            String idToUpdate = scanner.nextLine();
            System.out.println("Updating student...");
            updateStudentRank(scanner, studentList1, idToUpdate);
            updateStudentRank(scanner, studentList2, idToUpdate);
            checkContinue(scanner);
        }
        Techmaster.display();

        // Xoa hoc vien khoi lop hoc dua vao id
        System.out.println("\nXOA HOC VIEN KHOI LOP HOC");
        isContinue = true;
        while (isContinue) {
            System.out.print("Nhap id hoc vien can xoa: ");
            String idToRemove = scanner.nextLine();
            removeStudent(studentList1, idToRemove);
            removeStudent(studentList2, idToRemove);
            checkContinue(scanner);
        }
        Techmaster.display();

        scanner.close();
    }

    static void checkContinue(Scanner input) {
        System.out.print("Tiep tuc (Y/N)? ");
        String continueInput = input.nextLine();
        switch (continueInput.toLowerCase()) {
            case "y": {
                break;
            }
            case "n": {
                isContinue = false;
                break;
            }
        }
    }
    
    // Phuong thuc nay de nhap thong tin hoc vien va them vao danh sach hoc vien
    static void addStudent(Scanner input, ArrayList<Student> studentList) {        
        // Nhap thong tin hoc vien
        System.out.print("\tNhap id: ");
        String id = input.nextLine();
        System.out.print("\tNhap ho va ten: ");
        String name = input.nextLine();
        System.out.print("\tNhap tuoi: ");
        int age = input.nextInt();
        input.nextLine();
        System.out.print("\tNhap hoc luc (Gioi / Kha / Trung Binh): ");
        String rank = input.nextLine();

        // Them hoc vien vao ArrayList
        Student student = new Student(id, name, age, rank);
        studentList.add(student);
    }

    // Phuong thuc nay de cap nhat thong tin hoc luc cua hoc vien
    static void updateStudentRank(Scanner input, ArrayList<Student> studentList, String idToUpdate) {
        for (Student student: studentList) {
            if (student.getId().equals(idToUpdate)) {
                student.display();
                System.out.print("Nhap hoc luc moi: ");
                String newRank = input.nextLine();
                student.setRank(newRank);
                System.out.println("Student updated");
                student.display();
            }
        }
    }

    // Phuong thuc nay de xoa hoc vien khoi danh sach
    static void removeStudent(ArrayList<Student> studentList, String idToRemove) {
        for (int i = 0; i < studentList.size(); ++i) {
            if (studentList.get(i).getId().equals(idToRemove)) {
                System.out.println("Student removed");
                studentList.get(i).display();
                studentList.remove(i);
            }
        }
    }
}