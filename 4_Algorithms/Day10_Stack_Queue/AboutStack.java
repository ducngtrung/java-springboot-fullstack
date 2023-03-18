import java.util.Stack;

public class AboutStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        // Thêm phần tử vào stack (First in, Last out)
        stack.push(2);
        stack.push(1);
        stack.push(7);
        stack.push(9);
        System.out.println(stack);

        System.out.println("Lấy ra phần tử trên đỉnh và xóa phần tử đó: " + stack.pop());
        System.out.println(stack);
        System.out.println("Lấy ra phần tử trên đỉnh: " + stack.peek());
        
        // Tìm kiếm phần tử và trả về vị trí của phần tử đó tính từ đỉnh stack
        System.out.println("Tìm kiếm: " + stack.search(2));

        // Dùng pop() trong vòng lặp for để in ra các phần tử (thứ tự từ đỉnh stack xuống đáy)
        int size = stack.size();
        for (int i = 0; i < size; ++i) {
            System.out.println(stack.pop() + "\t");
        }
    }
}