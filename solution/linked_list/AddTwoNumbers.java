package linked_list;


/**
 * @author Apollo4634
 * @create 2018/11/23
 * @problem 2
 * @see ListNode
 */

public class AddTwoNumbers {
	
	//Solution
	//某一位上的加法计算
	static int[] calc(int val1, int val2, int c) {
		int[] out = new int[] {0,0}; //m,r
		int m = val1+val2+c;
		out[0] = m%10;
		if(m>=10) { out[1] = 1; }
		return out;
	}
	
	//链表相加
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//int[] pair = AddTwoNumbers.calc(l1.val, l2.val, 0);
		int[] pair = new int[] {0,0};
		ListNode l3 = new ListNode(0);
		ListNode l3_tmp = l3;

		int val1 = 0;
		int val2 = 0;
		while (l1 != null || l2 != null) {
			val1 = (l1 != null) ? l1.val : 0;
			val2 = (l2 != null) ? l2.val : 0;
			pair = AddTwoNumbers.calc(val1, val2, pair[1]);
			l3_tmp.next = new ListNode(pair[0]);
			l3_tmp = l3_tmp.next;
			
			if(l1!=null) l1 = (l1.next!=null) ? l1.next : null;				
			if(l2!=null) l2 = (l2.next!=null) ? l2.next : null;
		}
		
		if(1==pair[1]) {
			l3_tmp.next = new ListNode(1);
		}
		return l3.next;
	}
	
	
	public static void main(String[] args) {
		int[] arr1 = new int[] {5,8};
		int[] arr2 = new int[] {5,4};
		
		ListNode l1 = ListNode.toNodeList(arr1);
		ListNode l2 = ListNode.toNodeList(arr2); 
		
		System.out.println("input list1: ["+ListNode.listToString(l1)+"]");
		System.out.println("input list2: ["+ListNode.listToString(l2)+"]");
		System.out.println("=====");
		
		long t1 = System.nanoTime();
		AddTwoNumbers obj = new AddTwoNumbers();
		ListNode l3 = obj.addTwoNumbers(l1, l2);
		long t2 = System.nanoTime();
		
		System.out.println("input list1: ["+ListNode.listToString(l1)+"]");
		System.out.println("input list2: ["+ListNode.listToString(l2)+"]");
		System.out.println("input list2: ["+ListNode.listToString(l3)+"]");
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
