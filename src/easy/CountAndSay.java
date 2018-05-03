package easy;

public class CountAndSay {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 0; i < n - 1; i++) {
            str = countAndSay(str);
        }
        return str;
    }

    private String countAndSay(String str) {
        StringBuilder sb = new StringBuilder();
        int repeat = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                repeat++;
            } else {
                sb.append(repeat).append(str.charAt(i - 1));
                repeat = 1;
            }
        }
        sb.append(repeat).append(str.charAt(str.length() - 1));

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4));
    }
}
