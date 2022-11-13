package Day09_Interface.Student_Management;

public class Student implements IClassification {
    enum Clasification {A, B, C}
    private String name;
    private int age;
    private double mark;
    private Clasification clasification;

    // default Constructor
    public Student() {
        this.name = "default name";
        this.age = 20;
        this.mark = 8.0;
    }

    // Getter and Setter
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getMark() {
        return this.mark;
    }
    public void setMark(double mark) {
        this.mark = mark;
    }
    public Clasification getClasification() {
        return this.clasification;
    }
    public void setClasification(Clasification clasification) {
        this.clasification = clasification;
    }

    @Override
    public void classify() {
        if (mark >= 8) {
            setClasification(Clasification.A);
        } else if ((mark < 8) && (mark >= 6.5)) {
            setClasification(Clasification.B);
        } else {
            setClasification(Clasification.C);
        }  
    }   

    @Override
    public void display() {
        System.out.println("Name: " + name + " - Age: " + age 
                            + " - Mark: " + mark + " - Classification: " + clasification);        
    } 
}