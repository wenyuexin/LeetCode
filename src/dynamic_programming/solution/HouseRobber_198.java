package dynamic_programming.solution;

import java.util.Arrays;

/**
 * @author Apollo4634
 * @create 2019/10/07
 * @problem 70
 * @tag Dynamic Programming
 */

public class HouseRobber_198 {

    //unrecommended
    static class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            return robOrNot(nums, 0, -2, 0);
        }

        private int robOrNot(int[] nums, int money, int prev, int idx) {
            if (idx >= nums.length) return money;
            if (idx - prev > 3) return 0;
            int m1 = robOrNot(nums, money, prev, idx+1);
            int m2 = robOrNot(nums, money+nums[idx], idx, idx+2);
            return Math.max(m1, m2);
        }
    }

    //unrecommended
    static class Solution2 {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];

            return 0;
        }
    }


    public static void main(String[] args) {
        //int[] nums = new int[] { 2,7,9,3,1 };
        //int[] nums = new int[] { 1,2,3,1 };
        int[] nums = new int[] {
                226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,
                68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,
                18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,
                212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,
                120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124 };
        System.out.println("Output: "+ Arrays.toString(nums));

        long start = System.nanoTime();
        int money = new Solution().rob(nums);
        long end = System.nanoTime();

        System.out.println("Output: "+ money);
        System.out.println("Runtime: "+(end-start)/1.0E6+" ms");
    }
}
