package backtracking.reference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Apollo4634
 * @create 2019/07/13
 * @problem 46
 * @tag Backtracking
 * @see backtracking.solution.Permutations_46
 */

public class Permutations_46 {
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            helper(0,nums,res);
            return res;
        }

        private void helper(int start, int[] nums, List<List<Integer>> res){
            if(start >= nums.length){
                List<Integer> list = new ArrayList<>();
                for(int num : nums) list.add(num);
                res.add(list);
            }

            for(int i = start; i < nums.length; i++){
                //System.out.println("start: "+start+" i: "+i);
                swap(nums,i,start);
                helper(start+1,nums,res);
                swap(nums,i,start);
            }
        }

        private void swap(int[] nums,int i,int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
