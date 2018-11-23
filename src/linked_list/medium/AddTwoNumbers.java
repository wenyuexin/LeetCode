package linked_list.medium;

/**
 * @author Apollo4634
 * @creation 2018/11/23
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
	
	static ListNode set(int[] arr) {
		ListNode listNode = new ListNode(arr[0]);
		
		ListNode nextNode = new ListNode(arr[1]);
		listNode.next = nextNode;
		
		for(int i=1; i<arr.length; i++) {
			nextNode = new ListNode(arr[i]);
			nextNode = nextNode.next;
		}
		return listNode;
	}
	
	static void print(ListNode listNode) {
		ListNode nextNode = listNode;
		System.out.print(nextNode.val + " ");
		while(nextNode.next != null) {
			System.out.print(nextNode.val + " ");
			nextNode = nextNode.next;
		}
		System.out.println(nextNode.val);
	}
	
	static int[] calc(ListNode l1, ListNode l2, int c) {
		int[] out = new int[] {0,0}; //m,r
		int m = l1.val+l2.val+c;
		if(m>10) { out[1] = 1; }
		out[0] = m%10;
		return out;
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int[] pair = AddTwoNumbers.calc(l1, l2, 0);
		ListNode l3 = new ListNode(pair[0]);
		ListNode next3 = new ListNode(0);
		l3.next = next3;
		
		ListNode next1 = l1.next;
		ListNode next2 = l2.next;
		while (next1.next != null || next2.next != null) {
			pair = AddTwoNumbers.calc(next1, next2, pair[1]);
			next1 = next1.next;
			next2 = next2.next;
			next3.val = pair[0];
			next3.next = new ListNode(pair[1]);
		}
		
		pair = AddTwoNumbers.calc(next1, next2, pair[1]);
		next3.val = pair[0];
		
		if(1==pair[1]) {
			next3.next = new ListNode(pair[1]);
		}
		return l3;
	}
	
	public static void main(String[] args) {
		int[] arr1 = new int[] {2,4,3};
		int[] arr2 = new int[] {5,6,4};
		
		ListNode l1 = AddTwoNumbers.set(arr1);
		ListNode l2 = AddTwoNumbers.set(arr2); 
		AddTwoNumbers.print(l1);	
		AddTwoNumbers.print(l2);	
		
	}
}

