package linked_list;

/**
 * 
 * 
 * 
 * @author Apollo4634
 * @date 2019/01/28
 * @problem 20
 * @see ListNode
 */

public class RemoveNthNodeFromEndOfList {

	//Solution
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null) return head;
		int idx = 0;
		ListNode node = head;
		ListNode tmpNode = head;
		
		while(node.next!=null) {
			if(idx>n) tmpNode = tmpNode.next;
			node = node.next; idx++;
		}
		if(idx>n) tmpNode = tmpNode.next;
		
		if(idx>=n) {
			tmpNode.next = tmpNode.next.next;
		} else {
			head = head.next;
		}
		return head;
	}


	public static void main(String[] args) {
		//int[] nums = new int[] { 7,6,5,4,3,2,1 };
		//int n = 7;
		
		int[] nums = new int[] { 1 };
		int n = 1;

		ListNode head = ListNode.setNodeList(nums);
		System.out.println("input list:  "+ListNode.listToString(head));
		System.out.println("input n:     "+n);
		
		long t1 = System.nanoTime();
		RemoveNthNodeFromEndOfList obj = 
				new RemoveNthNodeFromEndOfList();
		ListNode out = obj.removeNthFromEnd(head, n);
		long t2 = System.nanoTime();
		
		System.out.println("output list: "+ListNode.listToString(out));
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
