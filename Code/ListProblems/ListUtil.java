package ListProblems;

/**
 * @author:linpeng
 * @date:20201209
 * @version:v1.0
 */
public class ListUtil {

    public static void printList(ListNode list) {
        while(list != null) {
            System.out.print(list.val + "  ");
            list = list.next;
        }
        System.out.println();
    }
}
