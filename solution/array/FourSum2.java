package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** 
 * @author Apollo4634 
 * @creation 2019/01/22 23:01
 */

public class FourSum2 {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new LinkedList();
		int numsLen = nums.length;
		if(numsLen<4) return list;
		Arrays.sort(nums); //排序
		
		int sum123, rightIdx;
		List<Integer> quadruplet;
		for (int i1 = 0; i1 < numsLen-2; i1++) {
			if(nums[i1]>0) break;
			rightIdx = numsLen-1;
			for (int i2 = i1+1; i2 < numsLen-1; i2++) {
				sum123 = nums[i1]+nums[i2];
				if(sum123>0) break;
				for (int k = rightIdx; k>i2; k--) {
					if(nums[k]==-sum123) {
						quadruplet = Arrays.asList(nums[i1], nums[i2], -sum123);
						list.add(quadruplet);
						rightIdx = k-1;
						break;
					} else if (nums[k]<-sum123) {
						rightIdx = (k>numsLen-1)?numsLen-1:k;
						break;
					}
				}
				while (i2<numsLen-1 && nums[i2]==nums[i2+1]) i2++;
			}
			while (i1<numsLen-2 && nums[i1]==nums[i1+1]) i1++;
		}

		return list;
	}

	
	public static void main(String[] args) {

	}
}
