package Day07_Abstraction_Polymorphism.Class_Pack;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

// Viết class Person có các thuộc tính sau:
//      id (String)
//      name (String)
//      gender (enum)
//      birthday (LocalDate)
//      email (String)
//      phoneNumber (String)

// Viết constructor cho class Person để tái sử dụng được cho subsclass Student và Teacher.
// Viết phương thức abstract printInfo() để in thông tin cho lớp Person.

public abstract class Person {
    enum Gender {MALE, FEMALE}
    private String id;
    private String name;
    private Gender gender;
    private LocalDate birthday;
    private String email;
    private String phoneNumber;

    // Constructor
    public Person(String id, String name, Gender gender, LocalDate birthday, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Phương thức abstract để in ra thông tin mỗi người
    public abstract void printInfo();

    // Getter
    public String getID() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public Gender getGender() {
        return this.gender;
    }
    public LocalDate getBirthday() {
        return this.birthday;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPhoneNum() {
        return this.phoneNumber;
    }

    // Phương thức này để tính tuổi
    public int getAge() {
        return (Period.between(birthday, LocalDate.now()).getYears());
    }

    // Phương thức này để chuyển ngày sinh thành chuỗi theo format dd/MM/yyyy
    public String FormattedBirthday() {
        DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String birthdayFormatted = this.birthday.format(newFormat);
        return birthdayFormatted;
    }

    // Phương thức này để tìm người theo keyword (tên, email, số điện thoại)
    public boolean keywordSearch(String keyword) {
        boolean result = (this.name.toLowerCase().contains(keyword)
                        || this.email.toLowerCase().contains(keyword)
                        || this.phoneNumber.contains(keyword));
        return result;
    }
}