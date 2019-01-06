package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/** 
 * @author Apollo4634 
 * @creation 2019/01/06 00:01
 * 
 * No.15 Three Sum
 * 
 * 解题思路：
 * 
 */

public class ThreeSum2 {

	//Solution - 这个方法太耗时，测试不通过
	public List<List<Integer>> threeSum(int[] nums) {
		int numsLen = nums.length;
		List<List<Integer>> list = new LinkedList<>();
		if(numsLen<3) return list;

		ArrayList<Integer> negativeList = new ArrayList<Integer>();
		ArrayList<Integer> positiveList = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]<0) {
				negativeList.add(nums[i]);
			} else {
				positiveList.add(nums[i]);
			}
		}
		Collections.sort(negativeList);
		Collections.sort(positiveList);
		
		if(positiveList.size()==0) {
			return list;
		} else {
			if(positiveList.get(positiveList.size()-1)<0) return list;
		}
		
		if(negativeList.size()==0) {
			if(positiveList.size()<3) return list;			
		} else {
			if(negativeList.get(0)>0) return list;
		}

		//2负1正
		ArrayList<Integer> triplet;
		int e1, e2, e3;
		for (int i = 0; i < negativeList.size()-1; i++) {
			for (int j = i+1; j < negativeList.size(); j++) {
				e1 = negativeList.get(i);
				e2 = negativeList.get(j);
				e3 = -(e1+e2);
				if(Collections.binarySearch(positiveList,e3)>=0) {
					triplet = new ArrayList<Integer>(Arrays.asList(e1, e2, e3));
					if(!list.contains(triplet)) list.add(triplet);
				}
			}
		}
		
		//1负2正
		for (int i = 0; i < positiveList.size()-1; i++) {
			for (int j = i+1; j < positiveList.size(); j++) {
				e1 = positiveList.get(i);
				e2 = positiveList.get(j);
				e3 = -(e1+e2);
				if(Collections.binarySearch(negativeList,e3)>=0) {
					triplet = new ArrayList<Integer>(Arrays.asList(e3, e1, e2));
					if(!list.contains(triplet)) list.add(triplet);
				}
			}
		}
		
		//3个0
		if(positiveList.size()>=3) {
			if(positiveList.get(0)==0 && positiveList.get(1)==0 && positiveList.get(2)==0) {
				list.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0)));
			}
		}
		return list;
	}

	//Solution2 - 施工中
	public List<List<Integer>> threeSum2(int[] nums) {
		int numsLen = nums.length;
		List<List<Integer>> list = new ArrayList<>();
		if(numsLen<3) return list;

		//Set<Integer> negativeSet = new HashSet<Integer>();


		int maxNum = nums[0];
		int minNum = nums[0];
		
		for (int i = 0; i < nums.length; i++) {
			if(maxNum<nums[i]) maxNum=nums[i];
			if(minNum>nums[i]) minNum=nums[i];
		}
		if(maxNum<0||minNum>0) return list;

		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {

			}
		}


		return list;
	}

	
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		//int[] nums = {-1, 0, 1, 2, 0, -1, -4};
		//int[] nums = {-3,-3,0,-5};
		//int[] nums = {0,0,0};
		
		long t1 = System.nanoTime();
		ThreeSum2 obj = new ThreeSum2();
		List<List<Integer>> list = obj.threeSum(nums);
		long t2 = System.nanoTime();

		//System.out.println("input:  "+Arrays.toString(nums));
		System.out.println("output: "+list);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}

