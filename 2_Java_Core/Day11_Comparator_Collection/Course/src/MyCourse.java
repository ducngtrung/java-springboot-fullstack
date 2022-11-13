import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyCourse implements ICourse { 

    @Override
    public void f1(List<Course> a, int st) {
        if (st == 1) {
            System.out.println("sort courses list by it's fee ASC: ");
            Collections.sort(a, new Comparator<Course>() {
                @Override
                public int compare(Course o1, Course o2) {
                    return (o1.getFee() > o2.getFee()) ? 1 : -1;
                    // 2 giá trị return 1 và -1 thực chất chỉ cần là một số <0 và một số >0
                    // nếu return 0 thì hàm compare hiểu là 2 phần tử được so sánh = nhau
                }
            });
            // show courses list
            for (Course course : a) {
                System.out.println(course.toString());
            }
        } else {
            System.out.println("sort courses list by it's name DESC: ");
            Collections.sort(a, new Comparator<Course>() {
                @Override
                public int compare(Course o1, Course o2) {
                    return o2.getName().compareToIgnoreCase(o1.getName());
                }
            });
            // show courses list
            for (Course course : a) {
                System.out.println(course.toString());
            }
        }
    }

    @Override
    public int f2(List<Course> a, double fee) {
        int count = 0;
        for (Course course : a) {
            if (course.getFee() >= fee) {
                ++count;
            }
        }
        return count;
    }
}