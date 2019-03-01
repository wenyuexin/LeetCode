package linked_list;

/** 
 * @author - 
 * @create 2019/03/01
 * @problem 24
 * @see ListNode
 * @see SwapNodesInPairs
 */

public class SwapNodesInPairs_24 {

	//My Approch
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode first = new ListNode(0);
		first.next = head.next;
		ListNode prev = first;
		ListNode node1 = head;
		ListNode node2 = head.next;
		
		while (node2 != null) {
			node1.next = node2.next;
			prev.next = node2;
			node2.next = node1;
			prev = node1;
			if (prev.next == null || prev.next.next == null) break;
			node1 = prev.next;
			node2 = prev.next.next;
		}
		return first.next;
	}
}
