package linked_list;

/** 
 * @author Apollo4634 
 * @create 2019/03/02
 * @problem 25
 * @see ListNode
 * @see ReverseNodesInKGroup
 */

public class ReverseNodesInKGroup_25 {

	//My approch
	private int getGroupNum(ListNode head, int k) {
		int listLen = 1;
		ListNode node = head;
		while (node.next != null) {
			listLen += 1;
			node = node.next;
		}
		return listLen / k;
	}
	
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k < 2 || head == null || head.next == null) return head;
		int nGroup = getGroupNum(head, k);
		
		ListNode first = new ListNode(0);
		first.next = head;
		
		ListNode prev = first;
		ListNode temp = null;
		ListNode tail = head;
		int cnt = 1;
		int iGroup = 0;
		while (iGroup < nGroup && tail != null && tail.next != null) {
			temp = tail.next;
			tail.next = tail.next.next;
			temp.next = prev.next;
			prev.next = temp;
			cnt += 1;

			if (cnt == k) {
				prev = tail;
				tail = prev.next;
				cnt = 1;
				iGroup += 1;
			}
		}
		return first.next;
	}
}
