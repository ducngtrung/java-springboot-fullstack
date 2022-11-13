import java.util.Arrays;

public class Day01_Array {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int x = 6;

        // Chèn số 6 vào vị trí đầu của mảng
        int[] array2 = insertFirst(array1, x);
        System.out.println(Arrays.toString(array2));

        // Chèn số 6 vào vị trí cuối của mảng
        int[] array3 = insertLast(array1, x);
        System.out.println(Arrays.toString(array3));

        // Chèn số 6 vào vị trí bất kỳ của mảng
        int[] array4 = insertSpecific(array1, x, 4);
        System.out.println(Arrays.toString(array4));

        // Sắp xếp mảng theo thứ tự tăng dần
        int[] array5 = {5,7,9,7,2,4};
        int[] array6 = sortAscending(array5);
        System.out.println(Arrays.toString(array6));
    }

    static int[] insertFirst(int[] arr1, int x) {
        int[] arr2 = new int[arr1.length + 1];
        arr2[0] = x;

        for (int i=0; i < arr1.length; ++i) {
            arr2[i+1] = arr1[i]; 
        }
        
        return arr2;
    }

    static int[] insertLast(int[] arr1, int x) {
        int[] arr2 = new int[arr1.length + 1];

        for (int i=0; i < arr2.length; ++i) {
            if (i == arr2.length-1) {
                arr2[i] = x;
            } else {
                arr2[i] = arr1[i];
            }
        }
        return arr2;
    }

    static int[] insertSpecific(int[] arr1, int x, int position) {
        int[] arr2 = new int[arr1.length + 1];
        arr2[position-1] = x;
        
        for (int i=0; i < arr2.length; ++i) {
            if (i < position-1) {
                arr2[i] = arr1[i];
            } else if (i > position-1) {
                arr2[i] = arr1[i-1];
            }
        }
        return arr2;
    }

    static int[] sortAscending(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i+1; j < arr.length; ++j) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }  
}