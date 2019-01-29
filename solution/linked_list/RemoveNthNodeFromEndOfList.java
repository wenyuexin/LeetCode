package linked_list;

/**
 * 较为简单的方法是两次遍历链表，第一次找到反向的第n个节点，第二次删除该节点。
 * 但可以设置辅助变量，从而仅通过一次遍历实现目标，具体如下：
 * 
 * 依次遍历链表中的各个节点，并设置临时变量tmpNode保存反向的第n+1个节点，
 * 当链表遍历结束后，通过tmpNode删除反向第n个节点即可完成解题。
 * 如果链表中刚好存在n个节点，那么需要删除的就是链表的第一个节点，
 * 即链表并不存在反向的第n+1个节点，此时直接返回head.next即可
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
