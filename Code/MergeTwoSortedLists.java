import java.util.List;

/**
  @author:linpeng
  @date:20201205
  @version:v1.0
 **/
public class MergeTwoSortedLists {


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode p = l1;
        ListNode q = l2;
        ListNode res;
        if(p.val <= q.val) {
            res = p;
            p = p.next;
        } else {
            res = q;
            q = q.next;
        }
        ListNode s = res;

        while(p != null && q != null) {
            if(p.val <= q.val) {
                s.next = p;
                p = p.next;
            } else {
                s.next = q;
                q = q.next;
            }
            s = s.next;
        }

        while(p != null) {
            s.next = p;
            p = p.next;
            s = s.next;
        }
        while(q != null) {
            s.next = q;
            q = q.next;
            s = s.next;
        }

        return res;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void printList(ListNode l1) {
        ListNode list = l1;
        while(list != null) {
            System.out.print(list.val + "  ");
            list = list.next;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode p = l1;
        ListNode q = l2;
        for(int i = 1; i <= 5; i++) {
            p.next = new ListNode(2 * i);
            p = p.next;

            q.next = new ListNode(2 * i + 1);
            q = q.next;
        }

        printList(l1);
        System.out.println();
        printList(l2);
        System.out.println();
        printList(mergeTwoLists(l1, l2));
    }
}
