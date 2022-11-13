package Sort_student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// 1. Sắp xếp theo fullName, nếu giống fullName thì ai nhiều tuổi hơn xếp trước.
// 2. Sắp xếp theo tuổi tăng dần, nếu bằng tuổi thì xếp theo GPA giảm dần.
// 3. Sắp xếp theo tên (ví dụ họ tên là Hoàng Văn A, thì chỉ xét A thôi).

public class Main2 {

    public static List<Student> studentList = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        studentList.add(new Student("nguyen Trung Duc", 21, 3.67));
        studentList.add(new Student("Vuong Khanh Huyen", 19, 3.20));
        studentList.add(new Student("Ngo Huu Hung", 21, 2.88));
        studentList.add(new Student("Tran Duc Hieu", 21, 3.53));
        studentList.add(new Student("Dang Toan Thang", 22, 2.94));
        studentList.add(new Student("Nguyen trung duc", 23, 3.76));
        studentList.add(new Student("Doan Thanh Ha", 22, 3.19));

        System.out.println("Danh sach hoc sinh:");
        displayStudentList();

        boolean isContinue = true;
        while (isContinue) {
            System.out.println("[1] Sắp xếp theo fullName, nếu giống fullName thì ai nhiều tuổi hơn xếp trước.");
            System.out.println("[2] Sắp xếp theo tuổi tăng dần, nếu bằng tuổi thì xếp theo GPA giảm dần.");
            System.out.println("[3] Sắp xếp theo tên (ví dụ họ tên là Hoàng Văn A thì chỉ xét A).");
            System.out.println("[4] Exit");
            System.out.print("Chon option: ");
            int sortOption = scanner.nextInt();
            scanner.nextLine();

            switch (sortOption) {
                case 1: { // Sắp xếp theo fullName, nếu giống fullName thì ai nhiều tuổi hơn xếp trước.
                    sortByFullName(studentList);
                    displayStudentList();
                    break;
                }
                case 2: { // Sắp xếp theo tuổi tăng dần, nếu bằng tuổi thì xếp theo GPA giảm dần.
                    sortByAge(studentList);
                    displayStudentList();
                    break;
                }
                case 3: { // Sắp xếp theo tên (ví dụ họ tên là Hoàng Văn A thì chỉ xét A).
                    sortByName(studentList);
                    displayStudentList();
                    break;
                }
                case 4: {
                    System.out.println("\t<Thoat chuong trinh>");
                    isContinue = false;
                    break;
                }
                default: {
                    System.out.println("\t<Vui long chon lai>\n");
                    break;
                }
            }
        }
        
        scanner.close();
    }
    
    public static void displayStudentList() {
        for (Student student : studentList) {
            System.out.println("\t" + student.toString());
        }
        System.out.println();
    }

    public static void sortByFullName(List<Student> list) {
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = o1.fullName.compareToIgnoreCase(o2.fullName);
                if (result == 0) {
                    return (o2.age > o1.age) ? 1 : -1;
                }
                return result;
            }
        });
    }

    public static void sortByAge(List<Student> list) {
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = (o1.age > o2.age) ? 1 : -1;
                if (o1.age == o2.age) {
                    return (o2.GPA > o1.GPA) ? 1 : -1;
                }
                return result;
            }
        });
    }

    public static void sortByName(List<Student> list) {
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }
}