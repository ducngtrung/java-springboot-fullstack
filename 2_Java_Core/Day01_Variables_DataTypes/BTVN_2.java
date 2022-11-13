package Day01_Variables_DataTypes;

public class BTVN_2 {
// BÀI 2:
// Viết chương trình chuyển đổi từ độ F sang độ C
    static float do_F = 51;
    public static void main(String[] args) {
        float do_C = (float) Math.round(((do_F-32) * 5/9) * 100) / 100;
        // Cách 2:    double do_F = 51;  double do_C = Math.round(((do_F-32) * 5/9) * 100.0) / 100.0;
        System.out.println(do_F + " độ F = " + do_C + " độ C");
    }    
}