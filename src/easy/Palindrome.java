package easy;

public class Palindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        Long res = 0L;
        int orign = x;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return Integer.MIN_VALUE <= res && res <= Integer.MAX_VALUE && res.intValue() == orign;
    }

    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome(121));
    }
}
