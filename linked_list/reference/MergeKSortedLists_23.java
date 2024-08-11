package linked_list.reference;

import linked_list.utils.ListNode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/solution/
 * 
 * @author - 
 * @create 2019/02/26
 * @problem 23
 * @see ListNode
 * @see linked_list.solution.MergeKSortedLists_23
 */

public class MergeKSortedLists_23 {

	/* Approach 1: Brute Force
	 * Traverse all the linked lists and collect the values of the nodes into an array.
	 * Sort and iterate over this array to get the proper value of nodes.
	 * Create a new sorted linked list and extend it with the new nodes.
	 */


	/* Approach 2: Compare one by one
	 * Compare every k nodes (head of every linked list) and get the node with the smallest value.
	 * Extend the final sorted linked list with the selected nodes.
	 */


	/* Approach 3: Optimize Approach 2 by Priority Queue
	 * Almost the same as the one above but optimize the comparison process by priority queue. 
	 */
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
		for (int i = idx; i>>1 > 0 && heap[i].val < heap[i>>1].val; i = i>>1) {
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

	public ListNode mergeKLists3(ListNode[] lists) {
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

	/* Approach 4: Merge lists one by one
	 * Convert merge k lists problem to merge 2 lists (k-1) times. 
	 */


	/* Approach 5: Merge with Divide And Conquer
	 * This approach walks alongside the one above but is improved a lot. 
	 * We don't need to traverse most nodes many times repeatedly
	 * - Pair up k lists and merge each pair.
	 * - After the first pairing, k lists are merged into k/2 lists with average 2N/k length, 
	 *   then k/4, k/8 and so on.
	 * - Repeat this procedure until we get the final sorted linked list.
	 * Thus, we'll traverse almost NN nodes per pairing and merging, 
	 * and repeat this procedure about log2(k) times.
	 */
	public ListNode mergeKLists4(ListNode[] lists) {
		return mergeKLists(lists, 0, lists.length - 1);
	}

	private ListNode mergeKLists(ListNode[] lists, int start, int end) {
		if (lists.length == 0) return null;
		if (start == end) {
			return lists[start];
		}

		int mid = (start + end) / 2;
		ListNode n1 = mergeKLists(lists, start, mid);
		ListNode n2 = mergeKLists(lists, mid + 1, end);

		ListNode head = null;
		ListNode node = null;
		while (n1 != null || n2 != null) {
			if (n1 == null) {
				if (head == null) {
					head = n2;
				} else {
					node.next = n2;
				}
				break;
			} else if (n2 == null) {
				if (head == null) {
					head = n1;
				} else {
					node.next = n1;
				}
				break;
			}

			ListNode best = n1;
			if (n1.val <= n2.val) {
				n1 = n1.next;
			} else {
				best = n2;
				n2 = n2.next;
			}
			if (head == null) {
				head = best;
				node = best;
			}
			node.next = best;
			node = node.next;
		}
		return head;
	}
}
