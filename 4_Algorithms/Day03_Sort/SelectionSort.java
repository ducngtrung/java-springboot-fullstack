import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {6,3,12,0,9,8,1};

        System.out.println("Mảng ban đầu:");
        System.out.println(Arrays.toString(arr));

        long startTime = System.nanoTime();
        int[] sortedArray = selectionSort(arr);
        long endTime = System.nanoTime();

        System.out.println("Kết quả:");
        System.out.println(Arrays.toString(sortedArray));
        System.out.println("Thời gian chạy: " + (endTime - startTime));
    }
    
    // Chia mảng thành 2 phần: nửa đầu đã được sắp xếp, nửa sau chưa được sắp xếp
    // Chỉ thực hiện sắp xếp trên nửa sau của mảng, bỏ qua nửa đầu
    public static int[] selectionSort(int[] arr) {
        System.out.println("Các lần lặp:");
        for (int i = 0; i < arr.length-1; ++i) {
            int minIndex = i;

            // Tìm index của phần tử nhỏ nhất
            for (int j = i+1; j < arr.length; ++j) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Đổi vị trí
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            
            System.out.println("\t" + Arrays.toString(arr));
        }
        return arr;
    }
}