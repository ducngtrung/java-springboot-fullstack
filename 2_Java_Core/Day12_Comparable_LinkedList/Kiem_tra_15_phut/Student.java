public class Student {
    private String name;
    private String birthday;
    private String hometown;

    // Constructor
    public Student(String name, String birthday, String hometown) {
        this.name = name;
        this.birthday = birthday;
        this.hometown = hometown;
    }

    // Getter
    public String getBirthday() {
        return this.birthday;
    }
    public String getHometown() {
        return this.hometown;
    }

    // Display Student info
    public void display() {
        System.out.println("\t" + name + " - " + birthday + " - " + hometown);
    }
}