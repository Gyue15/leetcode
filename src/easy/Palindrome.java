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

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int beginIndex = 0;
        int endIndex = s.length() - 1;
        while (beginIndex < endIndex) {
            while (beginIndex < s.length() && !isLegal(s.charAt(beginIndex))) beginIndex++;
            while (endIndex >= 0 && !isLegal(s.charAt(endIndex))) endIndex--;
            if (beginIndex >= endIndex) {
                return true;
            }
            char a = s.charAt(endIndex);
            char b = s.charAt(beginIndex);
            if (a != b) {
                return false;
            }
            beginIndex++;
            endIndex--;
        }
        return true;
    }

    private boolean isLegal(char c) {
        return 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || '0' <= c && c <= '9';
    }


    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
