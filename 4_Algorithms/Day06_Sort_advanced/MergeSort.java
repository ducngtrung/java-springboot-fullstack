import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {25,30,45,6,11,90,50};
        int[] result = sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(result));
    }

    // Áp dụng đệ quy
    static int[] sort(int[] arr, int iLeft, int iRight) {
        // Điều kiện dừng
        if (iLeft == iRight) {
            int[] singleElement = {arr[iLeft]};
            return singleElement;
        }

        // Chia đôi mảng thành 2 mảng con
        int iMid = (iLeft + iRight)/2;
        int[] arrLeft = sort(arr, iLeft, iMid);
        int[] arrRight = sort(arr, iMid+1, iRight);

        // Gộp 2 mảng con (vừa sắp xếp vừa gộp)
        int[] result = merge(arrLeft, arrRight);

        return result;
    }

    static int[] merge(int[] arr1, int[] arr2) {
        int n = arr1.length + arr2.length;
        int[] result = new int[n];

        int i = 0;
        int j = 0;
        int k = 0;

        // So sánh các phần tử giữa 2 mảng con và đưa lần lượt từng phần tử vào mảng result theo thứ tự tăng dần
        while (k < n) {
            if (i < arr1.length && j < arr2.length) { // arr1 và arr2 không rỗng
                if (arr1[i] <= arr2[j]) {
                    result[k] = arr1[i];
                    ++i;
                    ++k;
                } else { // arr1[i] > arr2[j]
                    result[k] = arr2[j];
                    ++j;
                    ++k;
                }
            } else { // arr1 hoặc arr2 rỗng
                if (i < arr1.length) { // arr1 không rỗng, arr2 rỗng
                    result[k] = arr1[i];
                    ++i;
                    ++k;
                } else { // arr1 rỗng, arr2 không rỗng
                    result[k] = arr2[j];
                    ++j;
                    ++k;
                }
            }
        }
        
        return result;
    }
}