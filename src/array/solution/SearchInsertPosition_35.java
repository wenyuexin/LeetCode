package array.solution;

import java.util.Arrays;

/**
 * @author Apollo4634
 * @create 2019/06/27
 * @problem 35
 * @tag Array
 * @tag Binary Search
 * @see java.util.Arrays - binarySearch()
 */

public class SearchInsertPosition_35 {
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int pos = Arrays.binarySearch(nums, target);
            return (pos<0)? -(pos+1) : pos;
        }
    }


    public static void main(String[] args) {
        //int[] nums = {};
        //int[] nums = { 2 };
        //int[] nums = { 8 };
        int[] nums = { 1,3,5,6 };
        //int[] nums = { 8,8,8,8,10 };
        //int[] nums = { 6,7,8,8,8,8 };
        //int[] nums = { 5,7,7,8,10 };
        //int[] nums = { 5,7,7,10 };
        //int[] nums = { 1,8 };
        //int[] nums = { 8,8 };
        //int[] nums = { 8 };
        int target = 5;

        System.out.println("Input:  "+ Arrays.toString(nums));
        System.out.println("Input:  "+target);

        long t1 = System.nanoTime();
        int position = new Solution().searchInsert(nums, target);
        long t2 = System.nanoTime();

        System.out.println("Output: "+position);
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
