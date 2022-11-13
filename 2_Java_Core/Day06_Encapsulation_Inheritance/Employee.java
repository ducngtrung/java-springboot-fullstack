package Day06_Encapsulation_Inheritance;

import java.time.LocalDate;
import java.time.Period;

public class Employee {
// Khai báo class nhiên viên (Employee) gồm các thông tin:

// id (String, bắt đầu là NV, ví dụ: NV01, NV02)
// name (String)
// birthday (LocalDate)
// gender (sử dụng enum)
// salary (double)
    enum Gender {MALE, FEMALE}

    // Các thuộc tính private
    private String id;
    private String name;
    private LocalDate birthday;
    private double salary;
    private Gender gender;

    // Constructor để nhập thông tin một nhân viên
    public Employee(String id, String name, LocalDate birthday, double salary, Gender gender) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.salary = salary;
        this.gender = gender;
    }

    // Getter để lấy thông tin từ các thuộc tính private
    public String getID() {
        return this.id;     // viết return id; cũng được
    }
    public String getName() {
        return name;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public double getSalary() {
        return salary;
    }
    public Gender getGender() {
        return gender;
    }

    // Setter để gán giá trị cho các thuộc tính private
    public void setID(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // Phương thức này để in ra thông tin của một nhân viên
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