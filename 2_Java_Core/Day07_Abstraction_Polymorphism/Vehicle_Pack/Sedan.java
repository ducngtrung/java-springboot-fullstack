package Day07_Abstraction_Polymorphism.Vehicle_Pack;

public class Sedan extends Car {
    String color;

    // Constructor
    public Sedan(String brand, int year, String color) {
        super(brand, year);    // Dùng super(...) để gọi Constructor của superclass (lớp cha)
        this.color = color;
    }

    // Getter
    public String getColor() {
        return this.color;
    }
    public String getBrand() {
        return this.brand;
    }
    
    // Setter
    public void setColor(String color) {
        this.color = color;
    }

    public void horn() {
        System.out.println(this.brand + " Bim Bim");
    }
}