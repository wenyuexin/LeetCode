package array.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

/**
 * Solution 1
 *
 * 假设和为0的三元组triplet包含e1 e2 e3三个元素，
 * ThreeSum2提供了遍历e1 e2并搜索e3的方法，
 * 
 * 以下解法都是基于Arrays.sort()排序结果的方法，
 * 本地测试中排序是这些方法中最耗时的部分，
 * 但是下面这条语句对LeetCode的运行时间影响极大，会极大增加runtime：
 * list.contains(triplet) //判断列表是否包含某个三元组
 * 
 * 以下若干解法中可能存在部分优化：
 * 假设e1 e2 e3的下标分别是i j k (三者满足i<j<k)
 * 
 * (A)
 * 如果找到了一组和为0的e1 e2 e3，那么可能存在另一组和为0的e1 e2' e3'，
 * 其中下标有idx(e2)<idx(e2')，因此需要固定i继续搜索，判断是否存在e2'和e3'.
 * 
 * 对于固定的e1(即i不变)，当更新e2(即j=j+1)时，e2变大，如果要满足e1+e2+e3=0，
 * 那么e3必然要变小，因此e3的搜索范围收缩为idx(e2)+1至 idx(e3)-1
 * 
 * (B)
 * 基于A，这里根据e1+e2+e3=0可以进一步收缩e3的搜索范围.
 * 假设e1+e2+e3=0，更新e3(即k=k-1)，可以知道更新后可能有e1+e2+e3>0，
 * 那么可以继续更新e3，直到e1+e2+e3'=0或者e1+e2+e3'<0，
 * 对于前者直接保存新的三元组，然后更新e2(即j=j+1)，再从idx(e3)-1开始搜索新的e3
 * 对于后者直接更新e2(即j=j+1)，再从idx(e3)开始搜索新的e3
 * 
 * (C)
 * a. 对于某个e1(下标为i)，如果nums[i]==nums[i+1]==e1，那么，
 * 以nums[i+1]为e1得到的三元组的集合包含了以nums[i]为e1得到的三元组的集合.
 * 依次类推，如果nums[i]==nums[i+1]==...==nums[i+I]，那么
 * 以nums[i]为e1得到的三元组的集合也包含了以nums[i+I]为e1得到的三元组的集合，
 * 因此，nums[i]为e1搜索后不需要再以nums[i+i'] (i'=1,2,...,I)为e1进行搜索.
 * b. 同理，对于固定的e1，如果nums[j]==nums[j+1]==...==nums[j+J]==e2，
 * 那么以nums[j]为e2得到的三元组的集合也包含了以nums[j+J]为e2得到的三元组的集合.
 * 
 * 值得注意的是，如果根据第三点对每次搜索的e1 e2进行直接更新，
 * 那么不存在相同的三元组，因此不需要判断最终结果中是否存在重复的三元组
 * 
 *
 * Solution 2
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
 *
 * Solution 3
 *
 *
 *
 * @author Apollo4634 
 * @create 2019/01/08 00:01
 * @problem 15
 * @see array.reference.ThreeSum_15
 */

public class ThreeSum_15 {

	public static class Solution1 {

		//通过binarySearch确定e3的位置
		public List<List<Integer>> threeSum(int[] nums) {
			int numsLen = nums.length;
			List<List<Integer>> list = new LinkedList<>();
			if(numsLen<3) return list;
			Arrays.sort(nums); //排序

			int rightIdx; //对于固定的e1，idx是上一个和为0的三元组中e3的位置
			int idx_tmp;
			List<Integer> triplet;
			for (int i = 0; i < nums.length-2; i++) { //搜索
				if(nums[i]>0) break;
				rightIdx = nums.length; //切换e1后将idx更新为数组的最后一个元素处
				for (int j = i+1; j < nums.length-1; j++) {
					if(nums[i]+nums[j]>0 || j+1>rightIdx) break;
					idx_tmp = Arrays.binarySearch(nums, j+1, rightIdx, -(nums[i]+nums[j]));
					if(idx_tmp<0) continue; //对于当前的e1 e2，若不存在符合的e3则更新下一个e2

					rightIdx = idx_tmp; //若e1+e2+e3=0，则将e3的下标作为新的rightIdx
					triplet = Arrays.asList(nums[i], nums[j], nums[rightIdx]);
					if(!list.contains(triplet)) list.add(triplet); //耗时
				}
			}
			return list;
		}

