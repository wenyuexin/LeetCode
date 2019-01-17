package array;

import java.util.Arrays;

/** 
 * @author Apollo4634 
 * @creation 2019/01/15 23:01
 * 
 * No.16 3 Sum Closest
 * 
 * 解题思路：
 * 总体思路可以参考 No.15 Three Sum，都是先排序后遍历，
 * 区别在于15题需要即使找到了符合要求的三元组仍然需要继续遍历，
 * 而本题的目标是寻找sum值最接近target的三元组，
 * 有时候则可以使用continue或者break直接跳过循环，
 * 如果刚好等于target可以直接return
 * （具体可以参考class ThreeSum中的threeSum3方法）
 * 
 * 这里补充几点：
 * 假设三元组{e1,e2,e3}元素的下标分别是i j k，三者满足i<j<k
 * 假设numsLen=nums.length-1
 * 假设和target最接近的三元组的sum值为closestSum
 * 假设idx(e)表示元素e在数组nums中的下标
 * 
 * (A) 
 * 对于固定的i和j，对k进行循环遍历的目标是，
 * 在[j+1, rightIdx]区间内寻找是否存在某个值等e3=target-e1-e2
 * （这里，rightIdx是k的右界，初始状态为numsLen-1，
 * 后续遍历过程中视情况有可能减小，从而缩小搜索范围）
 * 
 * 遍历过程中，根据nums[k]和e3的大小关系，可以分为2种情况：
 * a.若nums[k]==e3，那么直接return target
 * b.若nums[k]!=e3，即数组nums中存在序列 
 * ... nums[k'-1], nums[k'] (e3) nums[k'+1] ...
 * 那么对k遍历时，差值diff = nums[k']-e3会存在一次变号，
 * 可以判断(e1+e2+nums[k'])和(e1+e2+nums[k'+1])之间哪个数更接近target
 * 
 * (B)关于A-b中的判断
 * 在实际上不一定同时存在比e3小的nums[k']和比e3大的nums[k'+1]，例如：
 * a. k'+1>rightIdx时自然就没有nums[k'+1]
 * b. 如果nums[j+1]>e3，即nums[j+1]至nums[rightIdx]之间的数都大于e3,
 * 那么就不存在比e3小的nums[k']，此时需要计算k=j+1时的sum值，
 * 即sum=nums[i]+nums[j]+nums[j+1]，然后判断是否可以更新closestSum
 * 
 * (C)关于rightIdx
 * k的范围，初步的想法是[j+1, numsLen-1]，即k的左界和上一个三元组有关，
 * 但是，分析发现在固定e1(i不变)的时候，k的右界也和上一个三元组有关
 * 具体如下：
 * 对于固定的e1(即i不变)，将e2更新为e2'(即j=j+1)时，e2变大(e2'>e2)，
 * 如果仍然要满足e1+e2+e3=target，那么e3的值必然要变小。
 * 因此，对于上一组e1 e2，如果存在nums[k']<e3<nums[k'+1]，
 * 那么e3的搜索范围收缩为[j+1, k']，也就是说rightIdx=k'
 * 
 * (D)关于直接i++和j++
 * a. 对于某个e1(下标为i)，如果nums[i]==nums[i+1]==e1，那么，
 * 以nums[i+1]为e1得到的三元组的集合包含了以nums[i]为e1得到的三元组的集合.
 * 依次类推，如果nums[i]==nums[i+1]==...==nums[i+I]，那么
 * 以nums[i]为e1得到的三元组的集合也包含了以nums[i+I]为e1得到的三元组的集合，
 * 因此，nums[i]为e1搜索后不需要再以nums[i+i'] (i'=1,2,...,I)为e1进行搜索.
 * b. 同理，对于固定的e1，如果nums[j]==nums[j+1]==...==nums[j+J]==e2，
 * 那么以nums[j]为e2得到的三元组的集合也包含了以nums[j+J]为e2得到的三元组的集合.
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
					if(nums[k]==e3) return target;
					if(k!=j+1 && k+1<=rightIdx && nums[k]==nums[k+1]) continue;
					
					if(nums[k]<e3 || k==j+1) {
						diff = nums[k]-e3;
						if(k+1<numsLen && (nums[k+1]-e3<-diff)) {diff = nums[k+1]-e3;}
						if(Math.abs(diff)<Math.abs(closestDiff)) closestDiff = diff;
						rightIdx = k; //更新k的右界
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
