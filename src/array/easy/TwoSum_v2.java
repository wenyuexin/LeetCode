package array.easy;

import java.util.Arrays;
import java.util.Collections;

/** 
 * @author Apollo4634 
 * @creation 2018/11/22
 */
public class TwoSum_v2 {
	
	public int[] twoSum(int[] nums, int target) {
		int[] indices = {-1,-1};
		int[] arr = nums.clone();
		Arrays.sort(arr,0,nums.length);
		
		//int minNum = Collections.min(nums);
        for(int i=0; i<nums.length; i++) {
        	
        	
        	for(int j=i+1; j<nums.length; j++) {
        		if(nums[i]+nums[j]==target) {
        			return new int[] {i,j};
        		}
        	}
        }
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
		int target = 0;
		int[] nums = {-3,4,3,90};
		TwoSum_v2.print(nums);
		
		int[] indices = new TwoSum().twoSum(nums, target); 
		TwoSum_v2.print(indices);
	}
}
