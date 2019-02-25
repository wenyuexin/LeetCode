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
	private int K;

	private void sink() {
		
	}

	private void insert(ListNode node) {
		
	}
	
	private ListNode deleteMin() {

		return null;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		K = lists.length;
		heap = new ListNode[K+2];
		for (int i = 0; i < K; i++) {
			heap[i+1] = lists[i];
		}
		
		
		return null;
	}

}
