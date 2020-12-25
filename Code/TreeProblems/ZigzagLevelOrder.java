package TreeProblems;

import java.util.*;

/**
 * Zigzag模式的层序遍历
 * Merry Christmas,everyone.
 *
 * @author:linpeng
 * @date:20201225
 * @version:v1.0
 *
 * Runtime: 1 ms, faster than 73.90% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
 * Memory Usage: 38.9 MB, less than 89.01% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // 初始化
        int step = 1;
        TreeNode current = null;
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 每次加入一层节点
        while (!queue.isEmpty()) {
            stack.empty();
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            // 循环本层节点
            for (int i = 1; i <= size; i++) {
                current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }

                // 反向的话使用stack反转本层的所有node
                if (step == -1) {
                    stack.push(current);
                } else {
                    list.add(current.val);
                }
            }

            while (!stack.isEmpty()) {
                list.add(stack.pop().val);
            }
            step = - step;

            result.add(list);
        }

        return result;
    }
}
