package Day04_Array_Method;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai_kiem_tra_so_1 {
    // BÀI 1
    // Viết chương trình thực hiện:

    // In ra màn hình hình vuông
    // * * * *
    // * * * *
    // * * * *
    // * * * *

    // In ra màn hình hình tam giác
    // *
    // * *
    // * * *
    // * * * *

    //    *
    //   * *
    //  * * *
    // * * * *
    static void BAI_1() {
        System.out.println("\n==========BÀI 1==========");

        System.out.println("Hình vuông:");
        for (int i=1; i<=4; ++i) {
            for (int j=1; j<=4; ++j) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }

        System.out.println("Hình tam giác 1:");
        for (int i=1; i<=4; ++i) {
            for (int j=1; j<=i; ++j) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }

        System.out.println("Hình tam giác 2:");
        for (int i=1; i<=4; ++i) {
            for (int j=1; j<=i; ++j) {
                if (j==1) {
                    for (int k=4-i; k>0; --k) {
                        System.out.print(" ");
                    }
                }
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }


    // BÀI 2
    // Cho chuỗi sau: "You only live once, but if you do it right, once is enough"
    // Thực hiện:
    // - Đếm số từ trong chuỗi
    // - Đếm và in ra index của các ký tự 'o'
    static void BAI_2() {
        System.out.println("\n==========BÀI 2==========");
        String text = "You only live once, but if you do it right, once is enough";
        System.out.println(text);

        String[] array = text.split(" ");
        System.out.printf("\nCâu trên có %d từ", array.length);

        int count=0;
        System.out.print("\nKý tự 'o' xuất hiện ở các vị trí: ");
        for (int index = 0; index < text.length(); ++index) {
            char character = text.charAt(index);
            if (character=='o') {
                System.out.print(index + " ");
                ++count;
            }
        }
        System.out.printf("\nCó %d ký tự 'o'\n", count);
    }


    // BÀI 3
    // Viết chương trình sinh ra số ngẫu nhiên, kiểm tra xem số đó có phải số nguyên tố hay không.
    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void BAI_3(Scanner input) {
        System.out.println("\n==========BÀI 3==========");
        System.out.print("Nhập một số nguyên: ");
        int intNum = input.nextInt();
        input.nextLine(); // Thêm dòng này để không bị tràn lệnh sau khi nhập vào một số (kiểu int, double, v.v.)

        if (isPrimeNumber(intNum)) {
            System.out.println("Là số nguyên tố");
        } else {
            System.out.println("Không phải số nguyên tố");
        }
    }


    // BÀI 4
    // Viết chương trình thực hiện:
    // - Liệt kê 10 số nguyên tố đầu tiên
    // - Liệt kê các số nguyên tố nhỏ hơn 10
    static void BAI_4() {
        System.out.println("\n==========BÀI 4==========");
        System.out.print("10 số nguyên tố đầu tiên: ");
        int count=1;
        int Num=2;
        do {
            if (isPrimeNumber(Num)) {
                System.out.print(Num + " ");
                ++count;
            }
            ++Num;
        } while (count<=10);

        System.out.print("\nCác số nguyên tố nhỏ hơn 10: ");
        Num=2;
        do {
            if (isPrimeNumber(Num)) {
                System.out.print(Num + " ");
            }
            ++Num;
        } while (Num<10);

        System.out.print("\n");
    }


    // BÀI 5
    // Tạo mảng 2 chiều với số dòng và cột nhập vào từ bàn phím.
    // Thực hiện:
    // - Nhập các phần tử mảng
    // - In thông tin mảng ra màn hình
    // - Liệt kê các phần tử nằm trên đường chéo chính
    // - Tạo thêm 1 mảng hai chiều có cùng số dòng và số cột, thực hiện cộng hai mảng với nhau
    static void BAI_5(Scanner input) {
        System.out.println("\n==========BÀI 5==========");
        System.out.println("Nhập số dòng và số cột của mảng 2 chiều:");
        int numRow = input.nextInt();
        int numCol = input.nextInt();

        int[][] Array1 = new int[numRow][numCol];
        System.out.println("\nNhập các số nguyên là phần tử của mảng 1:");
        for (int i=0; i<numRow; ++i) {
            System.out.printf("Dòng %d: ",i+1);
            for (int j=0; j<numCol; ++j) {
                Array1[i][j] = input.nextInt();
            }
        }

        System.out.println("\nMảng 1:");
        for (int i=0; i<numRow; ++i) {
            for (int j=0; j<numCol; ++j) {
                System.out.print(Array1[i][j] + "\t");
            }
            System.out.print("\n");
        }

        if (numRow==numCol) {
            System.out.println("\nCác phần tử nằm trên đường chéo chính:");
            for (int i=0; i<numRow; ++i) {
                System.out.print(Array1[i][i] + "\t");
            }
            System.out.print("\n");
        } else {
            System.out.println("\nKhông có đường chéo chính");
        }

        int[][] Array2 = new int[numRow][numCol];
        System.out.println("\nNhập các số nguyên là phần tử của mảng 2:");
        for (int i=0; i<numRow; ++i) {
            System.out.printf("Dòng %d: ",i+1);
            for (int j=0; j<numCol; ++j) {
                Array2[i][j] = input.nextInt();
            }
        }

        System.out.println("\nMảng 2:");
        for (int i=0; i<numRow; ++i) {
            for (int j=0; j<numCol; ++j) {
                System.out.print(Array2[i][j] + "\t");
            }
            System.out.print("\n");
        }

        System.out.println("\nCộng Mảng 1 với Mảng 2:");
        for (int i=0; i<numRow; ++i) {
            for (int j=0; j<numCol; ++j) {
                System.out.print((Array1[i][j] + Array2[i][j]) + "\t");
            }
            System.out.print("\n");
        }

        input.nextLine(); // Thêm dòng này để không bị tràn lệnh sau khi nhập vào một số (kiểu int, double, v.v.)
    }


    // BÀI 6 (Nâng cao)
    // Viết chương trình nhập vào từ bàn phím email và số điện thoại.
    // Kiểm tra xem email và số điện thoại đó có hợp lệ không.
    // Gợi ý: Sử dụng regex https://viettuts.vn/java/su-dung-regex-trong-java
    static void BAI_6(Scanner input) {
        System.out.println("\n==========BÀI 6==========");
        System.out.println("Nhập email và số điện thoại:");
        String email = input.nextLine();
        String phonenumber = input.nextLine();

        // Email có dạng: ten@domain.xxx hoặc ten@domain.xxx.yyy, trong đó:
        // - ten phải bắt đầu bằng chữ cái
        // - domain chỉ chứa chữ cái, chữ số và có thể có 1 dấu gạch ngang
        // - xxx và yyy là các chữ cái và có độ dài từ 2 ký tự trở lên 
        String EMAIL_PATTERN = "^[a-zA-Z].+@([\\w]+[-]*[\\w]+\\.[\\w]{2,}|[\\w]+[-]*[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        
        // Số điện thoại bắt đầu bằng số 0 và chứa từ 9 đến 11 chữ số
        String PHONE_NUMBER_PATTERN = "^0[0-9]{8,10}$";
         
        if (Pattern.matches(EMAIL_PATTERN, email)) {
            System.out.println("\nEmail hợp lệ");
        } else {
            System.out.println("\nEmail KHÔNG hợp lệ");
        }

        if (Pattern.matches(PHONE_NUMBER_PATTERN, phonenumber)) {
            System.out.println("SĐT hợp lệ");
        } else {
            System.out.println("SĐT KHÔNG hợp lệ");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BAI_1();
        BAI_2();
        BAI_3(input);
        BAI_4();
        BAI_5(input);
        BAI_6(input);
        input.close();
    }
}