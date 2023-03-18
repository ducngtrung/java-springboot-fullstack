package Day07_Abstraction_Polymorphism.Class_Pack;

import java.time.LocalDate;

public class Student extends Person {
// Viết class Student kế thừa từ class Person, có các thuộc tính riêng sau:
//      isOnline (học trực tuyến hay ko)
//      background (String, ví dụ: đã đi làm, đang đi học)

// Viết phương thức khởi tạo cho class Student trong đó gọi constructor của class Person.
// Ghi đè phương thức printInfo() của class Person.
    
    private boolean isOnline;
    private String background;

    // Constructor
    public Student(String id, String name, Gender gender, LocalDate birthday, String email, String phoneNumber,
                    boolean isOnline, String background) {
        super(id, name, gender, birthday, email, phoneNumber);
        this.isOnline = isOnline;
        this.background = background;
    }

    // Ghi đè phương thức printInfo() của class Person 
    @Override
    public void printInfo() {
        System.out.print("\nStudent:\t" + this.getID() + " - " + this.getName()
                            + " - " + this.getGender() + " - " + this.FormattedBirthday()
                            + " - " + this.getEmail() + " - " + this.getPhoneNum()
                            + " - " + this.background + " - Online status: " + this.isOnline);
    }

    // Getter
    public boolean getOnlineStatus() {
        return this.isOnline;
    }
    public String getBackground() {
        return this.background;
    }
}