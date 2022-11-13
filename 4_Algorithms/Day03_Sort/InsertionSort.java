import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {6,3,12,0,9,8,1};
        System.out.println("Mảng ban đầu:");
        System.out.println(Arrays.toString(arr));

        long startTime = System.nanoTime();
        int[] sortedArray = insertionSort(arr);
        long endTime = System.nanoTime();

        System.out.println("Kết quả:");
        System.out.println(Arrays.toString(sortedArray));
        System.out.println("Thời gian chạy: " + (endTime - startTime));
    }
    
    // Dùng vòng lặp để so sánh mỗi số với các số nằm trước nó
    public static int[] insertionSort(int[] arr) {
        System.out.println("Các lần lặp:");
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i-1;
            while ((j >= 0) && (arr[j] > key)) {
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = key;
            System.out.println("\t" + Arrays.toString(arr));
        }
        return arr;
    }
}