package array.solution;

import java.util.Arrays;

/** 
 * @author Apollo4634 
 * @create 2018/11/21
 * @problem 1
 * @see array.reference.TwoSum_1
 */

public class TwoSum {
	
	//Solution 1
	public static class Solution {
		public int[] twoSum(int[] nums, int target) {
			int[] indices = {-1,-1};
			//Arrays.sort(nums,0,nums.length);
			for(int i=0; i<nums.length; i++) {
				for(int j=i+1; j<nums.length; j++) {
					if(nums[i]+nums[j]==target) {
						return new int[] {i,j};
					}
				}
			}
			return indices;
		}
	}


	//Solution 2
	public static class Solution2 {
		public int[] twoSum(int[] nums, int target) {
			int[] indices = {-1,-1};

			int min = nums[0];
			for(int i=1; i<nums.length; i++) {
				if(nums[i]<min) {
					min = nums[i];
				}
			}

			int t = target - min;
			for(int i=0; i<nums.length; i++) {
				if(nums[i] > t) continue;
				for(int j=i+1; j<nums.length; j++) {
					if(nums[j] > t) continue;
					if(nums[i]+nums[j]==target) {
						return new int[] {i,j};
					}
				}
			}
			return indices;
		}
	}

	
	public static void main(String[] args) {
		int target = 0;
		int[] nums = {-3,4,3,90};

		System.out.println("Input:  nums:   "+Arrays.toString(nums));
		System.out.println("Input:  target: "+target);

		long t1 = System.nanoTime();
		int[] indices = new TwoSum.Solution().twoSum(nums, target);
		long t2 = System.nanoTime();

		System.out.println("Output: "+Arrays.toString(indices));
		System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
	}
}
