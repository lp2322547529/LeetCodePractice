# Model Name

From: Leetcode

Difficulty: Hard



## 问题描述

Given a linked list, reverse the nodes of a linked list *k* at a time and return its modified list.

*k* is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of *k* then left-out nodes, in the end, should remain as it is.

**Follow up:**

- Could you solve the problem in `O(1)` extra memory space?
- You may not alter the values in the list's nodes, only nodes itself may be changed.



## 示例

```
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
```

```
Input: head = [1,2,3,4,5], k = 1
Output: [1,2,3,4,5]
```

- The number of nodes in the list is in the range `sz`.
- `1 <= sz <= 5000`
- `0 <= Node.val <= 1000`
- `1 <= k <= sz`



## 思路

​	以K个为一组反转链表，那么实际上可以按照每K个作为一次反转，并且在反转组之间保存每一组反转后的末尾节点。实际实现上可以有依次向后并且每次都反转。 



## 代码

```java
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
```



## 结果

Runtime: 1 ms, faster than 20.74% of Java online submissions for Reverse Nodes in k-Group.

Memory Usage: 39.7 MB, less than 12.28% of Java online submissions for Reverse Nodes in k-Group.