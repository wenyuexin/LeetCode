package heap.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Apollo4634
 * @create 2019/09/16
 */

public class SlidingWindowMaximum_239 {
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0) return new int[] {};
            int[] maxNums = new int[nums.length - k + 1];
            int idx = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.reverseOrder());
            for (int i = 0; i < k; i++) {
                pq.add(nums[i]);
            }
            maxNums[idx++] = pq.peek();

            int firstNumIdx = 0;
            for (int i = k; i < nums.length; i++) {
                pq.remove(nums[firstNumIdx]);
                pq.add(nums[i]);
                maxNums[idx++] = pq.peek();
                firstNumIdx += 1;
            }
            return maxNums;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[] { 2,3,4,2,6,2,5,1 };
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(nums, 3)));
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(nums, 4)));
    }
}
