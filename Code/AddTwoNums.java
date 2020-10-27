/**
 * @author:linpeng
 * @date:20201027
 * @version:v1.0
 */
public class AddTwoNums {

    /**
     *
     * @param l1
     * @param l2
     * @return the sum of two nums as a linked list.
     *
     * Example:
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     *
     * Mark:
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Two Numbers.
     * Memory Usage: 39.6 MB, less than 13.17% of Java online submissions for Add Two Numbers.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry = 0, num1, num2, sum;

        // 遍历两个链表，null则视其值为0
        while(l1 != null || l2 != null) {
            num1 = (l1 == null) ? 0 : l1.val;
            num2 = (l2 == null) ? 0 : l2.val;
            sum = num1 + num2 + carry;

            current.next = new ListNode(sum % 10);
            current = current.next;
            carry = sum / 10;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        // 遍历完成如果有进位，需要在尾部新建一个节点
        if(carry != 0) {
            current.next = new ListNode(carry);
        }

        return result.next;
    }

    public static void main(String[] args) {
        // l1:2-8-6  l2:8-9-5-1-2  和：21598+682=22280
        ListNode l1 = new ListNode(2);
        ListNode current = l1;
        current.next = new ListNode(8);
        current = current.next;
        current.next = new ListNode(6);

        ListNode l2 = new ListNode(8);
        current = l2;
        current.next = new ListNode(9);
        current = current.next;
        current.next = new ListNode(5);
        current = current.next;
        current.next = new ListNode(1);
        current = current.next;
        current.next = new ListNode(2);

        ListNode result = addTwoNumbers(l1, l2);
        StringBuffer stringBuffer = new StringBuffer("");
        while (result != null) {
            stringBuffer.append(result.val);
            result = result.next;
        }
        System.out.println("链表：" + stringBuffer.toString());
        System.out.println("两数之和为：" + stringBuffer.reverse().toString());
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
