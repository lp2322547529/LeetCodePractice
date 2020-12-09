package ListProblems;

import ListProblems.ListNode;

import static ListProblems.ListUtil.printList;

/**
 * @author:linpeng
 * @date:20201204
 * @version:v1.0
 */
public class RemoveLastKthNode {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;

        // 向后移动n-1步
        int count = n;
        while(count > 0 && q.next != null) {
            q = q.next;
            count--;
        }
        // 如果count大于1说明链表长度小于n，直接返回
        if(count > 1) {
            return head;
        } else if (count == 1) {
            return head.next;
        }

        while(q.next != null) {
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode head = list;
        for(int i = 2; i <= 10; i++) {
            list.next = new ListNode(i);
            list = list.next;
        }

        printList(head);

        System.out.println();

        head = removeNthFromEnd(head, 10);
        printList(head);
    }
}
