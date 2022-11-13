package model;

import java.time.LocalDate;

import util.DateTimeUtil;

public class User {
    protected int id;
    protected String name;
    protected LocalDate birthday;
    protected Gender gender;
    protected String email;
    protected String phoneNumber;

    // Constructor
    public User(int id, String name, LocalDate birthday, Gender gender, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    // Getter
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public LocalDate getBirthday() {
        return this.birthday;
    }
    public Gender getGender() {
        return this.gender;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    // Print user info (except ID)
    public void printInfo() {
        System.out.println("name: " + this.name + ", birthday: " + DateTimeUtil.convertLocalDateToString(this.birthday)
        + ", gender: " + this.gender + ", email: " + this.email + ", phone number: " + this.phoneNumber);
    }
}