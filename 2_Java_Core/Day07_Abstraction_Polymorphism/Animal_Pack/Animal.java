package Day07_Abstraction_Polymorphism.Animal_Pack;

public abstract class Animal {      // Lớp abstract
    String name;
    String breed;
    double weight;

    // Constructor
    public Animal(String name, String breed, double weight) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
    }

    // Getter
    public String getName() {
        return this.name;
    }

    // Phương thức abstract, không chứa phần thân, phần thân được định nghĩa bởi subclass (lớp con)
    public abstract void speak();

    public void move() {
        System.out.println("Animal moves");
    }
}