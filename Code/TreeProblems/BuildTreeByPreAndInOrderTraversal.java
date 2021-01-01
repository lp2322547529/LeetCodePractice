package TreeProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过前序便利和中序遍历重建二叉树
 * 注意：要想重建二叉树必须需要中序遍历的结果
 *      要想结果唯一必须不存在重复的元素
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * You may assume that duplicates do not exist in the tree.
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author:linpeng
 * @date:20210101
 * @version:v1.0
 *
 * Runtime: 1 ms, faster than 98.00% of Java online submissions.
 * Memory Usage: 38.9 MB, less than 68.55% of Java online submissions.
 */
public class BuildTreeByPreAndInOrderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, map, 0, inorder.length - 1, 0);
    }

    public TreeNode buildTree(int[] pre, Map<Integer, Integer> map, int start, int end, int preIndex) {
        if (preIndex >= pre.length || start > end) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preIndex]);
        if (start == end) {
            return node;
        }

        int mid = map.get(pre[preIndex]);
        node.left = buildTree(pre, map, start, mid - 1, preIndex + 1);
        node.right = buildTree(pre, map, mid + 1, end, preIndex + mid - start + 1);

        return node;
    }
}
