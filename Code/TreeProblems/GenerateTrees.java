package TreeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:linpeng
 * @date:20201217
 * @version:v1.0
 */
public class GenerateTrees {

    public static List<TreeNode> generateTrees(int n) {
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

                        //由于平衡二叉树的特性，右边的肯定是大于根节点的，所有值加上root的值等于取了后面的数
                        root.left = left;
                        root.right = resetValue(right, root.val);
                        dp[i].add(root);
                    }
                }
            }
        }

        return dp[n];
    }

    public static TreeNode resetValue(TreeNode root, int offset) {

        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val + offset);
        node.left = resetValue(root.left, offset);
        node.right = resetValue(root.right, offset);
        return node;
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }
}
