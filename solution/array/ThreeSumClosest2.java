package array;

import java.util.Arrays;
import java.util.List;

/** 
 * @author Apollo4634 
 * @creation 2019/01/15 23:01
 * 
 * No.16 3 Sum Closest
 * 
 * 解题思路：
 * 
 */

public class ThreeSumClosest2 {
	
	//Solution1
	public int threeSumClosest(int[] nums, int target) {
		int numsLen = nums.length;
		Arrays.sort(nums);
		
		int closestSum = 0;
		for (int i = 0; i < numsLen-2; i++) {
			for (int j = i+1; j < numsLen-1; j++) {
				int e3 = target - nums[i] - nums[j];
				
				
			}
		}
		
		
		return 0;
	}

	
	public static void main(String[] args) {
		int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		int target = 1;
		
		long t1 = System.nanoTime();
		ThreeSumClosest2 obj = new ThreeSumClosest2();
		int closestSum = obj.threeSumClosest(nums, target);
		long t2 = System.nanoTime();

		System.out.println("input array:  "+Arrays.toString(nums));
		int[] sortedNums = nums.clone();
		Arrays.sort(sortedNums);
		System.out.println("sorted nums:  "+Arrays.toString(sortedNums));
		System.out.println("output list:  "+closestSum);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
