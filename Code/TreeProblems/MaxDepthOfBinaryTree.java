package TreeProblems;

/**
 * 2021新年快乐！！！
 *
 * 获取二叉树最大深度
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * @author:linpeng
 * @date:20210101
 * @version:v1.0
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions.
 * Memory Usage: 39.1 MB, less than 46.74% of Java online submissions.
 */
public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int maxDepth = 0;
        return getDepth(root, maxDepth);
    }

    public int getDepth(TreeNode root, int depth) {
        if(root == null) {
            return depth;
        }
        depth++;

        int left = depth;
        int right = depth;
        if(root.left != null) {
            left = getDepth(root.left, depth);
        }
        if(root.right != null) {
            right = getDepth(root.right, depth);
        }

        return Math.max(left, right);
    }
}
