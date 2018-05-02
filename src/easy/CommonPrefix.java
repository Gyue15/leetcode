package easy;

public class CommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs[0].length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char c = strs[0].charAt(0);
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            if (index >= strs[i].length()) {
                return sb.toString();
            }

            if (i == strs.length - 1) {
                if (c == strs[i].charAt(index)) {
                    sb.append(c);
                } else {
                    return sb.toString();
                }
                index++;
                i = -1;
            } else if (i == 0) {
                c = strs[i].charAt(index);
            } else {
                if (c != strs[i].charAt(index)) {
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new CommonPrefix().longestCommonPrefix(strs));
    }
}
