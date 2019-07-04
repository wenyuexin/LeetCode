package array.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Apollo4634
 * @create 2019/06/29
 * @problem 39
 * @tag Array
 * @tag Backtracking
 */

public class CombinationSum_39 {
    static class Solution {
        int[] nums;
        Integer[] set;
        //int lastIdx;
        List<List<Integer>> combinations;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            nums = candidates;
            Arrays.sort(nums);
            int capacity = (int) (1.0 * target / candidates[0]) + 1;
            set = new Integer[capacity];
            combinations = new LinkedList<>();
            for (int i = 0; i < candidates.length; i++) {
                search(0, i, target);
            }
            return combinations;
        }

        private void search(int last, int from, int target) {
            for (int i = from; i < nums.length; i++) {
                if (nums[i] == target) {
                    set[last] = nums[i];
                    combinations.add(Arrays.asList(Arrays.copyOfRange(set, 0, last+1)));
                    System.out.println("= "+ Arrays.toString(Arrays.copyOfRange(set, 0, last+1)) + " " + last);
                } else if (nums[i] < target) {
                    set[last] = nums[i];
                    search(last+1, from, target-nums[i]);
                    System.out.println("< "+ Arrays.toString(Arrays.copyOfRange(set, 0, last+1)) + " " + last);
                } else {
                    set[last] = nums[i];
                    System.out.println("> "+ Arrays.toString(Arrays.copyOfRange(set, 0, last+1)) + " " + last);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[] { 2,3,6,7 };
        int target = 7;

        System.out.println("Input:  "+ Arrays.toString(nums));
        System.out.println("Input:  "+target);

        long t1 = System.nanoTime();
        List<List<Integer>> list = new Solution().combinationSum(nums, target);
        long t2 = System.nanoTime();

        System.out.println("Output: "+ list.toString());
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
