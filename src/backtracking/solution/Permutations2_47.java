package backtracking.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Apollo4634
 * @create 2019/07/13
 * @problem 46
 * @tag Backtracking
 */

public class Permutations2_47 {
    static class Solution {
        List<List<Integer>> lists;
        boolean[] marked;
        Integer[] tracking;

        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums == null) return new LinkedList<>();

            return lists;
        }

        private void search(int[] nums, int idx) {
            if (idx == nums.length) {
                //todo 将得到的一组结果添加到最终的列表里
            }

            for(int num : nums) {

            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[] { 1,2,3,4 };
        System.out.println("Input:  "+ Arrays.toString(nums));

        long t1 = System.nanoTime();
        List<List<Integer>> list = new Solution().permuteUnique(nums);
        long t2 = System.nanoTime();

        System.out.println("Output: "+ list.toString());
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
