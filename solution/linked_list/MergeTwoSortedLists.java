package linked_list;

/**
 * 同时遍历两个链表，每次从两个链表中各取出一个节点，
 * 然后将数值更小的节点添加到新链表的末尾，若相等则都添加
 * 
 * 某一时刻，如果一个链表遍历结束而另一个链表中还存在节点，
 * 则直接将后者剩余的节点添加到新链表中
 * 
 * @author Apollo4634
 * @date 2019/01/30
 * @problem 21
 * @see ListNode
 */

public class MergeTwoSortedLists {

	//Solution
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode l3 = new ListNode(0);
		ListNode node3 = l3;
		
		ListNode node1 = l1;
		ListNode node2 = l2;
		while(node1!=null && node2!=null) {
			if(node1.val<node2.val) {
				node3.next = node1;
				node1 = node1.next;
				node3 = node3.next;
			} else if(node1.val>node2.val) {
				node3.next = node2;
				node2 = node2.next;
				node3 = node3.next;
			} else {
				node3.next = node1;
				node1 = node1.next;
				node3 = node3.next;
				node3.next = node2;
				node2 = node2.next;
				node3 = node3.next;
			}
		}
		
		if(node1!=null) node3.next = node1;
		if(node2!=null) node3.next = node2;
		return l3.next;
	}	

	
	public static void main(String[] args) {
		//int[] nums1 = new int[] { 1,2,4,5 };
		//int[] nums2 = new int[] { 1,3,4 };
		
		int[] nums1 = new int[] {  };
		int[] nums2 = new int[] { 0 };
		
		ListNode l1 = ListNode.setNodeList(nums1); 
		ListNode l2 = ListNode.setNodeList(nums2);
		
		System.out.println("input l1:  "+ListNode.listToString(l1));
		System.out.println("input l2:  "+ListNode.listToString(l2));
		
		long t1 = System.nanoTime();
		MergeTwoSortedLists obj = new MergeTwoSortedLists();
		ListNode l3 = obj.mergeTwoLists(l1, l2);
		long t2 = System.nanoTime();
		
		System.out.println("output l3: "+ListNode.listToString(l3));
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
