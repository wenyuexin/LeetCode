package array.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/** 
 * 本题的目标是找到nums中所有满足e1+e2+e3+e4=target的四元组，
 * 基本思路请参考No.15 Three Sum
 * 
 * 和Three Sum问题类似，这里仍然是先排序后遍历的方法，
 * 在未注明时，以下叙述中的数组nums均指排序后的nums，
 * 假设e1,e2,e3,e4在nums中的下标为i1,i2,i3,i4(i1<i2<i3<i4)
 * 假设数组nums的长度为numsLen
 * 
 * 遍历需要搜索所有可能满足条件的四元组，e1和e2的更新方式较为简单，
 * 元素e1的下标i1从0至numsLen-4逐步递增，在这层for循环内，
 * 元素e2的下标i2从i1+1至numsLen-3逐步递增，而在第2层循环内 
 * 元素e3和元素e4(i3和i4在区间[i2+1,numsLen-1]之间)作为左右端点逐步向中间收缩
 * 遍历搜索中，这里根据一些特殊情况使用while循环跳过了一些不必要的搜索
 * 
 * @author Apollo4634 
 * @create 2019/01/22 23:01
 * @problem 18
 * @see array.reference.FourSum_18
 */

public class FourSum {

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

	
	public static void main(String[] args) {
		//int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		//int target = 0;

		//[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		
		long t1 = System.nanoTime();
		FourSum obj = new FourSum();
		List<List<Integer>> list = obj.fourSum(nums, target);
		long t2 = System.nanoTime();

		System.out.println("Input array:  "+Arrays.toString(nums));
		System.out.println("Input target: "+target);
		System.out.println("Output list:  "+list);
		System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
	}
}
