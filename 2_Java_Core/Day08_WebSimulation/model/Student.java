package model;

import java.time.LocalDate;

import util.DateTimeUtil;

public class Student extends User {
    private boolean isOnline;
    private String background;

    // Constructor
    public Student(int id, String name, LocalDate birthday, Gender gender, String email, String phoneNumber, 
                   boolean isOnline, String background) {
        super(id, name, birthday, gender, email, phoneNumber);
        this.isOnline = isOnline;
        this.background = background;
    }
    
    // Getter
    public boolean getIsOnline() {
        return this.isOnline;
    }
    public String getBackground() {
        return this.background;
    }

    @Override
    public void printInfo() {
        System.out.println(this.name + " - " + this.gender
                            + " - " + DateTimeUtil.convertLocalDateToString(this.birthday)
                            + " - " + this.email + " - Phone: " + this.phoneNumber
                            + " - " + this.background + " - Online status: " + this.isOnline);
    }
}