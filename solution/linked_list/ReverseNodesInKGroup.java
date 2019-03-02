package linked_list;

/** 
 * 本题要求以k个节点为一组进行反转，如果最后一组的节点数不足k则不反转
 * 因此在反转前先统计整个链表中的总节点数listLen，并得到需要反转的组数nGroup
 * 
 * 对于需要反转的部分，这里设每组第一个节点的前一个节点为prev，
 * 每组最后一个节点为tail，因此要做的就是将tail.next(设为temp)取出，
 * 再将temp插入到prev之后
 * 
 * @author Apollo4634 
 * @create 2019/03/02
 * @problem 25
 * @see ListNode
 * @see ReverseNodesInKGroup_25
 */

public class ReverseNodesInKGroup {

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


	public static void main(String[] args) {
		//int[] arr = new int[] { 1, 2, 3, 4, 5 };
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		ListNode head = ListNode.toNodeList(arr);
		System.out.println("Input:   "+ListNode.listToString(head));

		long t1 = System.nanoTime();
		ReverseNodesInKGroup obj = new ReverseNodesInKGroup();
		ListNode list = obj.reverseKGroup(head, 3);
		long t2 = System.nanoTime();

		System.out.println("Output:  "+ListNode.listToString(list));
		System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
	}
}
