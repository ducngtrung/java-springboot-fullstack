package Day07_Abstraction_Polymorphism.Vehicle_Pack;

public class Car {
    String brand;
    int year;

    // Constructor
    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public void horn(boolean isCrowd) {
        if (isCrowd) {
            System.out.println(this.brand + " TUY TUY TUY ...");
        } else {
            System.out.println(this.brand + " Tuyt tuyt ...");
        }
    }

    public void horn() {
        System.out.println(this.brand + " Tit Tit");
    }
}