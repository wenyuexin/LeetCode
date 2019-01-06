package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** 
 * @author Apollo4634 
 * @creation 2019/01/06 00:01
 */

public class ThreeSum {

	//Solution
	public List<List<Integer>> threeSum(int[] nums) {
		int numsLen = nums.length;
		List<List<Integer>> list = new LinkedList<>();
		if(numsLen<3) return list;
		
		
		
		return null;
	}

	
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};

		ThreeSum obj = new ThreeSum();
		long t1 = System.nanoTime();
		List<List<Integer>> list = obj.threeSum(nums);
		long t2 = System.nanoTime();

		System.out.println("input:  "+Arrays.toString(nums));
		System.out.println("output: "+list);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
