package TreeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:linpeng
 * @date:20201214
 * @version:v1.0
 */
public class TreeTraversal {
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

    public static void main(String[] args) {
        /**
         *         0
         *     1       2
         * null null 5 null
         */
        TreeNode root = new TreeNode(0, new TreeNode(1), new TreeNode(2, new TreeNode(5), null));
        System.out.println("前序遍历：" + preorderTraversal(root));
        System.out.println("中序遍历：" + inorderTraversal(root));
        System.out.println("后序遍历：" + postorderTraversal(root));

    }
}
