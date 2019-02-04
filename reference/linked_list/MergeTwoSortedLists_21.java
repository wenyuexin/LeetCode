package linked_list;

/**
 * @author -
 * @create 2019/01/30
 * @problem 21
 * @see ListNode
 */

public class MergeTwoSortedLists_21 {
	
	//My Solution
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode l3 = new ListNode(0);
		ListNode node3 = l3;

		ListNode node1 = l1;
		ListNode node2 = l2;
		while (node1!=null && node2!=null) {
			if (node1.val<=node2.val) {
				node3.next = node1;
				node1 = node1.next;
				node3 = node3.next;
			} else {
				node3.next = node2;
				node2 = node2.next;
				node3 = node3.next;
			}
		}
		if(node1!=null) node3.next = node1;
		if(node2!=null) node3.next = node2;
		return l3.next;
	}
}
