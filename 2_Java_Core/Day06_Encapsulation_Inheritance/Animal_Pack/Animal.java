package Day06_Encapsulation_Inheritance.Animal_Pack;

public class Animal {
    private String size;        // Large, Medium, Small
    protected double weight;    // weight được gọi trực tiếp trong subclass Cat và Chicken nên không thể khai báo private

    // Getter để lấy thông tin từ thuộc tính
    public String getSize() {
        return this.size;
    }
    public double getWeight() {
        return this.weight;
    }
}