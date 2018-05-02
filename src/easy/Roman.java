package easy;

import java.util.HashMap;
import java.util.Map;

public class Roman {

    private final static Map<Character, Integer> BASE;

    static {
        BASE = new HashMap<>(7);
        BASE.put('I', 1);
        BASE.put('V', 5);
        BASE.put('X', 10);
        BASE.put('L', 50);
        BASE.put('C', 100);
        BASE.put('D', 500);
        BASE.put('M', 1000);
    }

    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // i
            if (c == 'I') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'V') {
                    res += BASE.get('V') - BASE.get('I');
                    i++;
                    continue;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'X') {
                    res += BASE.get('X') - BASE.get('I');
                    i++;
                    continue;
                }
            }

            // x
            if (c == 'X') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'L') {
                    res += BASE.get('L') - BASE.get('X');
                    i++;
                    continue;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'C') {
                    res += BASE.get('C') - BASE.get('X');
                    i++;
                    continue;
                }
            }

            // c
            if (c == 'C') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'D') {
                    res += BASE.get('D') - BASE.get('C');
                    i++;
                    continue;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'M') {
                    res += BASE.get('M') - BASE.get('C');
                    i++;
                    continue;
                }
            }

            // general
            res += BASE.get(c);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Roman().romanToInt("IX"));
    }
}
