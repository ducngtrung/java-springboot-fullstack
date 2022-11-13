public class About_String {
    public static void main(String[] args) {
        // Sử dụng String Literal để tạo xâu ký tự
        String s1 = "cat";
        String s2 = "cat";

        // Sử dụng từ khóa "new" để tạo xâu ký tự
        String s3 = new String("cat");
        String s4 = new String("cat");

        // Phép so sánh dựa trên đối tượng (địa chỉ của đối tượng trên bộ nhớ)
        System.out.println("s1==s2? " + (s1==s2));
        System.out.println("s2==s3? " + (s2==s3));
        System.out.println("s3==s4? " + (s3==s4));

        // Phép so sánh chỉ dựa trên giá trị của đối tượng
        System.out.println(s3.equals(s2));
        System.out.println(s3.equals(s4));

        String text = "Toi la coder";
        System.out.println(text);
        System.out.println("Length: " + text.length());
        System.out.println("Chu hoa: " + text.toUpperCase());
        System.out.println("Chu thuong: " + text.toLowerCase());
        
        // Lấy ký tự ở một vị trí nào đó (tính từ 0)
        char ch = text.charAt(5);
        System.out.println("Ky tu so 5: " + ch);
        
        // Tìm vị trí của sub string
        int firstIndex = text.indexOf("la");
        System.out.println("Tim thay tu 'la' tai vi tri: " + firstIndex);

        // Tìm vị trí của ký tự o xuất hiện cuối cùng
        int lastIndex = text.lastIndexOf("o");
        System.out.println("Ky tu o cuoi cung o vi tri: " + lastIndex);

        // Trích xuất sub string
        String subString = text.substring(1, 6);
        System.out.println("Sub String: " + subString);

        // Kiểm tra xem một ký tự bất kỳ có phải là chữ cái hay không
        System.out.println(Character.isLetter('3'));
    }
}