package linked_list.solution;

import linked_list.utils.ListNode;

/**
 * @author Apollo4634
 * @create 2019/12/24
 * @problem 38
 * @tag Linked List
 * @see ListNode
 */

public class RemoveDuplicatesFromSortedList_83 {
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return null;
            ListNode node = head;
            while (node.next != null) {
                if (node.val == node.next.val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
            return head;
        }
    }


    public static void main(String[] args) {
        //int[] arr = new int[] { 1, 2, 3, 4, 5 };
        //int[] arr = new int[] { 1, 1, 2, 2, 5, 6, 6 };
        //int[] arr = new int[] { 1 };
        int[] arr = new int[] { 1, 1, 1 };
        ListNode head = ListNode.toNodeList(arr);
        System.out.println("Input:   " + ListNode.listToString(head));

        long t1 = System.nanoTime();
        ListNode list = new Solution().deleteDuplicates(head);
        long t2 = System.nanoTime();

        System.out.println("Output:  " + ListNode.listToString(list));
        System.out.println("Runtime: " + (t2-t1)/1.0E6+" ms");
    }
}
