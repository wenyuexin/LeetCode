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

	//Solution
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new LinkedList<>();
		int numsLen = nums.length;
		if(numsLen<4) return list;
		Arrays.sort(nums); //排序
		
		int sum12, i3, i4;
		for (int i1 = 0; i1 < numsLen-3; i1++) {
			for (int i2 = i1+1; i2 < numsLen-2; i2++) {
				sum12 = nums[i1]+nums[i2];
				i3 = i2+1;
				i4 = numsLen-1;
				while (i3<i4) {
					while(i3<i4 && sum12+nums[i3]+nums[i4]<target) i3++;
					{
						//if(i3<i4) i3++;
						//while(i3<i4 && nums[i3]==nums[i3-1]) i3++;
					}
					
					while(i3<i4 && sum12+nums[i3]+nums[i4]>target) i4--;
					{
						//i4--;
						//while(i3<i4 && nums[i4]==nums[i4+1]) i4--;
					}
					
					if(i3<i4 && sum12+nums[i3]+nums[i4]==target) {
						list.add(Arrays.asList(nums[i1],nums[i2],nums[i3],nums[i4]));
						i3++;
					}
				}
				while (i2<numsLen-2 && nums[i2]==nums[i2+1]) i2++;
			}
			while (i1<numsLen-3 && nums[i1]==nums[i1+1]) i1++;
		}
		return list;
	}

	
	public static void main(String[] args) {
		int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		int target = 0;

		long t1 = System.nanoTime();
		FourSum2 obj = new FourSum2();
		List<List<Integer>> list = obj.fourSum(nums, target);
		long t2 = System.nanoTime();

		System.out.println("input array:  "+Arrays.toString(nums));
		System.out.println("input target: "+target);
		System.out.println("output list:  "+list);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
