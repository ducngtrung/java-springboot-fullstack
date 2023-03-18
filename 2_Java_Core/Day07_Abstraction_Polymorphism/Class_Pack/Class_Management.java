package Day07_Abstraction_Polymorphism.Class_Pack;

import java.time.LocalDate;
import java.util.Scanner;

import Day07_Abstraction_Polymorphism.Class_Pack.Person.Gender;

public class Class_Management {
// Viết chương trình quản lý lớp học
// Thực hiện:
//      Tạo 2 giáo viên
//      Tạo 6 học sinh
//      Dùng 1 mảng chung để lưu các đối tượng trên
//      Duyệt mảng và in ra thông tin học sinh, giáo viên (dùng phương thức printInfo)
//      Tìm kiếm theo keyword bất kỳ, nếu xuất hiện trong tên hoặc email hoặc số điện thoại thì in ra thông tin người đó
//      Sắp xếp theo tên tăng dần (theo thứ tự từ điển: a-z, A-Z, 0-1-2...)
//      Sắp xếp theo tuổi giảm dần
    
    // Phương thức này để sắp xếp danh sách theo tuổi giảm dần
    static void ageDescending(Person[] people) {
        Person temp;
        int quantity = people.length;
        for (int i = 0; i < (quantity - 1); ++i) {
            for (int j = 0; j < (quantity - i - 1); ++j) {
                if (people[j].getAge() < people[j+1].getAge()) {
                    temp = people[j];
                    people[j] = people[j+1];
                    people[j+1] = temp;
                }
            }
        }
    }

    // Phương thức này để sắp xếp danh sách theo tên tăng dần theo thứ tự từ điển
    // Đọc thêm: https://viettuts.vn/java-string/so-sanh-chuoi-trong-java
    static void nameAscending(Person[] people) {
        Person temp;
        int quantity = people.length;
        for (int i = 0; i < (quantity - 1); ++i) {
            for (int j = 0; j < (quantity - i - 1); ++j) {
                if ( (people[j].getName()).compareTo(people[j+1].getName()) > 0) {
                    temp = people[j];
                    people[j] = people[j+1];
                    people[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        
        // Tạo mảng chung để quản lý Teacher và Student
        Person[] peopleList = new Person[8];
        
        // Tạo 2 giáo viên
        peopleList[0] = new Teacher("TC01", "Nguyen Xuan Nam", Gender.MALE, 
                                    LocalDate.of(1987, 6, 15), "ngxnam_87@gmail.com", 
                                    "0903876598", 8, "Java");
        peopleList[1] = new Teacher("TC02", "Tao Thuy Quynh", Gender.FEMALE, 
                                    LocalDate.of(1995, 12, 5), "taoquynh95@techmaster.vn", 
                                    "0987562987", 3, "Front-end");
        // Tạo 6 học sinh
        peopleList[2] = new Student("ST01", "Nguyen Trung Duc", Gender.MALE, 
                                    LocalDate.of(1994, 4, 29), "duc.nguyentrung.94@gmail.com", 
                                    "0373331381", false, "Da di lam");
        peopleList[3] = new Student("ST02", "Ngo Huu Hung", Gender.MALE, 
                                    LocalDate.of(1987, 11, 15), "hungnh@pti.com.vn", 
                                    "0876394873", true, "Da di lam");
        peopleList[4] = new Student("ST03", "Vuong Khanh Huyen", Gender.FEMALE, 
                                    LocalDate.of(1996, 12, 7), "khanhhuyen712@gmail.com", 
                                    "0783651482", false, "Dang di hoc"); 
        peopleList[5] = new Student("ST04", "Dinh Duc Thang", Gender.MALE, 
                                    LocalDate.of(1990, 7, 31), "dinhthang90@pti.com.vn", 
                                    "0978355277", false, "Da di lam"); 
        peopleList[6] = new Student("ST05", "Tran Thu Hong", Gender.FEMALE, 
                                    LocalDate.of(1991, 3, 10), "hongtran@gmail.com", 
                                    "0876456782", true, "Da di lam");
        peopleList[7] = new Student("ST06", "Tran Thi Hoai Huong", Gender.FEMALE, 
                                    LocalDate.of(2002, 5, 12), "hhtran2002@gmail.com", 
                                    "0943786912", false, "Dang di hoc");
        
        // In ra danh sách lớp (giáo viên và học sinh)
        System.out.println("Danh sach lop:");
        for (Person person: peopleList) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher)person;
                teacher.printInfo();
            } else if (person instanceof Student) {
                Student student = (Student)person;
                student.printInfo();
            }
        }
        // Hoặc viết như sau cũng được
        // for (Person person: peopleList) {
        //     person.printInfo();;
        // }

        // Sắp xếp danh sách lớp theo tuổi giảm dần
        ageDescending(peopleList);
        System.out.println("\n\nDanh sach lop theo tuoi giam dan:");
        for (Person person: peopleList) {
            person.printInfo();
            System.out.printf(" - %d TUỔI", person.getAge());
        }

        // Sắp xếp theo tên tăng dần (theo thứ tự a-z, A-Z, 0-1-2...)
        nameAscending(peopleList);
        System.out.println("\n\nDanh sach lop theo ten tang dan:");
        for (Person person: peopleList) {
            person.printInfo();
        }

        // Tìm kiếm theo keyword bất kỳ, nếu xuất hiện trong tên hoặc email hoặc số điện thoại thì in ra thông tin người đó
        Scanner input = new Scanner(System.in);
        System.out.println("\n\nNhap keyword can tim (ten, email, so dien thoai): ");
        String keyword = input.nextLine().toLowerCase();
        boolean isFound = false;
        for (Person person: peopleList) {
            if (person.keywordSearch(keyword)) {
                person.printInfo();
                isFound = true;
            }
        }
        if (isFound==false) {
            System.out.println("\tKhong tim thay");
        }
        input.close();
    }
}