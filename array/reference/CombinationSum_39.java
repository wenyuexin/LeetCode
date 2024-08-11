package array.reference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Apollo4634
 * @create 2019/07/05
 * @problem 39
 * @tag Array
 * @tag Backtracking
 * @see array.solution.CombinationSum_39
 * @see array.solution.CombinationSum2_40
 */

public class CombinationSum_39 {
    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> results = new ArrayList<>();
            if (candidates == null || candidates.length == 0) return results;

            List<Integer> res = new ArrayList<>();
            dfs(results, res, target, candidates, 0);
            return results;
        }

        private void dfs(List<List<Integer>> results, List<Integer> res, int target, int[] candidates, int index) {
            if (target == 0) {
                results.add(new ArrayList<>(res));
                return;
            }

            for (int i = index; i < candidates.length; i++) {
                if (target - candidates[i] < 0) continue;

                res.add(candidates[i]);
                dfs(results, res, target - candidates[i], candidates, i);
                res.remove(res.size() - 1);
            }
        }
    }
}