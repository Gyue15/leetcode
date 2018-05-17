package easy;

public class Excel {
    public String convertToTitleSlow(int n) {
        String s = "A";
        for (int i = 1; i < n; i++) {
            s = addOne(s);
        }
        return s;
    }

    private String addOne(String str) {
        int c = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            char n = str.charAt(i);
            n += c;
            c = 0;
            if (n > 'Z') {
                c = 1;
                n = 'A';
            }
            sb.append(n);
        }
        if (c == 1) {
            sb.append('A');
        }
        return sb.reverse().toString();
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append((char) ('A' + --n % 26));
            n /= 26;
        }

        return sb.reverse().toString();
    }

    public int titleToNumber(String s) {
        int res = 0;
        int multi = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += (s.charAt(i) - 'A' + 1) * multi;
            multi *= 26;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Excel().titleToNumber("AAA"));
    }
}
