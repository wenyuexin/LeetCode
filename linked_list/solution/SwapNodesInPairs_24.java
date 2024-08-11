package linked_list.solution;

import linked_list.utils.ListNode;

/**
 * @author Apollo4634 
 * @create 2019/02/27
 * @problem 24
 * @see ListNode
 * @see SwapNodesInPairs_24
 */

public class SwapNodesInPairs_24 {
	
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
	
	public static void main(String[] args) {
		//int[] arr = new int[] { 1, 2, 3, 4 };
		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		ListNode head = ListNode.toNodeList(arr);
		System.out.println("Input:   "+ListNode.listToString(head));
		
		long t1 = System.nanoTime();
		SwapNodesInPairs_24 obj = new SwapNodesInPairs_24();
		ListNode list = obj.swapPairs(head);
		long t2 = System.nanoTime();
		
		System.out.println("Output:  "+ListNode.listToString(list));
		System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
	}
}
