package Day06_Encapsulation_Inheritance.Animal_Pack;

public class Cat extends Animal{
    // Constructor để nhập weight cho Cat object
    public Cat(double weight) {
        this.weight = weight;
    }

    public double getCatWeight() {
        return this.getWeight();    // Phương thức getWeight() được kế thừa từ class Animal
    }

    // Nạp chồng (overload) phương thức:
    // (các phương thức có thể trùng tên nhưng khác về số lượng tham số hoặc kiểu dữ liệu)
    public void run(double speed) {
        System.out.println("speed with double value: " + speed);
    }
    public void run(float speed) {
        System.out.println("speed with float value: " + speed);
    }
    public void run(double speed, int second) {
        System.out.println("in " + second + " seconds the cat will get speed " + speed + "km/h");
    }
}