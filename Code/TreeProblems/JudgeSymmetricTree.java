package TreeProblems;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric
 * But the following [1,2,2,null,3,null,3] is not
 *
 * Follow up: Solve it both recursively and iteratively.
 *
 * @author:linpeng
 * @date:20201222
 * @version:v1.0
 */
public class JudgeSymmetricTree {

    /**
     * 和判断是否一致树的思路一样
     * 左子树的左子树和右子树的右子树对比，左子树的右子树和右子树的左子树对比
     *
     * @param root
     * @return return true if the tree is a mirror of itself
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
     * Memory Usage: 36.8 MB, less than 85.44% of Java online submissions for Symmetric Tree.
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if ((root1 == null && root2 != null) || (root1 != null && root2 == null)
                || (root1 != null && root2 != null && root1.val != root2.val)) {
            return false;
        }

        return symmetric(root1.left, root2.right) && symmetric(root1.right, root2.left);
    }
}
