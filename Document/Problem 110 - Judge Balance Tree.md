# Problem 110 - Judge Balance Tree

From: Leetcode

Difficulty: Easy



## 问题描述

给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

> 一个二叉树*每个节点* 的左右两个子树的高度差的绝对值不超过 1 。



## 示例

```
输入：root = [3,9,20,null,null,15,7]
输出：true
```

```
输入：root = [1,2,2,3,3,null,null,4,4]
输出：false
```

## 思路

​	树的思想基本就是递归，分别求左右两个子树的高度，比较高度差



## 代码

```java
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return balance(root) >= 0;
    }

    public int balance(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = balance(root.left);
        int right = balance(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
```



## 结果