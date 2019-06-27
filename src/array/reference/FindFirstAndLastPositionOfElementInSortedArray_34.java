package array.reference;

/**
 * @author Apollo4634
 * @create 2019/06/27
 * @problem 34
 * @tag Array
 * @tag Binary Search
 * @see java.util.Arrays - binarySearch()
 * @see array.solution.FindFirstAndLastPositionOfElementInSortedArray_34
 */

public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    static class Solution {
        // returns leftmost (or rightmost) index at which `target` should be
        // inserted in sorted array `nums` via binary search.
        private int extremeInsertionIndex(int[] nums, int target, boolean left) {
            int lo = 0;
            int hi = nums.length;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] > target || (left && target == nums[mid])) {
                    hi = mid;
                }
                else {
                    lo = mid+1;
                }
            }

            return lo;
        }

        public int[] searchRange(int[] nums, int target) {
            int[] targetRange = {-1, -1};

            int leftIdx = extremeInsertionIndex(nums, target, true);

            // assert that `leftIdx` is within the array bounds and that `target`
            // is actually in `nums`.
            if (leftIdx == nums.length || nums[leftIdx] != target) {
                return targetRange;
            }

            targetRange[0] = leftIdx;
            targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

            return targetRange;
        }
    }
}
