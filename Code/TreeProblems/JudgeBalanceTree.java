package TreeProblems;

/**
 * @author:linpeng
 * @date:20201221
 * @version:v1.0
 */
public class JudgeBalanceTree {

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
}
