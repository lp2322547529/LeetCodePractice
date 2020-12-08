/**
 * @author:linpeng
 * @date:20201208
 * @version:v1.0
 */
public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length <= 0) {
            return null;
        } else if(lists.length == 1) {
            return lists[0];
        }

        MinPriorityQueue minPriorityQueue = new MinPriorityQueue(lists.length);
        minPriorityQueue.add(lists);
        ListNode res = minPriorityQueue.popMin();
        if(res == null) {
            return null;
        }
        ListNode cur = res;
        ListNode pop;
        while((pop = minPriorityQueue.popMin()) != null) {
            cur.next = pop;
            cur = cur.next;
        }

        return res;
    }

    static class MinPriorityQueue {
        private int length;
        private ListNode[] array;

        MinPriorityQueue() {
        }

        MinPriorityQueue(int capacity) {
            this.length = capacity;
            this.array = new ListNode[capacity];
        }

        void add(ListNode[] lists) {
            for (int i = 0; i < lists.length; i++) {
                array[i] = lists[i];
            }
        }

        ListNode popMin() {
            int min = minIndex();
            if (min >= 0) {
                ListNode node = array[min];
                array[min] = node.next;
                return node;
            }

            return null;
        }

        int minIndex() {
            int min = -1;
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (array[i] != null && array[i].val <= minValue) {
                    min = i;
                    minValue = array[i].val;
                }
            }
            return min;
        }
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

    static void printList(ListNode l1) {
        ListNode list = l1;
        while(list != null) {
            System.out.print(list.val + "  ");
            list = list.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode cur3 = l3;

        for(int i = 1; i <= 5; i++) {
            cur1.next = new ListNode(i*3);
            cur1 = cur1.next;
            cur2.next = new ListNode(i*3 + 1);
            cur2 = cur2.next;
            cur3.next = new ListNode(i*3 + 2);
            cur3 = cur3.next;
        }

        printList(l1);
        System.out.println();
        printList(l2);
        System.out.println();
        printList(l3);
        System.out.println();

        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;
        ListNode res = mergeKLists(lists);
        printList(res);
    }
}
