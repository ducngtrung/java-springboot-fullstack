package Day04_Array_Method;

public class Array {
    public static void main(String[] args) {
        
        // Mảng 1 chiều
        String[] text = new String[4];
        text[0] = "Toi la coder";
        text[1] = "Toi dang hoc Java Core";
        text[2] = "Toi se hoc Java Nang cao";
        
        // Dùng vòng lặp for để in ra mảng
        for (int index=0; index<text.length; ++index) {
            System.out.println("for: " + text[index]);
        }

        // Dùng vòng lặp for each để in ra mảng
        // Vòng lặp for each chỉ dùng để đọc thông tin trong mảng (read), 
        // KHÔNG dùng để thay đổi tính chất của mảng (delete item, update item)
        for (String t: text) {
            System.out.println("foreach: " + t);
        }

        // Mảng 2 chiều
        int[][] twoDimensionArray;
        twoDimensionArray = new int[3][4];
        for (int i=0; i<3; ++i) {
            for (int j=0; j<4; ++j) {
                twoDimensionArray[i][j] = i+j;
                System.out.print(twoDimensionArray[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }
}