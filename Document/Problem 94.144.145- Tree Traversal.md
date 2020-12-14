

# Problem 94.144.145- Tree Traversal

From: Leetcode

Difficulty: Medium



## 问题描述

Given the `root` of a binary tree, return *the preorder traversal of its nodes' values*.

Given the `root` of a binary tree, return *the inorder traversal of its nodes' values*.

Given the `root` of a binary tree, return *the postorder traversal of its nodes' values*.

**Constraints:**

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`



## 示例

```
Input: root = [1,null,2,3]
Output: [1,2,3]
```

```
Input: root = [1,null,2,3]
Output: [1,3,2]
```

```
Input: root = [1,null,2,3]
Output: [3,2,1]
```



## 思路

​	数的遍历，使用递归。



## 代码

```java
	/**
     *  前序遍历
     * @param root 数根节点
     * @return 前序遍历结果list
     */
	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        preorder(result, root);
        return result;
    }

    public static void preorder(List list, TreeNode current) {
        if (current == null) {
            return;
        }

        list.add(current.val);
        preorder(list, current.left);
        preorder(list, current.right);
    }

    /**
     *  中序遍历
     * @param root 数根节点
     * @return 中序遍历结果list
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        inorder(result, root);
        return result;
    }

    public static void inorder(List list, TreeNode current) {
        if (current == null) {
            return;
        }

        inorder(list, current.left);
        list.add(current.val);
        inorder(list, current.right);
    }

    /**
     *  后序遍历
     * @param root 数根节点
     * @return 后序遍历结果list
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        postorder(result, root);
        return result;
    }

    public static void postorder(List list, TreeNode current) {
        if (current == null) {
            return;
        }

        postorder(list, current.left);
        postorder(list, current.right);
        list.add(current.val);
    }
```



## 结果

Runtime: **0 ms**

Memory Usage: **37.5 MB**



Runtime: **0 ms**

Memory Usage: **37.2 MB**



Runtime: **0 ms**

Memory Usage: **37.2 MB**