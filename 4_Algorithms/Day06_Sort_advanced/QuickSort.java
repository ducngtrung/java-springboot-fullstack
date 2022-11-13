import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {25,30,45,6,11,90,50};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    // Áp dụng đệ quy
    static void sort(int[] arr, int iLeft, int iRight) {
        // Điều kiện dừng
        if (iLeft >= iRight) {
            return;
        }

        // Lấy phần tử ở giữa mảng làm key
        int iMid = (iLeft + iRight)/2;
        int key = arr[iMid];

        // Phân bố mảng:
        //      So sánh các phần tử với key và sắp xếp
        //      Lấy ra vị trí chốt để chia mảng
        int divider = partition(arr, iLeft, iRight, key);

        // Chia mảng ở vị trí chốt và tiếp tục phân bố trong nội bộ các mảng con
        sort(arr, iLeft, divider-1);
        sort(arr, divider, iRight);
    }

    static int partition(int[] arr, int iLeft, int iRight, int key) {
        int iL = iLeft;
        int iR = iRight;
        while (iL <= iR) {
            while (arr[iL] < key) {
                ++iL;
            }
            while (arr[iR] > key) {
                --iR;
            }
            // Đổi chỗ các phần tử không đúng vị trí
            if (iL <= iR) {
                int temp = arr[iL];
                arr[iL] = arr[iR];
                arr[iR] = temp;
                ++iL;
                --iR;
            }
        }
        return iL;
    }
}