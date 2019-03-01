package linked_list;

/** 
 * @author Apollo4634 
 * @create 2019/02/27
 */

public class SwapNodesInPairs {
	
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
			node1 = prev.next;
			node2 = prev.next.next;
			
		}
		
		return null;
	}
}
