package ListProblems;

/**
 * @author:linpeng
 * @date:20201209
 * @version:v1.0
 */
public class ListNode {
        public int val;
        public ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
}
