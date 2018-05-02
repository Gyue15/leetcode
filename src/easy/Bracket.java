package easy;

import java.util.Stack;

public class Bracket {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isRight(c)) {
                if (stack.size() == 0) {
                    return false;
                }
                char left = stack.pop();
                if (!isValid(left, c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }

    private boolean isRight(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    private boolean isValid(char left, char right) {
        return (left == '[' && right == ']') || (left == '{' && right == '}') || (left == '(' && right == ')');
    }

    public static void main(String[] args) {
        System.out.println(new Bracket().isValid("{[]}"));
    }
}
