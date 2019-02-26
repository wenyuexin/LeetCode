package linked_list;


/** 
 * 此为基于最小堆的解法
 * 
 * @author Apollo4634 
 * @create 2019/02/25
 * @problem 23
 * @see ListNode
 * @see MergeKSortedLists_23
 */

public class MergeKSortedLists {

	private ListNode[] heap;
	private int N;

	private void swap(int i, int j) {
		ListNode temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	private void sink(int idx) {
		for (int i = idx, j = idx<<1; j <= N; i = j, j = i<<1) {
			if(j+1 <= N && heap[j].val > heap[j+1].val) j += 1;
			if(heap[i].val <= heap[j].val) break;
			swap(i ,j);
		}
	}

	private void swim(int idx) {
		for (int i = idx; i>>1 > 0 && heap[i].val < heap[i>>1].val; i /= 2) {
			swap(i, i>>1);
		}
	}
	
	private void insert(ListNode node) {
		N += 1;
		heap[N] = node;
		swim(N);
	}

	private ListNode deleteMin() {
		if(N==0) return null;
		ListNode min = heap[1];
		swap(1, N);
		N -= 1;
		sink(1);
		return min;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		N = 0;
		heap = new ListNode[lists.length+1];
		for(int i = 0; i < lists.length; i++) {
			if (lists[i] != null) insert(lists[i]);
		}
		
		ListNode head = new ListNode(0);
		ListNode node = head;
		while(true) {
			node.next = deleteMin();
			if(node.next == null) break;
			node = node.next;
			if(node.next != null) insert(node.next);
		}
		return head.next;
	}


	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];
		//int[][] arr = new int[][] {{1,4,5}, {1,3,4}, {2,6}};
		//int[][] arr = new int[][] {{}, {}};
		int[][] arr = new int[][] {{-8,-7,-7,-5,1,1,3,4} ,{-2}, {-10,-10,-7,0,1,3}, {2}};
		lists = ListNode.toNodeLists(arr);
		System.out.println("Input:   "+ListNode.listsToString(lists));
		
		long t1 = System.nanoTime();
		MergeKSortedLists obj = new MergeKSortedLists();
		ListNode sortedList = obj.mergeKLists(lists);
		long t2 = System.nanoTime();

		System.out.println("Output:  "+ListNode.listToString(sortedList));
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
