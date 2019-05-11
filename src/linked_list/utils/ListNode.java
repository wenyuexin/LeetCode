package linked_list.utils;

import linked_list.solution.AddTwoNumbers;
import linked_list.solution.RemoveNthNodeFromEndOfList;

/**
 * Definition for singly-linked list
 * 
 * @author Apollo4634
 * @create 2019/01/28
 * @see AddTwoNumbers
 * @see RemoveNthNodeFromEndOfList
 */

public class ListNode {
	/*problem定义的内容*/
	public int val;
	public ListNode next;
	public ListNode(int x) { val = x; }

	/*个人自定义的内容*/

	//将单个节点转为字符串
	@Override
	public String toString() {
		return Integer.toString(val);
	}
	
	//链表初始化
	public static ListNode toNodeList(int[] arr) {
		if(arr.length==0) return null;
		ListNode listNode = new ListNode(arr[0]);//保留表头
		ListNode listNode_tmp = listNode;
		ListNode nextNode = null;
		for(int i = 1; i < arr.length; i++) {
			nextNode = new ListNode(arr[i]);
			listNode_tmp.next = nextNode;
			listNode_tmp = nextNode;
		}
		return listNode;
	}

	//链表数组初始化
	public static ListNode[] toNodeLists(int[][] arr) {
		if(arr.length==0) return null;
		ListNode[] lists = new ListNode[arr.length];
		for(int i = 0; i < arr.length; i++) {
			lists[i] = toNodeList(arr[i]);
		}
		return lists;
	}

	//单个链表转为字符串
	public static String listToString(ListNode head) {
		if (head==null) return "[]";
		StringBuilder sb = new StringBuilder("[");
		ListNode node = head;
		while(node.next != null) {
			sb.append(node+", ");
			node = node.next;
		}
		sb.append(node);
		sb.append("]");
		return sb.toString();
	}

	//链表数组转为字符串
	public static String listsToString(ListNode[] lists) {
		if (lists==null) return "[]";
		StringBuilder sb = new StringBuilder("[ ");
		for (int i = 0; i < lists.length; i++) {
			sb.append(listToString(lists[i]));
			if (i < lists.length-1) sb.append(", ");
		}
		sb.append(" ]");
		return sb.toString();
	}


	public static void main(String[] args) {
		System.out.println("===== test =====");
		//这种方式赋值后，其实链表中有两个元素
		//只不过第二个元素的next是null
		ListNode node = new ListNode(0);
		ListNode node2 = new ListNode(0);
		node.next = node2;
		node2 = null; //注意，这里将node2设为null，并不代表node的next变成了null
		//实际上只是node2引用的对象由new ListNode(0)生成的对象变成了null
		//node的next本质上还是指向之前的new ListNode(0)

		ListNode node3 = null;
		ListNode node3b = new ListNode(3); 
		node3b.next = node3;

		ListNode node4 = new ListNode(0);
		node4 = null;
		ListNode node4b = new ListNode(2);
		node4b.next = node4;
	}
}
