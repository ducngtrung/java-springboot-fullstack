package Day03_If_Switch_Loop;

public class BTVN_2 {
// BÀI 2:
// Viết chương trình tính tổng 100 số nguyên tố đầu tiên.
    public static void main(String[] args) {
        int sum = 0;
        int intNum = 2;
        int count = 1;
        boolean isPrime;
        
        System.out.println("100 số nguyên tố đầu tiên:");
        do {
            // Kiểm tra xem intNum có phải số nguyên tố hay không
            isPrime = true;
            for (int i = 2; i <= intNum/2; i++) {
                if (intNum % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            // Nếu intNum là số nguyên tố thì cộng vào biến sum và tăng biến count thêm 1
            if (isPrime == true) {
                System.out.print(intNum + "\t");
                sum += intNum; // sum = sum + intNum;
                ++count;
            }
            // Tăng biến intNum để kiểm tra số nguyên tiếp theo
            ++intNum;
        } while (count <= 100);

        System.out.println("\nTổng 100 số nguyên tố đầu tiên: " + sum);
    }
}