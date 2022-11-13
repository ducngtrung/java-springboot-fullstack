package Day11_Comparator_Collection.Kiem_tra_15_phut.src;

public class Seller extends Employee {  
    private double revenue;

    // Constructor
    public Seller(String name, double revenue, double salary) {
        super(name, salary);
        this.revenue = revenue;
    }
    
    // Calculate salary based on revenue
    public double getSalary() {
        if (revenue < 4000) {
            return (super.getSalary() + (revenue*0.05));
        } else {
            return (super.getSalary() + (revenue*0.1));
        }
    }

    @Override
    public String toString() {
        return "{" +
            " revenue='" + revenue + "'" +
            "}";
    }    
}