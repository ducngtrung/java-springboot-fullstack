package Sort_student;

public class Student {
    public String fullName;
    public int age;
    public double GPA;

    // Constructor
    public Student(String fullName, int age, double GPA) {
        this.fullName = fullName;
        this.age = age;
        this.GPA = GPA;
    }

    public String getName() {
        String[] fullNameArray = fullName.split(" ");
        return fullNameArray[fullNameArray.length-1];
    }
    
    @Override
    public String toString() {
        return "Student{" +
            " fullName='" + fullName + "'" +
            ", age='" + age + "'" +
            ", GPA='" + GPA + "'" +
            "}";
    }
}