package easy;

public class Sqrt {
    public int mySqrt(int x) {
        for (int i = 1; i < x; i++) {
            if (i * i == x) {
                return i;
            }
            if (i  * i > x) {
                return i - 1;
            }
        }
        return (int)Math.sqrt(x);
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(2147395600));
    }
}
