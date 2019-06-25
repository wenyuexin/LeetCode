package array.solution;

import java.util.Arrays;

/**
 * 二分法
 *
 * @author Apollo4634
 * @create 2019/06/09
 * @problem 33
 * //@see array.reference.SearchInRotatedSortedArray_33
 */

public class SearchInRotatedSortedArray_33 {
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
            int mid = (left+right)/2;
            if (target > nums[0]) {
                while (mid>left && mid<right) {
                    if (nums[mid] == target) return mid;
                    if (nums[mid] > target) {
                        index = Arrays.binarySearch(nums, left, right, target);
                        return (index<0)? -1 : index;
                    } else {
                        if (nums[mid]<nums[0]) {

                        }
                    }
                }

            }


            return -1;
        }
    }

}
