package Day01_Variables_DataTypes;

public class BTVN_3 {
// BÀI 3:
// Cho đoạn code sau:

// double d = 9/5;
// System.out.println(d);

// Giá trị của d được in ra là bao nhiêu ? Hãy sửa code để d có giá trị là 1.8
    public static void main(String[] args) {
        double d = 9/5;
        System.out.println(d);

        double ket_qua = (double)9/5;
        System.out.println(ket_qua);

        // Cách 2:
        // double ket_qua = 9/5d;
        // System.out.println(ket_qua);
    }
}