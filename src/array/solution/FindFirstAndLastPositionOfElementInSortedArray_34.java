package array.solution;

import java.util.Arrays;

/**
 * 二分法
 *
 * @author Apollo4634
 * @create 2019/06/27
 * @problem 34
 * @tag Array
 * @tag Binary Search
 * @see java.util.Arrays - binarySearch()
 * @see array.reference.FindFirstAndLastPositionOfElementInSortedArray_34
 */

public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] range = new int[] { -1,-1 };
            if (nums == null || nums.length == 0) {
                return range;
            } else if (nums.length == 1) {
                if (nums[0] == target) range = new int[] { 0,0 };
                return range;
            }

            int left = 0;
            int right = nums.length - 1;
            int mid, midVal;
            while (left < right) {
                mid = (left + right) >>> 1;
                midVal = nums[mid];

                if (midVal < target) {
                    left = mid + 1;
                } else if (midVal > target) {
                    right = mid - 1;
                } else {
                    int first = findFirst(nums, left, mid, target);
                    int last = findLast(nums, mid, right, target);
                    return new int[] { first,last };
                }
            }

            if (left == right && nums[left] == target) {
                range = new int[] { left,right };
            }
            return range;
        }

        private int findFirst(int[] nums, int left, int right, int target) {
            int first = right;
            while (left < first) {
                if (nums[left] == target) return left;
                int mid = (left+first) >>> 1;
                int midVal = nums[mid];
                if (midVal < target) {
                    left = mid + 1;
                } else {
                    first = mid;
                }
            }
            return first;
        }

        private int findLast(int[] nums, int left, int right, int target) {
            int last = left;
            while (last < right) {
                if (nums[right] == target) return right;
                int mid = (last+right) >>> 1;
                int midVal = nums[mid];
                if (midVal > target) {
                    right = mid - 1;
                } else {
                    last = mid;
                    if (last+1 == right && nums[right] > target) return last;
                }
            }
            return last;
        }
    }


    public static void main(String[] args) {
        //int[] nums = { 5,7,7,8,8,10 };
        //int[] nums = { 8,8,8,8,10 };
        //int[] nums = { 6,7,8,8,8,8 };
        //int[] nums = { 5,7,7,8,10 };
        //int[] nums = { 5,7,7,10 };
        //int[] nums = { 1,8 };
        int[] nums = { 8,9 };
        //int[] nums = { 8,8 };
        //int[] nums = { 8 };
        int target = 8;

        System.out.println("Input:  "+ Arrays.toString(nums));
        System.out.println("Input:  "+target);

        long t1 = System.nanoTime();
        int[] range = new Solution().searchRange(nums, target);
        long t2 = System.nanoTime();

        System.out.println("Output: "+Arrays.toString(range));
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
