package dto;

// "Dto" means Data to Object
public class MemberDto {
    public String id;
    public String name;
    public String role;
    public String gender;
    public String birthday;
    public String email;
    public String phoneNumber;

    // Constructor
    public MemberDto(String id, String name, String role, String gender, String birthday, 
                     String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getter
    public String getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getRole() {
        return this.role;
    }
    public String getGender() {
        return this.gender;
    }
    public String getBirthday() {
        return this.birthday;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}