package Day05_OOP;

import java.time.LocalDate;
import java.time.Period;

public class Employee {
// Khai báo class nhiên viên (Employee) gồm các thông tin:

// id (String, bắt đầu là NV, ví dụ: NV01, NV02)
// name (String)
// birthday (LocalDate)
// gender (Sử dụng enum)
// salary (double)
    enum Gender {MALE, FEMALE}

    public String id;
    public String name;
    public LocalDate birthday;
    public double salary;
    public Gender gender;

    // Constructor để nhập thông tin một nhân viên
    public Employee(String id, String name, LocalDate birthday, double salary, Gender gender) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.salary = salary;
        this.gender = gender;
    }

    // Phương thức này để in ra thông ra của một nhân viên
    public void printInfo() {
        System.out.print("\n\t" + this.id + " - Tên: " + this.name
                            + " - Ngày sinh: " + this.birthday
                            + " - Lương: " + Math.round(this.salary) + " VNĐ" 
                            + " - Giới tính: " + this.gender);
    }

    // Phương thức này để tìm nhân viên theo số id
    public boolean idSearch(String id) {
        boolean result = (this.id.toLowerCase().equals(id));
        return result;
    }

    // Phương thức này để tìm nhân viên theo tên
    public boolean nameSearch(String keyword) {
        boolean result = this.name.toLowerCase().contains(keyword);
        return result;
    }

    // Phương thức này để tính tuổi của một nhân viên
    public int getAge() {
        return (Period.between(birthday, LocalDate.now()).getYears());
    }
}