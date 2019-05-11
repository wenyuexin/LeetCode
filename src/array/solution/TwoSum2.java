package array.solution;

import java.util.Arrays;

/** 
 * @author Apollo4634 
 * @create 2018/11/22
 * @problem 1
 * @see array.reference.TwoSum_1
 */

public class TwoSum2 {
	
	//Solution
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
	
	//Solution2 - 基于排序的方法过于耗时，未完
	public int[] twoSum2(int[] nums, int target) {
		int[] indices = {-1,-1};
		
		int[] arr = nums.clone();
		Arrays.sort(arr);
		//...
		
		return indices;
	}
	
	
	public static void main(String[] args) {
		int target = 1;
		int[] nums = {-3,4,3,90};
		
		long t1 = System.nanoTime();
		int[] indices = new TwoSum2().twoSum2(nums, target); 
		long t2 = System.nanoTime();
		
		System.out.println("nums:   "+Arrays.toString(nums));
		System.out.println("target: "+target);
		System.out.println("output: "+Arrays.toString(indices));
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
