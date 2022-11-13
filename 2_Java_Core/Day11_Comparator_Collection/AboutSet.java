package Day11_Comparator_Collection;

import java.util.HashSet;
import java.util.Set;

public class AboutSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        Set<Integer> set1 = new HashSet<>();
        set1.addAll(set);
        System.out.println(set1);
        set1.clear();
        System.out.println(set1);

        Set<Integer> set2 = new HashSet<>();
        set2.addAll(set);
        set2.add(3);
        System.out.println(set2);
        set2.removeAll(set);
        System.out.println(set2);
    }
}