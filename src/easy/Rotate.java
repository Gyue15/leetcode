package easy;

import util.PrintUtil;

public class Rotate {

    public static void rotate(int[] arr, int k) {
        rotate(arr, arr.length, k);

    }

    private static void rotate(int[] arr, int len, int k) {
        if (len == 0 || len == k) {
            return;
        }
        k = k % len;
        if (k == 0) {
            return;
        }
        int index = len - k - 1;
        int count = 0;
        while (index > -1) {
            int element = arr[index];
            arr[index] = arr[index + k];
            arr[index + k] = element;
            index--;
            count++;
            PrintUtil.printArr(arr, "Rotate" + count);
        }

        len = k;
        k = k - count % k;
        rotate(arr, len, k);
    }

    public static void rotate2(int[] arr, int k) {
        int len = arr.length;
        if (len == 0 || len == k) {
            return;
        }
        k = k % len;

        reverse(arr, 0, len - k - 1);
        reverse(arr, len - k, len - 1);
        reverse(arr, 0, len - 1);
    }

    private static void reverse(int[] arr, int from, int to) {
        for (int i = 0; i < (to - from  +1) / 2; i++) {
            int temp = arr[from + i];
            arr[from + i] = arr[to - i];
            arr[to - i] = temp;
        }
    }

    public static void main(String... args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate2(arr, 3);
        PrintUtil.printArr(arr, "Rotate");
    }

}
