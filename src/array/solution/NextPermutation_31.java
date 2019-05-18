package array.solution;

import java.util.Arrays;

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
        private void swap(int[] arr, int idx, int idx2) {
            int num = arr[idx];
            arr[idx] = arr[idx2];
            arr[idx2] = num;
        }

        private void insert(int[] arr, int left) {
            int num = arr[left-1];
            System.arraycopy(arr, left, arr, left-1, arr.length-left);
            arr[arr.length-1] = num;
        }

        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length < 2) return;
            int last = nums.length-1;

            LOOP:
            for (int left = last; left > 0; left--) {
                if (nums[left-1] >= nums[last]) {
                    insert(nums, left);
                    continue;
                } else if (nums[left-1] < nums[left]) {
                    swap(nums, left-1, left);
                    break;
                }
                //下沉
                for (int i = last-1; i >= left ; i--) {
                    if (nums[left-1] >= nums[i]) {
                        swap(nums, i+1, left-1);
                        break LOOP;
                    }
                }
            }
        }
    }



    public static void main(String[] args) {
        //int[] nums = new int[] { 1,1,5 };
        //int[] nums = new int[] { 1,5,1 }; //[5,1,1]
        //int[] nums = new int[] { 5,4,5,6,7 };
        //int[] nums = new int[] { 5,4,5,7,7 };
        //int[] nums = new int[] { 4,3,1 };
        //int[] nums = new int[] { 2,3,1 };
        int[] nums = new int[] {2,2,7,5,4,3,2,2,1}; //[2,3,1,2,2,2,4,5,7]
        System.out.println("Input:  "+Arrays.toString(nums));

        long t1 = System.nanoTime();
        new Solution().nextPermutation(nums);
        long t2 = System.nanoTime();

        System.out.println("Output: "+Arrays.toString(nums));
        System.out.println("Runtime: "+(t2-t1)/1E6+" ms");
    }
}