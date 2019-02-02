package linked_list;

/**
 * @author -
 * @create 2019/01/30
 * @problem 19
 * @see ListNode
 */

public class RemoveNthNodeFromEndOfList_19 {
	
	//My Solution
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null) return head;
		int idx = 0;
		ListNode tmpNode = head;
		ListNode node = head;
		while(node.next!=null) {
			if(idx>n) tmpNode = tmpNode.next;//更新tmpNode
			node = node.next;//更新节点
			idx++;//更新节点的位置
		}
		if(idx>n) tmpNode = tmpNode.next;//更新tmpNode
		if(idx==n-1) return head.next;//链表中刚好存在n个节点
		tmpNode.next = tmpNode.next.next;
		return head;
	}
}
