package Day05_OOP;

import Day05_OOP.Employee.Gender;

import java.time.LocalDate;
import java.util.Scanner;

public class Employee_Management {
// Tạo một mảng danh sách gồm 5 nhân viên bất kỳ.
// Thực hiện:
//     Tìm nhân viên theo id (tìm chính xác)
//     Tìm nhân viên theo tên (tìm theo từ khoá, VD: "Nguyễn Văn A" -> nhập "A" hoặc "Văn" đều phải tìm ra được)
//     Đếm số nhân viên nam, nữ
//     Liệt kê các nhân viên trên 30 tuổi
//     Nhập từ bàn phím tháng bất kỳ trong năm, kiểm tra xem trong tháng đó có nhân viên nào có ngày sinh nhật
//     In ra top 3 người có lương tháng cao nhất
    
    // Phương thức này để sắp xếp các phần tử trong danh sách nhân viên theo thứ tự lương giảm dần
    static void salaryDescending(Employee[] emp) {
        Employee temp;
        int quantity = emp.length;
        for (int i = 0; i < (quantity - 1); ++i) {
            for (int j = 0; j < (quantity - i - 1); ++j) {
                if (emp[j].salary < emp[j+1].salary) {
                    temp = emp[j];
                    emp[j] = emp[j+1];
                    emp[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Employee[] employeeList = new Employee[5];
        employeeList[0] = new Employee("NV01", "Nguyen Trung Duc", 
                                LocalDate.of(1994, 4, 29), 40000000, Gender.MALE);
        employeeList[1] = new Employee("NV02", "Vuong Khanh Huyen", 
                                LocalDate.of(1996, 12, 7), 25000000, Gender.FEMALE);
        employeeList[2] = new Employee("NV03", "Ngo Huu Hung", 
                                LocalDate.of(1987, 11, 15), 32000000, Gender.MALE);
        employeeList[3] = new Employee("NV04", "Dinh Duc Thang", 
                                LocalDate.of(1990, 5, 31), 20000000, Gender.MALE);
        employeeList[4] = new Employee("NV05", "Nguyen Kim Ngan ", 
                                LocalDate.of(1975, 5, 23), 33000000, Gender.FEMALE);

        Scanner input = new Scanner(System.in);

        // In ra danh sách nhân viên
        System.out.println("Danh sách nhân viên:");
        for (Employee employee: employeeList) {
            employee.printInfo();
        }

        // Đếm số nhân viên nam, nữ
        int countMALE = 0;
        int countFEMALE = 0;
        for (Employee employee: employeeList) {
            if (employee.gender==Gender.MALE) {
                ++countMALE;
            } else {
                ++countFEMALE;
            }
        }
        System.out.printf("\n%d nhân viên nam\n", countMALE);
        System.out.printf("%d nhân viên nữ\n", countFEMALE);

        // Liệt kê các nhân viên trên 30 tuổi
        System.out.println("\nCác nhân viên trên 30 tuổi:");
        boolean isFound = false;
        for (Employee employee: employeeList) {
            if (employee.getAge() >= 30) {
                employee.printInfo();
                System.out.printf(" - %d TUỔI", employee.getAge());
                isFound = true;
            }
        }
        if (isFound==false) {
            System.out.println("\tKhông có");
        }

        // In ra top 3 người có lương tháng cao nhất
        salaryDescending(employeeList);
        System.out.println("\n\nTop 3 nhân viên có lương cao nhất:");
        for (int i = 0; i < 3; ++i) {
            employeeList[i].printInfo();
        }

        // Tìm nhân viên theo id (tìm chính xác)
        System.out.println("\n\nNhập số id nhân viên cần tìm:");
        String idToSearch = input.nextLine().toLowerCase();
        isFound = false;
        for (Employee employee: employeeList) {
            if (employee.idSearch(idToSearch)) {
                employee.printInfo();
                isFound = true;
            }
        }
        if (isFound==false) {
            System.out.println("\tKhông tìm thấy");
        }

        // Tìm nhân viên theo tên (tìm theo từ khóa)
        System.out.println("\n\nNhập tên nhân viên cần tìm: ");
        String keywordName = input.nextLine().toLowerCase();
        isFound = false;
        for (Employee employee: employeeList) {
            if (employee.nameSearch(keywordName)) {
                employee.printInfo();
                isFound = true;
            }
        }
        if (isFound==false) {
            System.out.println("\tKhông tìm thấy");
        }

        // Nhập từ bàn phím tháng bất kỳ trong năm, kiểm tra xem trong tháng đó có nhân viên nào có ngày sinh nhật
        System.out.print("\n\nNhập tháng bất kỳ trong năm: ");
        int month = input.nextInt();
        System.out.printf("Các nhân viên có sinh nhật trong tháng %d:\n", month);
        isFound = false;
        for (Employee employee: employeeList) {
            if (employee.birthday.getMonthValue() == month) {
                employee.printInfo();
                isFound = true;
            }
        }
        if (isFound==false) {
            System.out.println("\tKhông có");
        }

        input.close();
    }
}