package easy;

public class StrStr {

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

    public static void main(String[] args) {
        String h = "hello";
        String n = "";
        System.out.println(new StrStr().strStr(h, n));
    }
}
