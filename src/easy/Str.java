package easy;

import java.util.HashMap;
import java.util.Map;

public class Str {

    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean find = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        find = false;
                        break;
                    }
                }
                if (find) {
                    return i;
                }
            }
        }

        return -1;
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (map1.containsKey(a)) {
                if (map1.get(a) != b) {
                    return false;
                }
            } else {
                map1.put(a, b);
            }

            if (map2.containsKey(b)) {
                if (map2.get(b) != a) {
                    return false;
                }
            } else {
                map2.put(b, a);
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String h = "ab";
        String n = "aa";
        System.out.println(new Str().isIsomorphic(h, n));
        System.out.println((int)Character.MAX_VALUE);
    }
}
