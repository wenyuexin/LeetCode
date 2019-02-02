package array;

import java.util.Arrays;

/**
 * @author -
 * @create 2019/01/31
 * @problem 16
 */

public class ThreeSumClosest_16 {

	//7ms approach on leetcode
	private int twoSumClosest(int[] nums, int target, int end) {
		int ret = Integer.MAX_VALUE, left = 0, right = end;
		while(left < right) {
			int item = nums[left] + nums[right] - target;
			if(item == 0) return 0;
			if(Math.abs(item) < Math.abs(ret)) ret = item;
			
			if(item < 0) { left++; } 
			else { right--; }
		}
		return ret;
	}
	
	public int threeSumClosest(int[] nums, int target) {
		int ret = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for(int i = nums.length - 1; i >= 2; i--) {
			if(i == nums.length - 1 || nums[i] != nums[i + 1]) {
				int item = twoSumClosest(nums, target - nums[i], i - 1);
				if(item == 0)  return target;
				if(Math.abs(item) < Math.abs(ret)) ret = item;
			}            
		}
		return ret + target;
	}

}
