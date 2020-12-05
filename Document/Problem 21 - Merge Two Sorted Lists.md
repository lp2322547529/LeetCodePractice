# Problem 21 - Merge Two Sorted Lists

From: Leetcode

Difficulty: Easy



## 问题描述

Merge two sorted linked lists and return it as a new **sorted** list. The new list should be made by splicing together the nodes of the first two lists.



## 示例

```
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
```

```
Input: l1 = [], l2 = []
Output: []
```

**Constraints:**

- The number of nodes in both lists is in the range `[0, 50]`.
- `-100 <= Node.val <= 100`
- Both `l1` and `l2` are sorted in **non-decreasing** order.



## 思路

​	链表已经排序了，合并后的排序实际上就是合并时添加比较大小，谁小连接谁。实现的时候不新建节点，单纯的改变节点的next的值



## 代码

```
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
```



## 结果

Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.

Memory Usage: 38.5 MB, less than 30.59% of Java online submissions for Merge Two Sorted Lists.