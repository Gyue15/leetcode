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
        while(index > -1) {
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

    public static void main(String... args) {
        int[] arr = {-1, 3, 2};
        rotate(arr, 2);
        PrintUtil.printArr(arr, "Rotate");
    }

}
