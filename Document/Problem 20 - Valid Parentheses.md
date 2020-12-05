# Problem 20 - Valid Parentheses

From: Leetcode

Difficulty: Easy



## 问题描述

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.



## 示例

```
Input: s = "()"
Output: true
```

```
Input: s = "()[]{}"
Output: true
```

```
Input: s = "([)]"
Output: false
```

**Constraints:**

- `1 <= s.length <= 104`
- `s` consists of parentheses only `'()[]{}'`.



## 思路

​	像这种括号匹配问题最好用的就是栈结构，在学习数据结构课程的时候示例之一就是括号匹配。



## 代码

```java
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
```



## 结果

Runtime: 1 ms, faster than 98.88% of Java online submissions for Valid Parentheses.

Memory Usage: 37.3 MB, less than 38.65% of Java online submissions for Valid Parentheses.