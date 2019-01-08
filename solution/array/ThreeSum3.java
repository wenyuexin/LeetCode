package array;

import java.util.LinkedList;
import java.util.List;

/** 
 * @author Apollo4634 
 * @creation 2019/01/08 00:01
 * 
 * No.15 Three Sum
 * 
 * 解题思路：
 * 假设和为0的三元组triplet包含e1 e2 e3三个元素，
 * ThreeSum2提供了遍历e1 e2并搜索e3的方法，
 * 
 * 施工中
 */

public class ThreeSum3 {
	public List<List<Integer>> threeSum(int[] nums) {
		int numsLen = nums.length;
		List<List<Integer>> list = new LinkedList<>();
		if(numsLen<3) return list;
		
		//Map<Integer>;
		
		return list;
	}
	
	
	public static void main(String[] args) {
		//int[] nums = {-1, 0, 1, 2, -1, -4};
		//int[] nums = {-1, 0, 1, 2, 0, -1, -4};
		//int[] nums = {-3,-3,0,-5};
		//int[] nums = {0,0,0};
		int[] nums = {-2,-3,0,0,-2};

		long t1 = System.nanoTime();
		ThreeSum3 obj = new ThreeSum3();
		List<List<Integer>> list = obj.threeSum(nums);
		long t2 = System.nanoTime();

		//System.out.println("input:  "+Arrays.toString(nums));
		System.out.println("output: "+list);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
