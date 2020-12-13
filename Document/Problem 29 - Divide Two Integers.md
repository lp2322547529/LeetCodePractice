# Problem 29 - Divide Two Integers

From: Leetcode

Difficulty: Medium



## 问题描述

Given two integers `dividend` and `divisor`, divide two integers without using multiplication, division, and mod operator.

Return the quotient after dividing `dividend` by `divisor`.

The integer division should truncate toward zero, which means losing its fractional part. For example, `truncate(8.345) = 8` and `truncate(-2.7335) = -2`.

**Note:**

- Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For this problem, assume that your function **returns 2^31 − 1 when the division result overflows**.

## 示例

```
Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.
```

```
Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = truncate(-2.33333..) = -2.
```



## 思路

​	实际就是实现除法，结果截断取整。，同时要求不使用 【/】【%】【*】。（那就是用加减法咯......）

​    大体思路是while(num1 >= num2) { res++; num1 -= num2;};  显然这种方法速度太慢了，需处理MIN_VALUE。

​    可以使用右移左移运算符，快速左移的最大数。如 A=100,  B=5   则B<<1到80，等于乘了40，则结果加40，A变为20，B为5继续。

## 代码

```java
   public static int divide(int dividend, int divisor) {
        if(divisor == 0) {
            throw new IllegalArgumentException("除法的被除数不允许为0！");
        }
        // 先确定符号，方便处理溢出的情况
        boolean flag = ((dividend >= 0 ? true : false) == (divisor >= 0 ? true : false));

        // 溢出的情况 min / -1
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 转为正数进行计算
        long dd = (dividend == Integer.MIN_VALUE ? -(long)Integer.MIN_VALUE : Math.abs(dividend));
        long dr = (divisor == Integer.MIN_VALUE ? -(long)Integer.MIN_VALUE : Math.abs(divisor));

        int res = 0;
        while (dd >= dr) {
            int powerOfTwo = 1;
            long value = dr;

            while ((dd >> 1) >= value) {
                value = value << 1;
                powerOfTwo = powerOfTwo << 1;
            }

            res += powerOfTwo;
            dd -= value;
        }

        return flag ? res : -res;
    }
```



## 结果

Runtime: 1 ms, faster than 100.00% of Java online submissions for Divide Two Integers.

Memory Usage: 36.2 MB, less than 52.11% of Java online submissions for Divide Two Integers.