package TreeProblems;

import ListProblems.ListNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author:linpeng
 * @date:20201221
 * @version:v1.0
 */
public class LevelTraversal {

    public ListNode[] levelTraversal(TreeNode tree) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (tree != null) {
            queue.offer(tree);
        }
        // 以每一层为一次for循环将所有的节点加到list中，且将子节点加到queue中
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            lists.add(list);
        }

        // 遍历链表变成数组的形式
        int len = lists.size();
        ListNode[] res = new ListNode[len];
        for (int i = 0; i < len; i++) {
            ListNode dumy = new ListNode(0);
            ListNode cur = dumy;
            for (int j = 0; j < lists.get(i).size(); j++) {
                dumy.next = new ListNode(lists.get(i).get(j));
                dumy = dumy.next;
            }
            res[i] = cur.next;
        }
        return res;
    }
}
