package Day07_Abstraction_Polymorphism;

import Day07_Abstraction_Polymorphism.Animal_Pack.Dog;
import Day07_Abstraction_Polymorphism.Vehicle_Pack.Car;
import Day07_Abstraction_Polymorphism.Vehicle_Pack.Sedan;

public class Main7 {
    public static void main(String[] args) {
        Dog dog = new Dog("Chihuahua", "Alex", 5.6);
        dog.speak();
        dog.move();
        
        Sedan sedan = new Sedan("Toyota", 2022, "black");
        sedan.horn(true);   // class Sedan được kế thừa phương thức horn(boolean isCrowd) từ class Car
        sedan.horn();               // Ưu tiên gọi phương thức horn() từ lớp con (class Sedan)
        
        Car car = new Car("BMW", 2021);
        car.horn();     // Gọi phương thức horn() từ class Car

        Car car1 = new Sedan("Honda", 2020, "white");
        car1.horn();    // Gọi phương thức horn() từ class Sedan

        // Sedan sedan1 = (Sedan)car;
        // sedan1.getColor();

        Car car2 = new Sedan("Ford", 2020, "blue");     // Upcasting đối tượng car2 từ Sedan lên Car
        // Toán tử instanceof dùng để kiểm tra một đối tượng có phải là thể hiển của một kiểu dữ liệu cụ thể không (class, interface)
        // Đọc thêm: https://viettuts.vn/java/toan-tu-instanceof-trong-java
        if (car2 instanceof Sedan) { 
            System.out.println("car2 la Sedan");
        } else {
            System.out.println("car2 KHONG la Sedan");
        }
        Sedan sedan2 = (Sedan)car2;     // Downcasting (ép kiểu) cho đối tượng car2 từ Car xuống Sedan
        sedan2.horn();      // Sau khi downcast thì car2 trở thành kiểu Sedan và gọi phương thức horn() từ class Sedan

        Sedan sedan3 = new Sedan("Nissan", 2021, "brown");
        System.out.println(sedan3.getBrand() + " " + sedan3.getColor());
        // Gọi phương thức truyền tham chiếu để thay đổi thuộc tính color của sedan3
        changeColor(sedan3);
        System.out.println(sedan3.getBrand() + " " + sedan3.getColor());

        int number = 10;
        System.out.println("Bien trong phuong thuc main: " + number);
        // Gọi phương thức truyền tham trị. Biến number nằm ngoài phương thức sẽ không bị tác động.
        increase(number);
        System.out.println("Bien trong phuong thuc main: " + number);
    }
    
    // Phương thức truyền tham chiếu (truyền vào một đối tượng)
    public static void changeColor(Sedan sedan) {
        sedan.setColor("gray");
    }
    // Phương thức truyền tham trị (truyền vào giá trị cụ thể, VD: byte, short, int, long, float, double, boolean, char)
    public static void increase(int x) {
        ++x;
        System.out.println("Bien nam trong phuong thuc truyen tham tri: "+ x);
    }
    // Đọc thêm: https://xuanthulab.net/kieu-tham-chieu-va-tham-tri-trong-java.html
}