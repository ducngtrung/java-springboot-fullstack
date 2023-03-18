package Day06_Encapsulation_Inheritance.Animal_Pack;

public class Chicken extends Animal {
    // Constructor để nhập weight cho Chicken object
    public Chicken(double weight) {
        this.weight = weight;
    }

    public Chicken(double weight, String size) {
        this.weight = weight;
        // this.size = size;   thuộc tính size ở class Animal là private nên class Chicken không kế thừa được
    }
}