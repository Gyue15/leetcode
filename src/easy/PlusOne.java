package easy;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int c = 1;
        boolean needNewArr = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            int n = digits[i];
            n += c;
            if (n >= 10) {
                digits[i] = 0;
                c = n / 10;
                if (i == 0) {
                    needNewArr = true;
                }
            } else {
                digits[i] = n;
                c = 0;
            }
        }
        if (needNewArr) {
            int[] arr = new int[digits.length + 1];
            arr[0] = c;
            System.arraycopy(digits, 0, arr, 1, digits.length);
            return arr;
        } else {
            return digits;
        }
    }
}
