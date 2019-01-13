package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * @author Apollo4634 
 * @creation 2019/01/13 21:01
 * 
 * No.15 Three Sum
 * 
 * 解题思路：
 * 
 */

public class ThreeSum4 {

	//Solution - 暴力搜索法
	public List<List<Integer>> threeSum(int[] nums) {
		int numsLen = nums.length;
		List<List<Integer>> list = new ArrayList<>();

		int sum12;
		List<Integer> triplet;
		for (int i = 0; i < numsLen-2; i++) {
			if(nums[i]>0) break;
			for (int j = i+1; j < numsLen-1; j++) {
				sum12 = nums[i]+nums[j];
				for (int k = j+1; k < numsLen; k++) {
					if(nums[k]==-sum12) {
						triplet = Arrays.asList(nums[i], nums[j], nums[k]);
						Collections.sort(triplet);
						if(!list.contains(triplet)) list.add(triplet);
						break;
					}
				}
			}
		}
		return list;
	}

	//Solution2
	public List<List<Integer>> threeSum2(int[] nums) {
		int numsLen = nums.length;
		List<List<Integer>> list = new ArrayList<>();

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numsLen; i++) {
			map.put(nums[i], i);
		}
		
		int sum12;
		List<Integer> triplet;
		for (int i = 0; i < numsLen-2; i++) {
			if(nums[i]>0) break;
			for (int j = i+1; j < numsLen-1; j++) {
				sum12 = nums[i]+nums[j];
				for (int k = j+1; k < numsLen; k++) {
					if(nums[k]==-sum12) {
						triplet = Arrays.asList(nums[i], nums[j], nums[k]);
						Collections.sort(triplet);
						if(!list.contains(triplet)) list.add(triplet);
						break;
					}
				}
			}
		}
		return list;
	}


	public static void main(String[] args) {
		//int[] nums = {-1, 0, 1, 2, -1, -4};
		//int[] nums = {-1, 0, 1, 2, 0, -1, -4};
		//int[] nums = {-3,-3,0,-5};

		//[[0,0,0]]
		//int[] nums = {0,0,0};

		//int[] nums = {-2,-3,0,0,-2};

		//[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
		int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}; 

		//[[-1,-4,5],[-2,-3,5]]
		//int[] nums = {-1,0,-4,-2,-3,5};

		//[[-1,-1,2],[-1,0,1]]
		//int[] nums = {-1,0,1,2,-1,-4};

		long t1 = System.nanoTime();
		ThreeSum4 obj = new ThreeSum4();
		List<List<Integer>> list = obj.threeSum2(nums);
		long t2 = System.nanoTime();

		System.out.println("input:  "+Arrays.toString(nums));
		System.out.println("output: "+list);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
