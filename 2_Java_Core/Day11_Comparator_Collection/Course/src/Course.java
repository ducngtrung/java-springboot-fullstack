public class Course {   
    private String name;
    private double fee;
    
    // Constructor
    public Course(String name, double fee) {
        this.name=name;
        this.fee = fee;
    }
 
    // Getter
    public String getName() {
        return name;
    }
    public double getFee() {
        return this.fee;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", fee='" + getFee() + "'" +
            "}";
    }
}