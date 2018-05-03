package easy;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len = Math.max(a.length(), b.length());
        int c = 0;
        for (int i = 0; i < len; i++) {
            int num1 = a.length() - i - 1 >= 0 ? a.charAt(a.length() - i - 1) - '0' : 0;
            int num2 = b.length() - i - 1 >= 0 ? b.charAt(b.length() - i - 1) - '0' : 0;
            int sum = num1 + num2 + c;
            if (sum >= 2) {
                sb.append(sum % 2);
                c = sum / 2;
            } else {
                sb.append(sum);
                c = 0;
            }
        }
        while (c > 0) {
            sb.append(c % 2);
            c /= 2;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1010", "1011"));
    }
}
