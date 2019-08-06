package array.reference;

/**
 * @author Apollo4634
 * @create 2019/08/06
 * @problem 53
 * @tag Array
 * @tag Divide and Conquer
 * @tag Dynamic Programing
 * @see array.solution.MaximumSubarray_53
 */

public class MaximumSubarray_53 {
    static class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int ans = Integer.MIN_VALUE;
            int cur = 0;
            for (int num : nums) {
                cur = cur > 0 ? cur + num : num;
                ans = Math.max(ans, cur);
            }
            return ans;
        }
    }
}
