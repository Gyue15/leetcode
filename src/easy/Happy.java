package easy;

import java.util.HashSet;
import java.util.Set;

public class Happy {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int next = 0;
            while (n != 0) {
                next += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = next;
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Happy().isHappy(18));
    }
}
