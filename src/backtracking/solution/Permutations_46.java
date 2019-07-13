package backtracking.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Apollo4634
 * @create 2019/07/13
 * @problem 46
 * @tag Backtracking
 * @see backtracking.reference.Permutations_46
 */

public class Permutations_46 {
    static class Solution {
        List<List<Integer>> lists;
        boolean[] marked;
        Integer[] tracking;

        public List<List<Integer>> permute(int[] nums) {
            if (nums == null) return new LinkedList<>();
            lists = new LinkedList<>();
            marked = new boolean[nums.length];
            tracking = new Integer[nums.length];
            search(nums, 0);
            return lists;
        }

        private void search(int[] nums, int idx) {
            if (idx == nums.length) {
                lists.add(new ArrayList<>(Arrays.asList(tracking)));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (marked[i]) continue;
                marked[i] = true;
                tracking[idx] = nums[i];
                search(nums, idx+1);
                marked[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[] { 1,2,3,4 };
        System.out.println("Input:  "+ Arrays.toString(nums));

        long t1 = System.nanoTime();
        List<List<Integer>> list = new Solution().permute(nums);
        long t2 = System.nanoTime();

        System.out.println("Output: "+ list.toString());
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
