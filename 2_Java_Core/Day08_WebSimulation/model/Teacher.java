package model;

import java.time.LocalDate;

import util.DateTimeUtil;

public class Teacher extends User {
    private int yearOfExp;
    private String speciality;

    // Constructor
    public Teacher(int id, String name, LocalDate birthday, Gender gender, String email, String phoneNumber, 
                   int yearOfExp, String speciality) {
        super(id, name, birthday, gender, email, phoneNumber);
        this.yearOfExp = yearOfExp;
        this.speciality = speciality;
    }

    // Getter
    public String getSpeciality() {
        return this.speciality;
    }
    public int getYearOfExperience() {
        return this.yearOfExp;
    }

    @Override
    public void printInfo() {
        System.out.println(this.name + " - " + this.gender
                            + " - " + DateTimeUtil.convertLocalDateToString(this.birthday)
                            + " - " + this.email + " - Phone: " + this.phoneNumber
                            + " - " + this.yearOfExp + " years of experience in " + this.speciality);
    }
}