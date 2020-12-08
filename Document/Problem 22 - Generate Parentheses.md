# Problem 22 - Generate Parentheses

From: Leetcode

Difficulty: Medium



## 问题描述

Given `n` pairs of parentheses, write a function to *generate all combinations of well-formed parentheses*.



## 示例

```
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
```

```
Input: n = 1
Output: ["()"]
```

**Constraints:**

- `1 <= n <= 8`



## 思路

​	递归写法，使用栈保存排列组合。N-每次操作要么新增左括号并压入栈，要么弹出栈中的左括号匹配成对。



## 代码

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author:linpeng
 * @date:20201206
 * @version:v1.0
 */
public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        generatePair(result, "", n, n);

        return result;
    }

    public static void generatePair(List<String> result, String temp, int left, int right) {
        if(left > right) {
            return;
        }
        if(left == 0 && right == 0) {
            result.add(temp);
            return;
        }
        if(left > 0) {
            generatePair(result, temp + "(", left - 1, right);
        }
        if(right > 0) {
            generatePair(result, temp + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}

```



## 结果

Runtime: 1 ms, faster than 82.03% of Java online submissions for Generate Parentheses.

Memory Usage: 39 MB, less than 83.30% of Java online submissions for Generate Parentheses.