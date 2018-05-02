package easy;

public class Reverse {
    public int reverse(int x) {
        Long res = 0L;
        while(x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        if (Integer.MIN_VALUE <= res && res <= Integer.MAX_VALUE) {
            return res.intValue();
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Reverse().reverse(-123));
    }
}
