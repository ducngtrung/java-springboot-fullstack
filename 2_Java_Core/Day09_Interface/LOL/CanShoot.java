package Day09_Interface.LOL;

public interface CanShoot {
    // Phương thức trong interface không có thân hàm, luôn ở dạng public abstract mà không cần khai báo.
    public abstract void shoot(); // Viết gọn thành void shoot();

    // Phương thức static có thân hàm và KHÔNG thể override khi một class implements nó
    static void checkStatic() {
        System.out.println("Day la static method");
    }

    // Phương thức default có thân hàm và CÓ thể override khi một class implements nó
    default void checkDefault() {
        System.out.println("\nDay la default method CanShoot");
    }
    
    // Biến trong interface luôn ở dạng public static final và phải có giá trị
    public static final String action = "shoot"; // Viết gọn thành String action = "shoot";
}