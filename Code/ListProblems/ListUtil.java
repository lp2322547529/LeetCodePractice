package ListProblems;

/**
 * @author:linpeng
 * @date:20201209
 * @version:v1.0
 */
public class ListUtil {
    public static ListNode genList(int start, int num, int step) {
        ListNode list = new ListNode(start);
        ListNode temp = list;
        for(int i = 1; i < num; i++) {
            temp.next = new ListNode(i * step + start);
            temp = temp.next;
        }
        return list;
    }

    public static void printList(ListNode list) {
        while (list != null) {
            System.out.print(list.val + "  ");
            list = list.next;
        }
        System.out.println();
    }

    public static ListNode reverseList(ListNode list) {
        ListNode pre = null;
        ListNode cur = list;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    public static ListNode getLastNode(ListNode list) {
        while(list.next != null) {
            list = list.next;
        }
        return list;
    }
}
