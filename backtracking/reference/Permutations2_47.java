package backtracking.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Apollo4634
 * @create 2019/07/28
 * @problem 47
 * @tag Backtracking
 * @see backtracking.solution.Permutations2_47
 */

public class Permutations2_47 {
    static class Solution {

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if(nums.length == 0) return result;

            int[] visited = new int[nums.length];
            Arrays.sort(nums);
            dps(result, new ArrayList<>(), nums, visited);
            return result;
        }

        public void dps(List<List<Integer>> result, List<Integer> temp, int[] nums, int[] visited){
            if(temp.size() == nums.length){
                result.add(new ArrayList<>(temp));
                return;
            }

            for(int i = 0; i < nums.length; i++) {
                if(visited[i] == 1) {
                    continue;
                }
                if(i > 0 && visited[i - 1] == 0 && nums[i] == nums[i-1]) {
                    continue;
                }
                temp.add(nums[i]);
                visited[i] = 1;
                dps(result, temp, nums, visited);
                temp.remove(temp.size() - 1);
                visited[i] = 0;
            }
        }
    }
}
