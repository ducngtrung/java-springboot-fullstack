package Day07_Abstraction_Polymorphism.Animal_Pack;

public class Dog extends Animal {
    
    // Constructor
    public Dog(String name, String breed, double weight) {
        super(name, breed, weight); // Dùng super(...) để gọi Constructor của superclass (lớp cha)
    }

    @Override   // Ghi đè (override) phương thức abstract ở class Animal
    public void speak() {
        System.out.println(this.name + " speaks Go Go Go !!!");        
    }

    public void move() {
        super.move();       // Dùng từ khóa super để gọi phương thức của superclass (lớp cha)
        System.out.println(super.getName() + " Dog moves");
    }
}