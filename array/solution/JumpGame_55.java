package array.solution;

import java.util.Arrays;
import java.util.List;

/**
 * @author Apollo4634
 * @create 2019/08/08
 * @problem 55
 * @tag Array
 * @tag Greedy
 */

public class JumpGame_55 {
    static class Solution {
        public boolean canJump(int[] nums) {
            final int max = nums.length - 1;
            int idx = 0;
            while (idx < max) {
                if (nums[idx] != 0)
                    idx += nums[idx];
                else {
                    int i = idx - 1;
                    for (; i > 0; i--) {
                        if (i + nums[i] > idx) {
                            idx = i + nums[i]; break;
                        }
                    }
                    if (i <= 0) return false;
                }
            }
            return true;
        }
    }


    public static void main(String[] args) {
        //int[] nums = new int[] { 0 };
        //int[] nums = new int[] { 0, 1 };
        //int[] nums = new int[] { 2,3,1,1,4 };
        //int[] nums = new int[] { 3,2,1,0,4 };
        int[] nums = new int[] { 2,3,1,0,4,1 };
        System.out.println("Input:  "+ Arrays.toString(nums));

        long start = System.nanoTime();
        boolean reachable = new Solution().canJump(nums);
        long end = System.nanoTime();

        System.out.println("Output: "+ reachable);
        System.out.println("Runtime: "+(end-start)/1.0E6+" ms");
    }
}
