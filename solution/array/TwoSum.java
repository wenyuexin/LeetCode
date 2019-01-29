package array;

import java.util.Arrays;

//import java.util.Arrays;

/** 
 * @author Apollo4634 
 * @date 2018/11/21
 * 
 * N0.1 Two Sum
 */

public class TwoSum {
	
	//Solution
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
	
	
	public static void main(String[] args) {
		int target = 0;
		int[] nums = {-3,4,3,90};
		
		long t1 = System.nanoTime();
		int[] indices = new TwoSum().twoSum(nums, target); 
		long t2 = System.nanoTime();
		
		System.out.println("nums:   "+Arrays.toString(nums));
		System.out.println("target: "+target);
		System.out.println("output: "+Arrays.toString(indices));
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
