package Day01_Variables_DataTypes;

public class BTVN_4 {
// BÀI 4:
// Khai báo biến x và y tuỳ ý. Viết câu lệnh in ra giá trị các biểu thức sau:
    public static void main(String[] args) {
        int x = 1010020;
        int y = 10;
        System.out.println(x);
        System.out.println(y);
        
        //  x là số dương
        boolean result1 = x>0;
        System.out.println("x là số dương: " + result1);

        //  x chia hết cho y
        boolean result2 = (x%y)==0;
        System.out.println("x chia hết cho y: " + result2);
        
        //  x nằm trong khoảng từ 2 đến 15
        boolean result3 = (x>=2) && (x<=15);
        System.out.println("x nằm trong khoảng từ 2 đến 15: " + result3);
        
        //  Hiệu số của x và y nhỏ hơn 5
        boolean result4 = (x-y)<5;
        System.out.println("Hiệu số của x và y nhỏ hơn 5: " + result4);

        //  x không thuộc khoảng từ 10 đến 30
        boolean result5 = (x<10) || (x>30);
        System.out.println("x không thuộc khoảng từ 10 đến 30: " + result5);

        //  x có nhiều hơn 4 chữ số
        boolean result6 = x>9999;
        System.out.println("x có nhiều hơn 4 chữ số: " + result6);
        
        //  x có chính xác 6 chữ số
        boolean result7 = (x>=100000) && (x<=999999);
        System.out.println("x có chính xác 6 chữ số: " + result7);
    }
}