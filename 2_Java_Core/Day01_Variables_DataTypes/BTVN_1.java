package Day01_Variables_DataTypes;

public class BTVN_1 {
// BÀI 1:
// Cho đoạn code sau:

// int i = 10;
// int n = i++ % 5;
    public static void main(String[] args) {
        int i = 10;
        int n = i++ % 5;

        // a. In ra giá trị cuối cùng của 2 biến i và n        
        System.out.print("i = "); System.out.println(i);
        System.out.println("n = " + n);  // Cách viết gộp 2 dòng print
        
        // b. Nếu thay phép toán tăng i++ (postfix increment operator) bằng ++i (prefix increment operator) thì giá trị cuối cùng của i và n là bao nhiêu?
        int j = 10;
        int m = ++j % 5;
        System.out.println("j = " + j);
        System.out.println("m = " + m);

        // ++i: tăng giá trị i lên 1 và trả về giá trị mới i+1
        // i++: tăng giá trị i lên 1 nhưng trả về giá trị cũ i
    }
}