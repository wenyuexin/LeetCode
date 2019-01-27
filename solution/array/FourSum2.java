package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** 
 * @author Apollo4634 
 * @creation 2019/01/22 23:01
 * 
 * No.18 Four Sum
 * 
 */

public class FourSum2 {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new LinkedList<>();
		int numsLen = nums.length;
		if(numsLen<4) return list;
		Arrays.sort(nums); //排序
		
		int sum12, sum34, i3, i4;
		for (int i1 = 0; i1 < numsLen-3; i1++) {
			//if(nums[i1]>0) break;
			for (int i2 = i1+1; i2 < numsLen-2; i2++) {
				sum12 = nums[i1]+nums[i2];
				//if(sum12>0) break;
				
				i3 = i2+1;
				i4 = numsLen-1;
				while (i3<i4) {
					sum34 = nums[i3]+nums[i4];
					while(sum12+sum34<target) i3++;
					while(sum12+sum34>target) i4--;
					
					if(sum12+sum34==target) {
						list.add(Arrays.asList(
							nums[i1], nums[i2], nums[i3], nums[i4]));
						i3++;
					}
				}
				while (i2<numsLen-1 && nums[i2]==nums[i2+1]) i2++;
			}
			while (i1<numsLen-2 && nums[i1]==nums[i1+1]) i1++;
		}
		return list;
	}

	
	public static void main(String[] args) {
		
		int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};

		long t1 = System.nanoTime();
		ThreeSum obj = new ThreeSum();
		List<List<Integer>> list = obj.threeSum3(nums);
		long t2 = System.nanoTime();

		System.out.println("input array:  "+Arrays.toString(nums));
		int[] sortedNums = nums.clone();
		Arrays.sort(sortedNums);
		System.out.println("sorted nums:  "+Arrays.toString(sortedNums));
		System.out.println("output list:  "+list);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
		
	}
}
