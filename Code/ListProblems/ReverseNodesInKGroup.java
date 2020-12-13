package ListProblems;

import static ListProblems.ListUtil.*;

/**
 * @author:linpeng
 * @date:20201211
 * @version:v1.0
 */
public class ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = res, nex = res, pre = res;

        // 获取链表节点数
        int count = 0;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }

        // 按组进行反转
        while (count >= k) {
            cur = pre.next;
            nex = cur.next;
            for (int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            count -= k;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode list = genList(0, 10, 1);
        printList(list);
        printList(reverseKGroup(list, 3));
    }
}
