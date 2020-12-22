package TreeProblems;

/**
 * @author:linpeng
 * @date:20201221
 * @version:v1.0
 */
public class JudgeBSTree {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    public boolean dfs(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        } else {
            if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
                return false;
            } else {
                return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
            }
        }
    }
}
