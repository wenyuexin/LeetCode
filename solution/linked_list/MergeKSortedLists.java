package linked_list;

/** 
 * 使用最小堆即可解出此题
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
	private int K;
	
	private void swap(int i, int j) {
		ListNode temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	private void sink(int idx) {
		for (int i = idx; 2*i+1 <= K; i++) {
			int j = (heap[2*i].val < heap[2*i].val)? 2*i : 2*i+1;
			if (heap[i].val >= heap[j].val) break;
			swap(i ,j);
		}
	}

	private void insert(ListNode node) {
		//heap[K+1] = heap[1];
		//sink(1);
	}
	
	private ListNode deleteMin() {

		
		return null;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		K = lists.length;
		heap = new ListNode[K+2];
		for (int i = 0; i < K; i++) {
			heap[i+1] = lists[i];
			if (lists[i].next != null) 
				lists[i] = lists[i].next;
		}
		
		
		return null;
	}

}
