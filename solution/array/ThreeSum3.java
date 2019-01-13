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
 * 以下解法都是基于Arrays.sort()排序结果的方法，
 * 本地测试中排序是各方法中最耗时的部分
 */

public class ThreeSum3 {

	//Solution1
	public List<List<Integer>> threeSum(int[] nums) {
		int numsLen = nums.length;
		List<List<Integer>> list = new LinkedList<>();
		if(numsLen<3) return list;

		Arrays.sort(nums); //排序

		int idx, idx_tmp;
		ArrayList<Integer> triplet;
		for (int i = 0; i < nums.length-2; i++) { //搜索
			if(nums[i]>0) break;
			idx = nums.length;
			for (int j = i+1; j < nums.length-1; j++) {
				if(nums[i]+nums[j]>0 || j+1>idx) break;
				idx_tmp = Arrays.binarySearch(nums, j+1, idx, -(nums[i]+nums[j]));
				if(idx_tmp<0) continue;

				idx = idx_tmp;
				triplet = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[idx]));
				if(!list.contains(triplet)) list.add(triplet);
			}
		}
		return list;
	}

	//Solution2
	public List<List<Integer>> threeSum2(int[] nums) {
		int numsLen = nums.length;
		List<List<Integer>> list = new ArrayList<>();
		if(numsLen<3) return list;

		Arrays.sort(nums);

		int zeroIdx = Arrays.binarySearch(nums, 0);
		if(zeroIdx<0) {
			zeroIdx = -(zeroIdx+1);
		} else {
			int nZeros = 1;
			if(zeroIdx+1<nums.length && nums[zeroIdx+1]==0) nZeros++;
			if(zeroIdx+2<nums.length && nums[zeroIdx+2]==0) nZeros++;
			if(zeroIdx-1>=0 && nums[zeroIdx-1]==0) nZeros++;
			if(zeroIdx-2>=0 && nums[zeroIdx-2]==0) nZeros++;
			if(nZeros>=3) list.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0)));
		}

		int rightIdx, sum12;
		ArrayList<Integer> triplet;
		for (int i = 0; i < numsLen-2; i++) {
			if(nums[i]>0) break;
			rightIdx = Arrays.binarySearch(nums, i+1, nums.length, -2*nums[i]);
			if(rightIdx<0) rightIdx=-(rightIdx+1);
			if(rightIdx>numsLen-1) rightIdx=numsLen-1;

			LOOP:
				for (int j = i+1; j < numsLen-1; j++) {
					sum12 = nums[i]+nums[j];
					if(sum12>0 || j+1>rightIdx) break;
					for (int k = rightIdx; k>j && k>=zeroIdx; k--) {
						if(nums[k]==-sum12) {
							triplet = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k]));
							if(!list.contains(triplet)) list.add(triplet);
							rightIdx = k;
							continue LOOP;
						} else if (nums[k]<-sum12) {
							rightIdx = k+1;
							if(rightIdx>numsLen-1) rightIdx=numsLen-1;
							continue LOOP;
						}
					}
				}
		}
		return list;
	}

	//Solution3
	public List<List<Integer>> threeSum3(int[] nums) {
		int numsLen = nums.length;
		List<List<Integer>> list = new ArrayList<>();
		if(numsLen<3) return list;

		Arrays.sort(nums); //排序

		int sum12;
		int rightIdx = numsLen-1;
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
						//System.out.println(""+i+" "+j+" "+k+" "+triplet);
						if(!list.contains(triplet)) list.add(triplet);
						rightIdx = k-1;
						break;
					} else if (nums[k]<-sum12) {
						rightIdx = k;
						if(rightIdx>numsLen-1) rightIdx=numsLen-1;
						break;
					}
				}
			}
		}
		return list;
	}

	//Solution4 - 施工中
	public List<List<Integer>> threeSum4(int[] nums) {
		int numsLen = nums.length;
		List<List<Integer>> list = new ArrayList<>();
		if(numsLen<3) return list;

		Arrays.sort(nums); //排序

		int sum12;
		int rightIdx = numsLen-1;
		List<Integer> triplet;
		for (int i = 0; i < numsLen-2; i++) {
			if(nums[i]>0) break;

			rightIdx = numsLen-1;
			for (int j = i+1; j < numsLen-1; j++) {
				sum12 = nums[i]+nums[j];
				if(sum12>0) break;

				System.out.println(""+i+"-"+nums[i]+"   "+j+"-"+nums[i]);

				for (int k = rightIdx; k>j; k--) {
					if(nums[k]==-sum12) {
						triplet = Arrays.asList(nums[i], nums[j], -sum12);
						System.out.println(""+i+" "+j+" "+k+" "+triplet);
						if(!list.contains(triplet)) list.add(triplet);
						rightIdx = k-1;
						break;
					} else if (nums[k]<-sum12) {
						while (nums[k]==nums[k-1]) 
							k--;
						rightIdx = k;
						if(rightIdx>numsLen-1) rightIdx=numsLen-1;
						break;
					}

					while (nums[j]==nums[j+1]) 
						j++;
				}

				while (nums[i]==nums[i+1]) 
					i++;
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

		//[]
		//int[] nums = {-2,-3,0,0,-2};

		//[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
		int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}; 

		//[[-1,-4,5],[-2,-3,5]]
		//int[] nums = {-1,0,-4,-2,-3,5};

		//[[-1,-1,2],[-1,0,1]]
		//int[] nums = {-1,0,1,2,-1,-4};

		long t1 = System.nanoTime();
		ThreeSum3 obj = new ThreeSum3();
		List<List<Integer>> list = obj.threeSum4(nums);
		long t2 = System.nanoTime();

		System.out.println("input array:  "+Arrays.toString(nums));
		int[] sortedNums = nums.clone();
		Arrays.sort(sortedNums);
		System.out.println("sorted nums:  "+Arrays.toString(sortedNums));
		System.out.println("output list:  "+list);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
