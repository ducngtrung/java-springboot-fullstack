package Day05_OOP;

public class About_OOP {
    // Tạo hằng số (enumerator)
    enum Gender {
        MALE,
        FEMALE,
    }

    public static void main(String[] args) {
        // Khai báo object bằng Constructor mặc định
        MyDogs dog1 = new MyDogs();
        MyDogs dog2 = new MyDogs();
        MyDogs dog3 = new MyDogs();

        // In ra thuộc tính mặc định của object vừa tạo
        System.out.println("dog1: " + dog1);
        System.out.println("dog2: " + dog2.age);
        System.out.println("dog3: " + dog3.breed);

        System.out.println(dog1 == dog2); // Vì 2 đối tượng khác nhau nên phép so sánh này trả về false
        
        // Khai báo thuộc tính cụ thể cho từng object vừa tạo
        dog1.breed = "Chihuahua";
        dog1.size = "small";
        dog1.color = "white";
        dog1.age = 2;

        dog2.breed = "Alaska";
        dog2.size = "large";
        dog2.color = "black";
        dog2.age = 3;

        dog3.breed = "Corgi";
        dog3.size = "medium";
        dog3.color = "brown";
        dog3.age = 1;

        System.out.println("dog1: " + dog1.breed);
        System.out.println("dog2: " + dog2.breed);
        System.out.println("dog3: " + dog3.breed);

        // Gọi phương thức
        dog1.eat();

        // Gọi phương thức static
        MyDogs.bark();

        // Khai báo object bằng Constructor có tham số, tiện cho việc khai báo luôn các thuộc tính của object
        MyDogs dog4 = new MyDogs("Poodle", "medium", "brown", 4);
        MyDogs dog5 = new MyDogs("Husky", "large", "black", 5);
        
        System.out.println(dog4.breed);
        System.out.println(dog4.size);
        System.out.println(dog4.color);
        System.out.println(dog4.age);
        
        dog4.printBreedSize();
        dog5.printAttributes();

        // Sử dụng hằng số đã khai báo
        Gender gioi_tinh = Gender.MALE;
        switch (gioi_tinh) {
            case MALE: {
                System.out.println("Con đực");
                break;
            }
            case FEMALE: {
                System.out.println("Con cái");
                break;
            }
        }

        MyDogs[] dogArray = new MyDogs[4];
        dogArray[0] = new MyDogs("chihuahua", "small", "white", 3);
        dogArray[1] = new MyDogs();
        dogArray[2] = null;
        dogArray[3] = new MyDogs("husky", "big", "black", 2);
        int notNullCount = 0;
        for (MyDogs dog: dogArray) {
            if (dog != null) {
                ++notNullCount;
            }
        }
        System.out.println("Number of not-null dogs: " + notNullCount);
        for (MyDogs dog: dogArray) {
            System.out.println("Dog: " + dog.breed + " " + dog.size + " " + dog.color + " " + dog.age);
        } // Đối tượng dogArray[2] là null nên sẽ không thể truy xuất các thuộc tính của đối tượng này
    }
}