		//对于固定的e1 e2，不用binarySearch，而使用for循环寻找e3
		public List<List<Integer>> threeSum2(int[] nums) {
			int numsLen = nums.length;
			List<List<Integer>> list = new ArrayList<>();
			if(numsLen<3) return list;
			Arrays.sort(nums); //排序

			int sum12;
			int rightIdx;
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
							if(!list.contains(triplet)) list.add(triplet); //耗时
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

		//Recommend
		public List<List<Integer>> threeSum3(int[] nums) {
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
	}


	public static class Solution2 {
		//Method 1
		//这个方法太耗时，不能通过测试
		public List<List<Integer>> threeSum(int[] nums) {
			int numsLen = nums.length;
			List<List<Integer>> list = new LinkedList<>();
			if(numsLen<3) return list;

			//分组与排序
			ArrayList<Integer> negativeList = new ArrayList<>();
			ArrayList<Integer> positiveList = new ArrayList<>();
			for (int n: nums) {
				if(n<0) {
					negativeList.add(n);
				} else {
					positiveList.add(n);
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
						triplet = new ArrayList<>(Arrays.asList(e1, e2, e3));
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
						triplet = new ArrayList<>(Arrays.asList(e3, e1, e2));
						if(!list.contains(triplet)) list.add(triplet);
					}
				}
			}

			//搜索3元组：3个0
			if(positiveList.size()>=3) {
				if(positiveList.get(0)==0 && positiveList.get(1)==0 && positiveList.get(2)==0) {
					list.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
				}
			}
			return list;
		}

		//Method 2
		//勉强通过，效率极低
		public List<List<Integer>> threeSum2(int[] nums) {
			int numsLen = nums.length;
			List<List<Integer>> list = new LinkedList<>();
			if(numsLen<3) return list;

			//分组与排序
			int minNum = nums[0];
			int maxNum = nums[0];
			List<Integer> negativeList = new LinkedList<>();
			List<Integer> positiveList = new LinkedList<>();
			Set<Integer> negativeSet = new HashSet<>();
			Set<Integer> positiveSet = new HashSet<>();
			int nZeros = 0;
			for (int n: nums) {
				if(n<0) {
					negativeList.add(n);
					negativeSet.add(n);
				} else {
					positiveList.add(n);
					positiveSet.add(n);
					if(n==0) nZeros++;
				}
				if(maxNum<n) maxNum = n;
				if(minNum>n) minNum = n;
			}

			if(maxNum<0 || minNum>0) return list;
			if(positiveList.size()==0) return list;
			if(negativeList.size()==0 && positiveList.size()<3) return list;
			if(maxNum==0 && positiveList.size()>=3) {
				list.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
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
						triplet = new ArrayList<>(Arrays.asList(e1, e2, e3));
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
						triplet = new ArrayList<>(Arrays.asList(e3, e1, e2));
						Collections.sort(triplet);
						if(!list.contains(triplet)) list.add(triplet);
					}
				}
			}

			//搜索3元组：3个0
			if(nZeros>=3) {
				list.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
			}
			return list;
		}
	}


	public static class Solution3 {

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

			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < numsLen; i++) {
				map.put(nums[i], i);
			}

			int sum12, idx;
			List<Integer> triplet;
			for (int i = 0; i < numsLen-2; i++) {
				if(nums[i]>0) break;
				for (int j = i+1; j < numsLen-1; j++) {
					sum12 = nums[i]+nums[j];
					if(map.containsKey(-sum12)) {
						idx = map.get(-sum12);
						if(idx!=i && idx!=j) {
							triplet = Arrays.asList(nums[i], nums[j], -sum12);
							Collections.sort(triplet);
							if(!list.contains(triplet)) list.add(triplet);
						}
					}
				}
			}
			return list;
		}
	}


	public static void main(String[] args) {
		//int[] nums = {-1, 0, 1, 2, -1, -4};
		//int[] nums = {-1, 0, 1, 2, 0, -1, -4};
		//int[] nums = {-3,-3,0,-5};
		//int[] nums = {0,0,0};
		//int[] nums = {-2,-3,0,0,-2};

		//[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
		//int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};

		//[[-1,-4,5],[-2,-3,5]]
		//int[] nums = {-1,0,-4,-2,-3,5};

		//[[-1,-1,2],[-1,0,1]]
		//int[] nums = {-1,0,1,2,-1,-4};

		//[[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]
		int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};

		long t1 = System.nanoTime();
		ThreeSum_15.Solution1 obj = new ThreeSum_15.Solution1();
		List<List<Integer>> list = obj.threeSum3(nums);
		long t2 = System.nanoTime();

		System.out.println("Input array: "+Arrays.toString(nums));
		int[] sortedNums = nums.clone();
		Arrays.sort(sortedNums);
		System.out.println("sorted nums: "+Arrays.toString(sortedNums));
		System.out.println("Output list: "+list);
		System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
	}

}
