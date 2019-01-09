package array;

import java.util.ArrayList;
import java.util.Arrays;
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

	//Solution
	private static int getFirstIndex(int[] arr, int from, int to, int val) {
		int idx_tmp = Arrays.binarySearch(arr, from, to, val);
		if(idx_tmp<0) return idx_tmp;
		
		int idx=0;
		for (int i = idx_tmp; i < arr.length; i++) {
			if(arr[i]==0) idx++;
		}
		return idx;
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		int numsLen = nums.length;
		List<List<Integer>> list = new LinkedList<>();
		if(numsLen<3) return list;

		int[] arr = nums.clone();
		Arrays.sort(arr);

		int zeroIdx = Arrays.binarySearch(arr, 0);
		if(zeroIdx<0) {
			zeroIdx = -(zeroIdx+1);
		} else {
			if(zeroIdx+1<arr.length && arr[zeroIdx+1]==0) zeroIdx++;
			if(zeroIdx+1<arr.length && arr[zeroIdx+1]==0) zeroIdx++;
		}

		int idx, idx_tmp;
		ArrayList<Integer> triplet;
		for (int i = 0; i < arr.length-2; i++) {
			if(arr[i]>0) break;
			idx = arr.length;
			for (int j = i+1; j < arr.length-1; j++) {
				if(arr[i]+arr[j]>0 || j+1>idx) break;
				idx_tmp = Arrays.binarySearch(arr, j+1, idx, -(arr[i]+arr[j]));
				if(idx_tmp<0) continue;
				
				idx = idx_tmp;
				triplet = new ArrayList<Integer>(Arrays.asList(arr[i], arr[j], arr[idx]));
				if(!list.contains(triplet)) list.add(triplet);
			}
		}
		return list;
	}


	public static void main(String[] args) {
		//int[] nums = {-1, 0, 1, 2, -1, -4};
		//int[] nums = {-1, 0, 1, 2, 0, -1, -4};
		//int[] nums = {-3,-3,0,-5};
		//int[] nums = {0,0,0};
		//int[] nums = {-2,-3,0,0,-2};
		
		//[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
		int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}; 

		long t1 = System.nanoTime();
		ThreeSum3 obj = new ThreeSum3();
		List<List<Integer>> list = obj.threeSum(nums);
		long t2 = System.nanoTime();

		//System.out.println("input:  "+Arrays.toString(nums));
		System.out.println("output: "+list);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
