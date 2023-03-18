import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class AboutHashSet {
    public static void main(String[] args) {
        // HashSet
        Set<Integer> hashSet = new HashSet<>();
        System.out.println(hashSet.add(1));
        System.out.println(hashSet.add(10));
        System.out.println(hashSet.add(21));
        System.out.println(hashSet.add(1)); // in ra false vì phần tử 1 đã tồn tại trong set
        System.out.println(hashSet.add(2));
        System.out.println(hashSet); // các phần tử được in ra KHÔNG theo thứ tự thêm vào


        // LinkedHashSet
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        System.out.println(linkedHashSet.add(1));
        System.out.println(linkedHashSet.add(10));
        System.out.println(linkedHashSet.add(21));
        System.out.println(linkedHashSet.add(14));
        System.out.println(linkedHashSet.add(9));
        System.out.println(linkedHashSet); // in ra các phần tử theo đúng thứ tự thêm vào

        
        // TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>();
        System.out.println(treeSet.add(1));
        System.out.println(treeSet.add(10));
        System.out.println(treeSet.add(21));
        System.out.println(treeSet.add(14));
        System.out.println(treeSet.add(9));
        System.out.println(treeSet); // in ra các phần tử theo thứ tự tăng dần
        System.out.println(treeSet.descendingSet()); // in ra các phần tử theo thứ tự giảm dần
    }
}
