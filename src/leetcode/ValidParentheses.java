package leetcode;

import realization.Stack;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(([]))"));
        System.out.println("=========");

        System.out.println(isValid("()[]"));
        System.out.println("=========");

        System.out.println(isValid("((()"));
        System.out.println("=========");

    }

    /**
     * () {} [] 괄호가 제대로 닫혔는지
     * // 스택
     */
    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            } else if (current == ')' || current == ']' || current == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (
                        (current == ')' && pop != '(') ||
                                (current == ']' && pop != '[') ||
                                (current == '}' && pop != '{')
                ) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid(String s) {
        while (true) {
            if (s.contains("()")) {
                s = s.replace("()", "");
            } else if (s.contains("{}")) {
                s = s.replace("{}", "");
            } else if (s.contains("[]")) {
                s = s.replace("[]", "");
            } else {
                return s.isEmpty();
            }
        }
    }
}