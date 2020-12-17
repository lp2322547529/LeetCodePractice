# Problem 95 - Unique Binary Search Trees

From: Leetcode

Difficulty: Medium



## 问题描述

Given *n*, how many structurally unique **BST's** (binary search trees) that store values 1 ... *n*?



Given an integer `n`, generate all structurally unique **BST's** (binary search trees) that store values 1 ... *n*.

**Constraints:**

- `1 <= n <= 19`

## 示例

```
Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```



```
Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```

## 思路

​	使用dp思路。初始化dp[0]和dp[1]，对于dp[2]以上来说，可以分作两部分看待，左子树a个节点，右子树i-a-1个节点，因此左右子树可能的结构分别为dp[a], dp[i - a- 1]，双重for循环排列组合。同时要注意到，右子树我们使用的是下于根节点的值的，而且根节点的值取得是左子树节点个数+1，因此右子树所有节点需要值加上root的值即可。

## 代码

```java
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }

        List<TreeNode>[] dp = new List[n + 1];
        // 初始化
        dp[0] = new ArrayList<TreeNode>();
        dp[0].add(null);
        dp[1] = new ArrayList<TreeNode>();
        dp[1].add(new TreeNode(1));

        // 利用前面的dp值进行处理
        for (int i = 2; i <= n; i++) {
            dp[i] = new ArrayList<TreeNode>();

            // 可以看作是 左边dp[j]，右边节是dp[i - j - 1]，将左右的排列组合
            for (int j = 0; j < i; j++) {
                for (TreeNode left : dp[j]) {
                    for (TreeNode right : dp[i - j - 1]) {
                        TreeNode root = new TreeNode(j + 1);

                        //由于平衡二叉树的特性，右边大于根节点的，所有值加上root的值等于取了后面的数
                        root.left = left;
                        root.right = resetValue(right, root.val);
                        dp[i].add(root);
                    }
                }
            }
        }

        return dp[n];
    }

    public TreeNode resetValue(TreeNode root, int offset) {
        if (root == null) {
            return null;
        }
        
        // 所有节点的值加上offset
        TreeNode node = new TreeNode(root.val + offset);
        node.left = resetValue(root.left, offset);
        node.right = resetValue(root.right, offset);
        return node;
    }
```



## 结果

Runtime: 2 ms, faster than 13.36% of Java online submissions for Unique Binary Search Trees II.

Memory Usage: 41.9 MB, less than 9.20% of Java online submissions for Unique Binary Search Trees II.