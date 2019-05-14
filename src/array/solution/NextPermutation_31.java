package array.solution;

/**
 * 解题思路类似于插入排序
 *
 * @author Apollo4634
 * @create 2019/05/12
 * @problem 31
 * @tag Array
 */

public class NextPermutation_31 {
    public static class Solution {
        public void nextPermutation(int[] nums) {
            int idx = nums.length-1;
            int max = nums[idx];

            for (int i = nums.length-2; i >= 0; i++) {
                if (nums[i] < max) {
                    nums[idx] = nums[i];
                    nums[i] = max;
                    return;
                } else {

                }
            }
        }
    }
}
