package array.solution;

import java.util.Arrays;

/**
 * @author Apollo4634
 * @create 2019/08/02
 * @problem 53
 * @tag Array
 * @tag Divide and Conquer
 * @tag Dynamic Programing
 */

public class MaximumSubarray_53 {
    static class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 1) return nums[0];
            int largestSum = 0;

            return largestSum;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[] { 0,1,2,3 };
        System.out.println("Input:  "+ Arrays.toString(nums));

        long start = System.nanoTime();
        int largestSum = new Solution().maxSubArray(nums);
        long end = System.nanoTime();

        System.out.println("Output: "+ largestSum);
        System.out.println("Runtime: "+(end-start)/1.0E6+" ms");
    }
}
