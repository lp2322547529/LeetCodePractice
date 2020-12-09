package ListProblems;

import static ListProblems.ListUtil.printList;

/**
 * @author:linpeng
 * @date:20201209
 * @version:v1.0
 */
public class SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        // 先处理head
        ListNode current = head;
        ListNode newHead = head.next;
        ListNode temp;
        while(current != null && current.next != null) {
            // 交换node,如果temp.next为空则设为temp
            temp = current.next.next;
            current.next.next = current;
            current.next = (temp != null && temp.next != null) ? temp.next : temp;

            // 移到下一组node的第一个节点
            current = temp;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode temp = list;
        for(int i = 2; i <= 10; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        printList(list);

        printList(swapPairs(list));
    }
}
