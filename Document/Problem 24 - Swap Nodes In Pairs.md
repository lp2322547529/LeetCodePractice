# Problem 24 - Swap Nodes In Pairs

From: Leetcode

Difficulty: medium



## 问题描述

Given a linked list, swap every two adjacent nodes and return its head.

You may **not** modify the values in the list's nodes. Only nodes itself may be changed.



## 示例

```
Input: head = [1,2,3,4]
Output: [2,1,4,3]
```

**Constraints:**

- The number of nodes in the list is in the range `[0, 100]`.
- `0 <= Node.val <= 100`



## 思路

​	两两交换，而且以两个为一组，不是像冒泡一样换。用指针指向当前要交换节点对的前一个节点，这样就可以分别使用current.next和current.next.next指向两个节点。再执行熟悉的链表swap操作。

​    注意：空，如果当前组的下一组节点组中会出现只剩下一个或者全为空的情况，需要考虑当前current.next要如何取值。 current.next = (temp != null && temp.next != null) ? temp.next  : temp;



## 代码

```java
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
```



## 结果

Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.

Memory Usage: 36.9 MB, less than 10.72% of Java online submissions for Swap Nodes in Pairs.