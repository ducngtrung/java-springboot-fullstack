package Day06_Encapsulation_Inheritance;

// import các class từ package Animal_Pack
import Day06_Encapsulation_Inheritance.Animal_Pack.Cat;
import Day06_Encapsulation_Inheritance.Animal_Pack.Chicken;

public class Main6 {
    public static void main(String[] args) {
        Cat cat = new Cat(3.6);
        Chicken chicken = new Chicken(1.5);

        System.out.println("cat weight: " + cat.getCatWeight());
        System.out.println("chicken weight: " + chicken.getWeight());
        
        cat.run(100.0);     // gọi phương thức run(double speed)
        cat.run(100.0f);    // gọi phương thức run(float speed)
        cat.run(100.0, 30);     // gọi phương thức run(double speed, int second)
    }
}