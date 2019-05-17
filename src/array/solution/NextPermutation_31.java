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

        //元素交换
        private void swap(int[] arr, int idx, int idx2) {
            int num = arr[idx];
            arr[idx] = arr[idx2];
            arr[idx2] = num;
        }

        //将left-1的元素插入到left到last，并放在last之后
        private void insert(int[] arr, int left) {
            int num = arr[left-1];
            System.arraycopy(arr, left, arr, left-1, arr.length-left);
            arr[arr.length-1] = num;
        }

        //Method 1
        public void nextPermutation(int[] nums) {
            int last = nums.length-1;
            int left = last;
            int idx;

            LOOP:
            for (; left > 0; left--) {
                if (nums[left-1] >= nums[last]) {
                    //将left-1的元素插入到left到last，并放在last之后
                    insert(nums, left);
                }
                //下沉
                for (int i = last; i >= left ; i--) {
                    if (nums[left-1] <= nums[i]) {
                        idx = i;
                        swap(nums, idx,left-1);
                        break LOOP;
                    }
                }
            }

            //交换
            //swap(nums, left-1, idx);
        }


        public static void main(String[] args) {
            int[] nums = new int[] { 1,1,5 };
            System.out.println("Input:  "+Arrays.toString(nums));

            long t1 = System.nanoTime();
            new Solution().nextPermutation(nums);
            long t2 = System.nanoTime();

            System.out.println("Output: "+Arrays.toString(nums));
            System.out.println("Runtime: "+(t2-t1)/1E6);
        }
    }
}