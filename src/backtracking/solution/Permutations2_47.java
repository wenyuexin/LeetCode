package backtracking.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 解题思路与46题类似，主要区别在于本题中的数字可以重复，
 * 同时要求不能出现相同的组合。因此有两种修改方法：
 * A) 仍然遍历所有可能的组合，通过Set去重
 * B) 在遍历同一层的节点时，跳过已经遍历过的点（使用的方法）
 *
 * 参考Solution的写法和我这个相似，我的解法慢1ms
 * （我是先自己写再找的参考解法，只能说巧合了...）
 *
 * @author Apollo4634
 * @create 2019/07/13
 * @problem 47
 * @tag Backtracking
 * @see backtracking.solution.Permutations_46
 * @see backtracking.reference.Permutations2_47
 */

public class Permutations2_47 {
    static class Solution {
        private List<List<Integer>> lists;
        private boolean[] marked;
        private Integer[] tracking;

        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums == null) return new LinkedList<>();
            lists = new LinkedList<>();
            marked = new boolean[nums.length];
            tracking = new Integer[nums.length];
            Arrays.sort(nums);
            search(nums, 0);
            return lists;
        }

        private void search(int[] nums, int idx) {
            if (idx == nums.length) {
                lists.add(new ArrayList<>(Arrays.asList(tracking)));
                return;
            }

            for(int i = 0, j = 0; i < nums.length; i = j + 1, j = i) {
                if (marked[i]) continue;
                int last = nums[i];
                while (j+1 < nums.length && nums[j+1] == last) j += 1;

                marked[i] = true;
                tracking[idx] = nums[i];
                search(nums, idx+1);
                marked[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[] { -1,2,-1,2 };
        System.out.println("Input:  "+ Arrays.toString(nums));

        long start = System.nanoTime();
        List<List<Integer>> list = new Solution().permuteUnique(nums);
        long end = System.nanoTime();

        System.out.println("Output: "+ list.toString());
        System.out.println("Runtime: "+(end-start)/1.0E6+" ms");
    }
}
