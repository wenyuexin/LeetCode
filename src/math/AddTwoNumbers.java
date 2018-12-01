package math;


/**
 * @author Apollo4634
 * @creation 2018/11/23
 * 
 * Runtime: 22 ms, 
 * faster than 94.06% of Java online submissions for this.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class ListNode { //定义了一个单项链表
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
	//设置链表 - 方法1
	static ListNode set(int[] arr) {
		ListNode listNode = new ListNode(arr[0]);//由于java对象引用的特点，有必要保留表头
		ListNode listNode_tmp = listNode;
		ListNode nextNode = null;
		
		for(int i=1; i<arr.length; i++) {
			nextNode = new ListNode(arr[i]);
			listNode_tmp.next = nextNode;
			listNode_tmp = nextNode;
		}
		
		return listNode;
	}
	
	//设置链表 - 方法2 （此法繁琐）
	static ListNode set2(int[] arr) {
		ListNode listNode = new ListNode(arr[0]);
		ListNode nextNode = new ListNode(0);
		
		if(arr.length == 1) {
			listNode.next = null;
		} else {
			listNode.next = nextNode;
			int arrLen = arr.length;
			for(int i=1; i<arrLen; i++) {
				nextNode.val = arr[i];
				
				if(i != arrLen-1) {
					nextNode.next = new ListNode(0);
				} else {
					nextNode.next = null;
				}
				nextNode = nextNode.next;
			}
		}
		return listNode;
	}
	
	//打印链表
	static void print(ListNode listNode) {
		ListNode node = listNode;
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}

	
	/******************* Answer *******************/
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
		System.out.println("===== test =====");
		//这种方式赋值后，其实链表中有两个元素
		//只不过第二个元素的next是null
		ListNode node = new ListNode(0);
		ListNode node2 = new ListNode(0);
		node.next = node2;
		node2 = null; //注意，这里将node2设为null，并不代表node的next变成了null
		              //实际上只是node2引用的对象由之前new ListNode(0)生成的对象变成了null
		              //node的next本质上还是指向之前的new ListNode(0)
		
		ListNode node3 = null;
		ListNode node3b = new ListNode(3); 
		node3b.next = node3;
		
		ListNode node4 = new ListNode(0);
		node4 = null;
		ListNode node4b = new ListNode(2);
		node4b.next = node4;
		
		System.out.println("===== Solution =====");
		int[] arr1 = new int[] {5,8};
		int[] arr2 = new int[] {5,4};
		
		ListNode l1 = AddTwoNumbers.set(arr1);
		ListNode l2 = AddTwoNumbers.set(arr2); 
		System.out.print("ListNode1: ");
		AddTwoNumbers.print(l1);	
		System.out.print("ListNode2: ");
		AddTwoNumbers.print(l2);
		System.out.println("=====");
		
		ListNode l3 = new AddTwoNumbers().addTwoNumbers(l1, l2);
		System.out.print("ListNode1: ");
		AddTwoNumbers.print(l1);	
		System.out.print("ListNode2: ");
		AddTwoNumbers.print(l2);
		System.out.print("ListNode3: ");
		AddTwoNumbers.print(l3);
	}
}
