package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author -
 * @date 2019/01/28
 * @problem 18
 */

public class FourSum_18 {
	
	//Solution
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new LinkedList<>();
		int numsLen = nums.length;
		if(numsLen<4) return list;
		Arrays.sort(nums); //排序

		int sum12, i3, i4;
		for (int i1 = 0; i1<numsLen-3; i1++) {
			for (int i2 = i1+1; i2<numsLen-2; i2++) {
				sum12 = nums[i1]+nums[i2];
				i3 = i2+1;
				i4 = numsLen-1;
				while (i3<i4) {
					while(i3<i4 && sum12+nums[i3]+nums[i4]<target) i3++;
					while(i3<i4 && sum12+nums[i3]+nums[i4]>target) i4--;
					if(i3<i4 && sum12+nums[i3]+nums[i4]==target && 
							(i3-1<=i2 || nums[i3]!=nums[i3-1])) {
						list.add(Arrays.asList(nums[i1],nums[i2],nums[i3],nums[i4]));
					}
					i3++;
				}
				while (i2<numsLen-2 && nums[i2]==nums[i2+1]) i2++;
			}
			while (i1<numsLen-3 && nums[i1]==nums[i1+1]) i1++;
		}
		return list;
	}

}
