package util;

public class PrintUtil {

    public static void printArr(int[] arr, String name) {
        System.out.print(name + ": [");
        for (int o : arr) {
            System.out.print(o + ", ");
        }
        System.out.println("\b\b]");
    }
}
