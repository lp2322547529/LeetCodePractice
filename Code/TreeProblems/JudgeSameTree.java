package TreeProblems;

/**
 * Given the roots of two binary trees p and q,
 * write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.
 *
 * @author:linpeng
 * @date:20201222
 * @version:v1.0
 */
public class JudgeSameTree {

    /**
     * 使用递归判断左右子树
     * 相同：都为空 或者 都不为空且值相同
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
     * Memory Usage: 36.1 MB, less than 91.02% of Java online submissions for Same Tree.
     *
     * @param p
     * @param q
     * @return ture if p and q are structually same
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)
                || (p != null && q != null && p.val != q.val)) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
