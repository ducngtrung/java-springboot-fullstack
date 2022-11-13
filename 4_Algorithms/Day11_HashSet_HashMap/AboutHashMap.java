import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class AboutHashMap {
    public static void main(String[] args) {
        // HashMap
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(3, "Ngoc");
        hashMap.put(1, "Linh");
        hashMap.put(2, "Dung");
        hashMap.put(1, "Huyen"); // ghi đè vào key 1 đã có
        System.out.println(hashMap); // các cặp key-value được in ra KHÔNG theo thứ tự thêm vào

        // Sử dụng Entry interface để truy cập key và value của từng entry
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println(hashMap.remove(2)); // trả về value ứng với key 2 trước khi xóa cặp key-value đó
        System.out.println(hashMap.containsKey(1)); // check xem có tồn tại key 1 hay không


        // LinkedHashMap
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(3, "Java");
        linkedHashMap.put(1, "Python");
        linkedHashMap.put(2, "Spark");
        System.out.println(linkedHashMap); // các cặp key-value được in ra theo đúng thứ tự thêm vào


        // TreeMap
        Map<Integer, String> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        treeMap.put(3, "Java");
        treeMap.put(1, "Python");
        treeMap.put(2, "Spark");
        System.out.println(treeMap);
    }
}