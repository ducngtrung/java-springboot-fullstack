package Day05_OOP;

public class MyDogs {
    // 4 loại access modifier là: public, private, default, protected
    public String breed;     
    public String size;
    public int age;
    public String color;
    public static String gender;    // Biến static

    // Biến static tồn tại trước khi object được khởi tạo, nó thuộc class chứ không thuộc object
    // Một phương thức static chỉ có thể gọi được biến static (và phương thức static khác)
    // Nên hạn chế việc sử dụng biến static và phương thức static

    // Constructor mặc định
    public MyDogs() {
        breed = "Husky";
        size = "large";
        age = 3;
        color = "black";
    }

    // Constructor có tham số
    public MyDogs(String breed, String size, String color, int age) {
        //Từ khóa this đề cập tới object hiện tại trong một phương thức hoặc một Constructor
        this.breed = breed;
        this.size = size;
        this.age = age;
        this.color = color;
    }

    // Phương thức (method)
    public void eat() {
        System.out.println("mum mum mum");
    }

    public String toString() {
        //Từ khóa this đề cập tới object hiện tại trong một phương thức hoặc một Constructor
        String text = this.breed + " " + this.size;
        return text;
    }

    public void printBreedSize() {
        String textToPrint = this.toString();
        System.out.println(textToPrint);
    }

    public void printAttributes() {
        System.out.println(breed);
        System.out.println(color);
        System.out.println(size);
        System.out.println(age);
    }

    // Phương thức static (static method)
    public static void bark() {
        System.out.println("go go go...");
    }
}