package Day07_Abstraction_Polymorphism.Class_Pack;

import java.time.LocalDate;

public class Teacher extends Person {
// Viết class Teacher kế thừa từ class Person, có các thuộc tính sau:
//      yearOfExperiences (int)
//      speciality (String) (chuyên môn, ví dụ java front-end, design… )

// Viết phương thức khởi tạo cho class Teacher trong đó gọi constructor của class Person.
// Ghi đè phương thức printInfo() của class Person.
    
    private int yearOfExp;      // số năm kinh nghiệm
    private String speciality;  // chuyên môn

    // Constructor
    public Teacher(String id, String name, Gender gender, LocalDate birthday, String email, String phoneNumber,
                    int yearOfExp, String speciality) {
        super(id, name, gender, birthday, email, phoneNumber);
        this.yearOfExp = yearOfExp;
        this.speciality = speciality;
    }

    // Ghi đè phương thức printInfo() của class Person
    @Override
    public void printInfo() {
        System.out.print("\nTeacher:\t" + this.getID() + " - " + this.getName()
                            + " - " + this.getGender() + " - " + this.FormattedBirthday()
                            + " - " + this.getEmail() + " - " + this.getPhoneNum()
                            + " - " + this.yearOfExp + " years of experience in " + this.speciality);
    }

    // Getter
    public int getYearOfExp() {
        return this.yearOfExp;
    }
    public String getSpeciality() {
        return this.speciality;
    }
}