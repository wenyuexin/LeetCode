package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/** 
 * 先将数组nums依正负分为positiveList negativeList两组，然后分别排序，
 * 排序的作用是为了缩短以下操作的时间，即判断某个数是否在数组中。
 * 
 * 由于需要搜索的是和为0的三元组，如果已知三元组triplet的中两个元素e1 e2，
 * 那么只需要判断剩余的数字中是否存在e3，其中e3=-(e1+e2)
 * 
 * 如果e1 e2是正数，那么e3为负数；如果e1 e2是负数，那么e3为正数。
 * 那么可以搜索主要分为两个部分：
 * 在positiveList中取出e1 e2，然后判断negativeList中是否存在e3；
 * 在negativeList中取出e1 e2，然后判断positiveList中是否存在e3；
 * 在positiveList中判断是否存在3个0
 * 
 * @author Apollo4634 
 * @date 2019/01/06 00:01
 * @problem 15
 */

public class ThreeSum2 {

	//Solution - 这个方法太耗时，不能通过测试
	public List<List<Integer>> threeSum(int[] nums) {
		int numsLen = nums.length;
		List<List<Integer>> list = new LinkedList<>();
		if(numsLen<3) return list;

		//分组与排序
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

		//搜索3元组：2负1正
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

		//搜索3元组：1负2正
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

		//搜索3元组：3个0
		if(positiveList.size()>=3) {
			if(positiveList.get(0)==0 && positiveList.get(1)==0 && positiveList.get(2)==0) {
				list.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0)));
			}
		}
		return list;
	}

	//Solution2 - 勉强通过，效率极低
	public List<List<Integer>> threeSum2(int[] nums) {
		int numsLen = nums.length;
		List<List<Integer>> list = new LinkedList<>();
		if(numsLen<3) return list;

		//分组与排序
		int minNum = nums[0];
		int maxNum = nums[0];
		List<Integer> negativeList = new LinkedList<Integer>();
		List<Integer> positiveList = new LinkedList<Integer>();
		Set<Integer> negativeSet = new HashSet<Integer>();
		Set<Integer> positiveSet = new HashSet<Integer>();
		int nZeros = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]<0) {
				negativeList.add(nums[i]);
				negativeSet.add(nums[i]);
			} else {
				positiveList.add(nums[i]);
				positiveSet.add(nums[i]);
				if(nums[i]==0) nZeros++;
			}
			if(maxNum<nums[i]) maxNum=nums[i];
			if(minNum>nums[i]) minNum=nums[i];
		}
		if(maxNum<0 || minNum>0) return list;
		if(positiveList.size()==0) return list;
		if(negativeList.size()==0 && positiveList.size()<3) return list;
		if(maxNum==0 && positiveList.size()>=3) {
			list.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0)));
			return list;
		}

		//搜索3元组：2负1正
		ArrayList<Integer> triplet;
		int e1, e2, e3;
		for (int i = 0; i < negativeList.size()-1; i++) {
			for (int j = i+1; j < negativeList.size(); j++) {
				e1 = negativeList.get(i);
				e2 = negativeList.get(j);
				e3 = -(e1+e2);
				if(positiveSet.contains(e3)) {
					triplet = new ArrayList<Integer>(Arrays.asList(e1, e2, e3));
					Collections.sort(triplet);
					if(!list.contains(triplet)) list.add(triplet);
				}
			}
		}

		//搜索3元组：1负2正
		for (int i = 0; i < positiveList.size()-1; i++) {
			for (int j = i+1; j < positiveList.size(); j++) {
				e1 = positiveList.get(i);
				e2 = positiveList.get(j);
				e3 = -(e1+e2);
				if(negativeSet.contains(e3)) {
					triplet = new ArrayList<Integer>(Arrays.asList(e3, e1, e2));
					Collections.sort(triplet);
					if(!list.contains(triplet)) list.add(triplet);
				}
			}
		}

		//搜索3元组：3个0
		if(nZeros>=3) {
			list.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0)));
		}
		return list;
	}


	public static void main(String[] args) {
		//int[] nums = {-1, 0, 1, 2, -1, -4};
		//int[] nums = {-1, 0, 1, 2, 0, -1, -4};
		//int[] nums = {-3,-3,0,-5};
		//int[] nums = {0,0,0};
		int[] nums = {-2,-3,0,0,-2};

		long t1 = System.nanoTime();
		ThreeSum2 obj = new ThreeSum2();
		List<List<Integer>> list = obj.threeSum2(nums);
		long t2 = System.nanoTime();

		//System.out.println("input:  "+Arrays.toString(nums));
		System.out.println("output: "+list);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}

