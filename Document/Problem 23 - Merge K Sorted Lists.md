# Problem 23 - Merge K Sorted Lists

From: Leetcode

Difficulty: hard



## 问题描述

You are given an array of `k` linked-lists `lists`, each linked-list is sorted in ascending order.

*Merge all the linked-lists into one sorted linked-list and return it.*



## 示例

```
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
```

**Constraints:**

- `k == lists.length`
- `0 <= k <= 10^4`
- `0 <= lists[i].length <= 500`
- `-10^4 <= lists[i][j] <= 10^4`
- `lists[i]` is sorted in **ascending order**.
- The sum of `lists[i].length` won't exceed `10^4`.



## 思路

​	emmmm，这就合并K个有序链表了。首先的思路肯定是两两合并，依次解决。（当然，狠一点的方法就是建一个2000大小的数组，遍历K个链表，如果list[i] [j] 的值为m,则arr[m+1000]的值加一，完成后遍历数组......；使用Collections的sort方法也可以，不过也太坑爹了）。

   思考来思考去，突然发现有一神器叫做优先队列，将K个链表的链表头放入，每次比较获最小的。

PS：写完之后我发现我自作多情了，每次都需要遍历，比较次数为 sum(K.length) * k，就这执行时间，还是老老实实两两合并吧，算是自己写写类的锻炼。（等我对数据结构再复习复习学的更精通了再重写一下代码，maybe）

## 代码

```java
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

		// 将链表的头放入队列中
        void add(ListNode[] lists) {
            for (int i = 0; i < lists.length; i++) {
                array[i] = lists[i];
            }
        }
		// 获取最小的node，且在该位置放入该node的下一个node
        ListNode popMin() {
            int min = minIndex();
            if (min >= 0) {
                ListNode node = array[min];
                array[min] = node.next;
                return node;
            }

            return null;
        }
		//获取K个node的最小的node所在的链表index
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

```



## 结果

Runtime: 266 ms, faster than 5.03% of Java online submissions for Merge k Sorted Lists.

Memory Usage: 40.8 MB, less than 33.95% of Java online submissions for Merge k Sorted Lists.