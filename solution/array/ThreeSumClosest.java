package array;

import java.util.Arrays;
import java.util.List;

/** 
 * @author Apollo4634 
 * @creation 2019/01/15 23:01
 * 
 * No.16 3 Sum Closest
 * 
 * 解题思路：
 * 总体思路可以参考 No.15 Three Sum
 * 区别在于15题需要即使找到了符合要求的三元组仍然需要继续遍历，
 * 而本题的目标是寻找sum值最接近的三元组，如果刚好等于target可以直接return，
 * 有时候则可以使用continue或者break直接跳过循环
 * 
 * 具体可以参考class ThreeSum中的threeSum3方法，这里补充几点：
 * 
 * 假设e1 e2 e3的下标分别是i j k (三者满足i<j<k)
 * 假设numsLen=nums.length-1
 * 
 * (A) 
 * 对于固定的i和j，对k进行循环遍历的目标是，
 * 在[j+1, rightIdx]区间内寻找是否存在某个值等e3=target-e1-e2
 * （这里，rightIdx是k的右界，初始状态为nums.length-1，
 * 后续遍历过程中视情况有可能减小，从而缩小搜索范围）
 * 
 * 遍历过程中，根据nums[k]和e3的大小关系，可以分为2种情况：
 * a.若nums[k]==e3，那么直接 return target
 * b.若nums[k]!=e3，即数组nums中存在序列 
 * ... nums[k'-1], nums[k'] (e3) nums[k'+1] ...
 * 那么对k遍历时，差值diff = nums[k']-e3会存在一次变号，然后
 * 可以判断(e1+e2+nums[k'])和(e1+e2+nums[k'+1])这两个数哪个更接近target
 * （如果k'+1>nums.length-1就不用判断了）
 * 
 * (B)
 * 
 * 
 */

public class ThreeSumClosest {

	//Solution1
	public int threeSumClosest(int[] nums, int target) {
		int closestSum = 0;
		int numsLen = nums.length;
		if(numsLen<4) {
			for (int num: nums) { closestSum += num; }
			return closestSum;
		}
		Arrays.sort(nums); //排序

		int rightIdx, diff;
		int closestDiff = Integer.MAX_VALUE;
		for (int i = 0; i < numsLen-2; i++) { //e1
			rightIdx = numsLen-1;
			for (int j = i+1; j < numsLen-1; j++) { //e2
				int e3 = target - nums[i] - nums[j];
				for (int k = rightIdx; k > j; k--) { //e3
					if(nums[k]==e3) { return target; } 
					if(k!=j+1 && k+1<=rightIdx && nums[k]==nums[k+1]) continue;
					
					if(nums[k]<e3 || k==j+1) {
						diff = nums[k]-e3;
						if(k+1<numsLen && (nums[k+1]-e3<-diff)) {diff = nums[k+1]-e3;}
						if(Math.abs(diff)<Math.abs(closestDiff)) closestDiff = diff;
						rightIdx = k;
						break;
					}
				}
				while(j<numsLen-1 && nums[j+1]==nums[j]) j++;
			}
			while(i<numsLen-2 && nums[i+1]==nums[i]) i++;
		}
		return target + closestDiff;
	}


	public static void main(String[] args) {
		//int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		//int target = 9;

		//int[] nums = {-1,2,1,-4};
		//int target = 1;
		
		int[] nums = {1,1,1,1};
		int target = 1;

		long t1 = System.nanoTime();
		ThreeSumClosest obj = new ThreeSumClosest();
		int closestSum = obj.threeSumClosest(nums, target);
		long t2 = System.nanoTime();

		System.out.println("input:  array  = "+Arrays.toString(nums));
		System.out.println("input:  target = "+target);
		System.out.println("output:  "+closestSum);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
