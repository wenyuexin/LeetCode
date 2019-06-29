package array.solution;

import java.util.Arrays;

/**
 * 二分法
 *
 * @author Apollo4634
 * @create 2019/06/09
 * @problem 33
 * @tag Array, Binary Search
 * @see java.util.Arrays - binarySearch()
 */

public class SearchInRotatedSortedArray_33 {

    //此法耗时少，Recommend
    public static class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) return -1;
            int numsLen = nums.length;
            if (numsLen == 1) return (nums[0]==target)? 0 : -1;

            int index;
            if (nums[0] <= nums[numsLen-1]) {
                index = Arrays.binarySearch(nums, target);
                return (index<0)? -1 : index;
            }

            if (target == nums[0]) return 0;
            if (target == nums[numsLen-1]) return numsLen-1;

            int left = 0;
            int right = numsLen-1;
            int mid, midVal;
            if (target > nums[0]) {
                while (left < right) {
                    mid = (left + right)/2;
                    midVal = nums[mid];

                    if (midVal > target) {
                        right = mid;
                        index = Arrays.binarySearch(nums, left, right, target);
                        return (index<0)? -1 : index;
                    } else if (midVal < target) {
                        if (midVal < nums[0]) {
                            right = mid;
                        } else {
                            left = mid + 1;
                        }
                    } else {
                        return mid;
                    }
                }
                if (left == right && target == nums[left]) return left;
            }

            if (target < nums[right]) {
                while (left < right) {
                    mid = (left + right)/2;
                    midVal = nums[mid];

                    if (midVal < target) {
                        left = mid + 1;
                        index = Arrays.binarySearch(nums, left, right, target);
                        return (index<0)? -1 : index;
                    } else if (midVal > target) {
                        if (midVal > nums[right]) {
                            left = mid + 1;
                        } else {
                            right = mid;
                        }
                    } else {
                        return mid;
                    }
                }
                if (left == right && target == nums[left]) return left;
            }
            return -1;
        }
    }


    public static void main(String[] args) {
        int[] nums = { 4,5,6,7,0,1,2 };
        int target = 8;

        System.out.println("Input:  "+Arrays.toString(nums));
        System.out.println("Input:  "+target);

        long t1 = System.nanoTime();
        int index = new Solution().search(nums, target);
        long t2 = System.nanoTime();

        System.out.println("Output: "+index);
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
