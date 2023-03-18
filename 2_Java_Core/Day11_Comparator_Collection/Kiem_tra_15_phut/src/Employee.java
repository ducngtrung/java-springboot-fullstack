package Day11_Comparator_Collection.Kiem_tra_15_phut.src;

public class Employee {
    private String name;
    private double salary;
    
    // Constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + name + "'" +
            ", salary='" + salary + "'" +
            "}";
    } 
}