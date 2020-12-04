# Problem 19 - Remove Nth Node From End of List

From: Leetcode

Difficulty: Medium



## 问题描述

Given the `head` of a linked list, remove the `nth` node from the end of the list and return its head.

**Follow up:** Could you do this in one pass?



## 示例

```
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
```

```
Input: head = [1], n = 1
Output: []
```

```
Input: head = [1,2], n = 1
Output: [1]
```

**Constraints:**

- The number of nodes in the list is `sz`.
- `1 <= sz <= 30`
- `0 <= Node.val <= 100`
- `1 <= n <= sz`



## 思路


​	（1）可以遍历一次获取总Node数，减一下就知道应该在第几个切断

​	（2）双指针，q指针移动到链表到N个，之后使用另一个指针p指向链表头，两个指针一起向后移动，直到q到达了链表最后一个节点，这样p指向的就是倒数第n个节点



## 代码

```java
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

    public static void printList(ListNode head) {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val + "  ");
            current = current.next;
        }
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
```



## 结果

Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.

Memory Usage: 36.9 MB, less than 57.73% of Java online submissions for Remove Nth Node From End of List.