package array;

import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashMap;


/** 
 * @author Apollo4634 
 * @creation 2018/11/22
 * 
 * Title: Two Sum
 * Runtime: 24 ms, faster than 36.51% of Java online submissions
 */
public class TwoSum2 {
	
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
	
	public int[] twoSum2(int[] nums, int target) {
		int[] indices = {-1,-1};
		
		int[] arr = nums.clone();
		Arrays.sort(arr);
		//排序过于耗时，此法不可行
		
		return indices;
	}
	
	
	
	//Print the array
	static void print(int[] nums) {
		for(int n: nums) {
			System.out.print(n+" ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		int target = 1;
		int[] nums = {-3,4,3,90};
		TwoSum2.print(nums);
		System.out.println("target: "+target);
		
		long t1 = System.nanoTime();
		int[] indices = new TwoSum2().twoSum2(nums, target); 
		long t2 = System.nanoTime();
		
		System.out.println("time_main: "+(t2-t1)/1000);
		TwoSum2.print(indices);
	}
}
