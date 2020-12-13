# Problem 28 - Implement strStr()

From: Leetcode

Difficulty: Easy



## 问题描述

Implement [strStr()](http://www.cplusplus.com/reference/cstring/strstr/).

Return the index of the first occurrence of needle in haystack, or `-1` if `needle` is not part of `haystack`.

**Clarification:**

What should we return when `needle` is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when `needle` is an empty string. This is consistent to C's [strstr()](http://www.cplusplus.com/reference/cstring/strstr/) and Java's [indexOf()](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#indexOf(java.lang.String)).



## 示例

```
Input: haystack = "hello", needle = "ll"
Output: 2
```

```
Input: haystack = "aaaaa", needle = "bba"
Output: -1
```



## 思路

​	实现indexOf()，返回第一次出现needle的位置，如果没有的话返回-1。防止无限制使用substring方法，直接转为char数组对比即可。

​	考虑如果needle是空的话，是否应该返回0。

## 代码

```java
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) {
            return 0;
        }

        int p, q;
        char[] hay = haystack.toCharArray();
        char[] ne = needle.toCharArray();
        for(int i = 0; i < hay.length - ne.length + 1; i++) {
            p = i;
            q = 0;
            while(p < hay.length && q < ne.length && hay[p] == ne[q]) {
                p++;
                q++;
            }
            if(q == ne.length) {
                return i;
            }
        }

        return -1;
    }
```



## 结果

Runtime: 1 ms, faster than 60.97% of Java online submissions for Implement strStr().

Memory Usage: 39.1 MB, less than 15.85% of Java online submissions for Implement strStr().