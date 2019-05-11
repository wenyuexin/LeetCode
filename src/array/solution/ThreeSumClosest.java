package array.solution;

import java.util.Arrays;

/**
 * @author Apollo4634
 * @create 2019/01/31
 * @problem 16
 * @see array.reference.ThreeSumClosest_16
 */

public class ThreeSumClosest {
	
	/*My Solution*/
	private int[] calcSearchRange(int[] nums, int target) {
		int numsLen = nums.length;
		int minAbsDiff = Integer.MAX_VALUE;
		if(numsLen<=6) return new int[] {0,numsLen-1,minAbsDiff,0};
		
		int begin=0, diff;
		int tmp = nums[numsLen-2]+nums[numsLen-1]-target;
		for (int i = 0; i < numsLen-2; i++) {
			diff = nums[i]+tmp;
			if(diff==0) return new int[] {0,0,0,1};
			if(diff<0) { minAbsDiff=diff; } 
			else { begin=i; break; }
		}
		
		int end=numsLen-1;
		int tmp2 = nums[begin]+nums[begin+1]-target;
		for (int i = numsLen-1; i > begin+1; i--) {
			diff = nums[i]+tmp2;
			if(diff==0) return new int[] {0,0,0,1};
			if(diff>0) { if(Math.abs(diff)<Math.abs(minAbsDiff)) minAbsDiff=diff; } 
			else { end=i; break; }
		}
		return new int[] {begin,end,minAbsDiff,0};
	}
			
	public int threeSumClosest(int[] nums, int target) {
		int numsLen = nums.length;
		if(numsLen<4) {
			int closestSum = 0;
			for (int num: nums) closestSum+=num;
			return closestSum;
		}
		Arrays.sort(nums); //排序
		
		//确定搜索范围
		int[] ret = calcSearchRange(nums, target);
		if(ret[3]==1) return target;
		int begin=ret[0], end=ret[1], minAbsDiff=ret[2];
		
		//开始搜索并计算
		int i2, i3, e2e3, diff;
		for (int i1 = begin; i1 < end-1; i1++) {
			i2 = i1+1;
			i3 = end;
			e2e3 = target-nums[i1];
			
			diff = nums[i2]+nums[i2+1]-e2e3;
			if(diff>=0 && Math.abs(diff)<Math.abs(minAbsDiff)) {
				minAbsDiff=diff; break;
			}
			diff = nums[i3]+nums[i3-1]-e2e3;
			if(diff<0 && Math.abs(diff)<Math.abs(minAbsDiff)) {
				minAbsDiff=diff; continue;
			}
			
			while(i2<i3) { //twoSumClosest
				diff = nums[i2] + nums[i3] - e2e3;
				if(diff==0) return target;
				if(Math.abs(diff)<Math.abs(minAbsDiff)) minAbsDiff=diff;
				
				if(diff<0) { i2++; while(i2<i3 && nums[i2]==nums[i2-1]) i2++; } 
				else { i3--; while(i2<i3 && nums[i3]==nums[i3+1]) i3--; }
			}
			while(i1<end-1 && nums[i1+1]==nums[i1]) i1++;
		}
		return target + minAbsDiff;
	}
	
	
	public static void main(String[] args) {
		//int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		//int target = 9;

		int[] nums = {-1,2,1,-4};
		int target = 1;

		//int[] nums = {1,1,1,1};
		//int target = 1;
		
		//int[] nums = { -1,0,1,1,55 };
		//int target = 3;

		long t1 = System.nanoTime();
		ThreeSumClosest obj = new ThreeSumClosest();
		int closestSum = obj.threeSumClosest(nums, target);
		long t2 = System.nanoTime();

		System.out.println("input: array  = "+Arrays.toString(nums));
		System.out.println("input: target = "+target);
		System.out.println("output: "+closestSum);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
