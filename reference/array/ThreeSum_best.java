package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
 * @author - 
 * @creation 2019/01/15 12:01
 */

public class ThreeSum_best {

	//Approach1
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > 0) break;
			if (i > 0 && nums[i] == nums[i - 1]) continue;

			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				if (nums[i] + nums[left] + nums[right] > 0) {
					right--;
				} else if (nums[i] + nums[left] + nums[right] < 0) {
					left++;
				} else {
					ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1]) left++;
					while (left < right && nums[right] == nums[right + 1]) right--;
				}
			}
		}
		return ans;
	}

	//Approach2 
	public List<List<Integer>> threeSum2(int[] nums) {
		int numsLen = nums.length;
		List<List<Integer>> list = new ArrayList<>();
		if(numsLen<3) return list;
		Arrays.sort(nums); //排序

		int sum12, rightIdx;
		List<Integer> triplet;
		for (int i = 0; i < numsLen-2; i++) {
			if(nums[i]>0) break;
			rightIdx = numsLen-1;
			for (int j = i+1; j < numsLen-1; j++) {
				sum12 = nums[i]+nums[j];
				if(sum12>0) break;
				for (int k = rightIdx; k>j; k--) {
					if(nums[k]==-sum12) {
						triplet = Arrays.asList(nums[i], nums[j], -sum12);
						list.add(triplet);
						rightIdx = k-1;
						break;
					} else if (nums[k]<-sum12) {
						rightIdx = (k>numsLen-1)?numsLen-1:k;
						break;
					}
				}
				while (j<numsLen-1 && nums[j]==nums[j+1]) j++;
			}
			while (i<numsLen-2 && nums[i]==nums[i+1]) i++;
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		
	}
}
