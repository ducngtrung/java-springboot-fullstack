import java.util.LinkedList;

public class AboutLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        
        linkedList.add(3);
        linkedList.add(10);
        linkedList.add(1);
        
        // Dùng forEach để duyệt qua toàn bộ phần tử
        linkedList.forEach(i -> System.out.print(i + "\t"));
        System.out.println();

        // Thêm phần tử vào đầu/cuối danh sách
        linkedList.addFirst(0);
        linkedList.addLast(9);
        linkedList.forEach(i -> System.out.print(i + "\t"));
        System.out.println();

        // Xóa các phần tử là số chẵn
        linkedList.removeIf(i -> (i%2 == 0));
        linkedList.forEach(i -> System.out.print(i + "\t"));
        System.out.println();

        System.out.println("Phần tử đầu tiên: " + linkedList.getFirst());
        // hoặc: System.out.println("Phần tử đầu tiên: " + linkedList.peek());
        System.out.println("Phần tử cuối cùng: " + linkedList.getLast());

        // Lấy ra phần tử đầu tiên rồi xóa nó khỏi linkedList
        System.out.println("Phần tử đầu tiên: " + linkedList.removeFirst());
        linkedList.forEach(i -> System.out.print(i + "\t"));
        System.out.println();
    }
}