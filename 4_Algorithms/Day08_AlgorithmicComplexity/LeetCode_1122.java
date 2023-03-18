import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
// Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

public class LeetCode_1122 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] resultArr = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(resultArr));
    }

    static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] resultArr = new int[arr1.length];
        
        // Tạo ra một set từ các phần tử của arr2 (vì arr2 chỉ chứa các phần tử không trùng lặp)
        Set<Integer> arr2Set = new HashSet<>();
        for (Integer num : arr2) {
            arr2Set.add(num);
        }

        // Với mỗi phần tử trong arr2 duyệt từng phần tử trong arr1, nếu tìm thấy cặp bằng nhau thì đưa vào resultArr
        int j = 0, k = 0;
        while (j < arr2.length) {
            for (int i = 0; i < arr1.length; ++i) {
                if (arr1[i] == arr2[j]) {
                    resultArr[k] = arr1[i];
                    ++k;
                }
            }
            ++j;
        }

        // Lưu index tiếp theo của resultArr (để bắt đầu xếp các phần tử thuộc arr1 nhưng không thuộc arr2)
        int rightIdx = k; 

        // Duyệt từng phần tử trong arr1, nếu không nằm trong set arr2 thì tiếp tục đưa vào resultArr
        for (int i = 0; i < arr1.length; ++i) {
            if (!arr2Set.contains(arr1[i])) {
                resultArr[k] = arr1[i];
                ++k;
            }
        }

        // Sắp xếp resultArr tăng dần kể từ rightIdx đến hết mảng
        Arrays.sort(resultArr, rightIdx, resultArr.length);

        return resultArr;
    }
}