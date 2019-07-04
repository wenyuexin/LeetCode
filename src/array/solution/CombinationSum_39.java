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
        Integer[] set;
        int idx;
        int sum;
        List<List<Integer>> combinations;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            int capacity = (int) (1.0 * target / candidates[0]) + 1;
            set = new Integer[capacity];
            sum = 0;
            idx = 0;
            combinations = new LinkedList<>();
            for (int i: candidates) {
                search(0, candidates, i, target);
            }
            return combinations;
        }

        private void search(int idx, int[] candidates, int from, int target) {
            int s = sum + candidates[from];
            if (s == target) {
                set[idx] = candidates[from];
                idx += 1;
                combinations.add(Arrays.asList(set));
            } else if (s < target) {
                set[idx] = candidates[from];
                idx += 1;
                search(candidates, from, target);
            } else {
                from += 1;
                search(candidates, from, target);
            }
        }
    }
}
