package array.solution;

import java.util.*;

/**
 * @author Apollo4634
 * @create 2019/07/05
 * @problem 40
 * @tag Array
 * @tag Backtracking
 * @see array.solution.CombinationSum2_40
 */

public class CombinationSum2_40 {
    static class Solution {
        Set<List<Integer>> combinations;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            combinations = new HashSet<>();
            if (candidates == null || candidates.length == 0) {
                return new ArrayList<>();
            }

            Arrays.sort(candidates);
            List<Integer> set = new LinkedList<>();
            search(set, candidates, 0, target);
            return new ArrayList<>(combinations);
        }

        private void search(List<Integer> set, int[] nums, int from, int target) {
            for (int i = from; i < nums.length; i++) {
                if (nums[i] == target) {
                    set.add(nums[i]);
                    combinations.add(new LinkedList<>(set));
                    //System.out.println("= "+set.toString());
                    set.remove(set.size()-1);
                    break;
                } else if (nums[i] < target) {
                    set.add(nums[i]);
                    //System.out.println("< "+set.toString());
                    search(set, nums, i+1, target-nums[i]);
                    set.remove(set.size()-1);
                }
            }
        }
    }


    public static void main(String[] args) {
        //int[] nums = new int[] { 2,3,6,7 };
        //int target = 7;

        int[] nums = new int[] { 10,1,2,7,6,1,5 };
        int target = 8;

        System.out.println("Input:  "+ Arrays.toString(nums));
        System.out.println("Input:  "+target);

        long t1 = System.nanoTime();
        List<List<Integer>> list = new Solution().combinationSum2(nums, target);
        long t2 = System.nanoTime();

        System.out.println("Output: "+ list.toString());
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
