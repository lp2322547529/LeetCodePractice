package RealitySituation;

import java.util.Stack;

/**
 * @author:linpeng
 * @date:20201205
 * @version:v1.0
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        if(s == null || "".equals(s)) {
            return true;
        }

        Stack stack = new Stack();
        char[] array = s.toCharArray();
        for(char c : array) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }

                char t = (char)stack.pop();
                if((t == '(' && c == ')')
                        || (t == '[' && c == ']')
                        || (t == '{' && c == '}')) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "([)]";
        String s4 = ")]";
        String s5 = "(";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
    }
}
