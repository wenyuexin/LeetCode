package array.solution;

import java.util.Arrays;

/**
 * 假定nums1的长度为len1，nums2的长度为len2
 * 同时假设nums1和nums2组合并排序后的数组为num3
 * 可以认为找中位数就是找到num3的前len_m=(len1+len2)/2个数arr[]
 * 类似的，如果通过循环每次都能找到剩余数字的前一半即可求解
 * 
 * 忽略部分细节，上述过程可以这样处理：
 * 通过循环依次寻找，假设某次循环中已经找到了n0个符合的数，
 * 其中，nums1中有idx1+1个，nums2中有idx2+1个
 * 那么还剩余n_left=len_m-n0个数，这里采用一种折半的方法
 * 从idx1+1开始，在nums1剩余的数中找n_left/2个数arr1[]，最后一个为a
 * 从idx2+1开始，在nums2剩余的数中找n_left/2个数arr2[]，最后一个为b
 * 显然，如果arr1[]和arr2[]都是arr的一部分，那么就已经找到了len_m个数
 * 
 * 但是通常情况下，只可以推断出arr1[]或者arr2[]的二者之一属于arr[]
 * 具体过程如下：
 * 如果a<b，那么arr1[]必然是arr[]的一部分
 * 如果a>b，那么arr2[]必然是arr[]的一部分
 * 如果a=b，那么arr1[]和arr2[]都是arr[]的一部分(n_left等于1的情况除外)
 * 这可以通过反证法来分析，此处略过
 * 
 * 综上，每次循环都能找到n_left/2个数（剩余要找的数的一半）
 * 当然，考虑到两个数组长度可能不同，为了方便假设len1<len2，
 * 当idx1+1超过了len1时候要适当的将n_left/2变小，防止越界，
 * 同时可以通过推断，直接在nums2中找出剩余的n_left个数
 * 上述方法复杂度符合O(log(len1+len2))的要求
 * 
 * @author Apollo4634
 * @create 2018/11/30
 * @problem 4
 * @see array.reference.MedianOfTwoSortedArrays_4
 */

public class MedianOfTwoSortedArrays_4 {
	
	//for test
	static double getMedian(int[] nums1, int[] nums2) {
		double median;

		int newLength = nums1.length+nums2.length;
		int[] arr = Arrays.copyOf(nums1, newLength);
		for(int i=0; i<nums2.length; i++) {
			arr[nums1.length+i] = nums2[i];
		}
		Arrays.sort(arr);
		
		median = arr[(int) Math.floor((arr.length-1)/2.0)];
		median += arr[(int) Math.ceil((arr.length-1)/2.0)];
		median /= 2.0;
		return median;
	}
	
	//Solution
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median = 0;
		int len1 = nums1.length;
		int len2 = nums2.length;
		if(len1==0 && len2==0) return 0;
		
		//下面这一小段还可以改进，
		//判断nums1整体都大于或者小于nums2的时候（相当于已经组合并且排好序了）
		//这时就可以直接推断出中位数，大概这么写：
		// if(nums1[0]>nums2[len2-1]) {...} 
		// if(nums2[0]>nums1[len1-1]) {...}
		
		if(len1>len2) {
			int[] nums_tmp = nums1;
			nums1 = nums2;
			nums2 = nums_tmp;
			len1 = nums1.length;
			len2 = nums2.length;
		}
		
		if(len1==0) {
			median += nums2[(int) Math.floor((len2-1)/2.0)];
			median += nums2[(int) Math.ceil((len2-1)/2.0)];
			return median/2.0;
		}
		
		// if(nums1[0]>nums2[len2-1]) {...} 
		// if(nums2[0]>nums1[len1-1]) {...}

		double len_median = (len1+len2)/2.0;
		int len_m1 = (int) Math.ceil(len_median);
		boolean isOddLength = (len_median != len_m1);
		
		int maxIdx1 = len1 - 1;
		int maxIdx_m1_tmp = len_m1 - 2;
		int idx1 = -1;
		int idx2 = -1;
		int idx1_tmp = -1;
		int idx2_tmp = -1;
		int offset = 1;
		boolean flag = true;
		while(offset > 0) {
			offset = maxIdx_m1_tmp-idx1-idx2;
			if(offset>0) {
				if(idx1 == maxIdx1) { 
					idx2 = maxIdx_m1_tmp-maxIdx1; 
					break;
				}  
				if(offset>1) {
					offset = (offset >> 1);
				} else {
					flag = false;
				}
			} else {
				break;
			}

			if(offset <= maxIdx1 - idx1) { 
				idx1_tmp = idx1 + offset;
				idx2_tmp = idx2 + offset;
			} else {
				idx1_tmp = maxIdx1;
				idx2_tmp = idx2 + (maxIdx1 - idx1);
			}
				
			if(nums1[idx1_tmp] < nums2[idx2_tmp]) {
				idx1 = idx1_tmp;
			} else if(nums1[idx1_tmp] > nums2[idx2_tmp]) {
				idx2 = idx2_tmp;				
			} else {
				idx1 = idx1_tmp;
				if(flag) { idx2 = idx2_tmp; }				
			}
		}
		
		if(idx1==-1) {
			median = nums2[idx2];
		} else if(idx2==-1) {
			median = nums1[idx1];
		} else {			
			median = Math.max(nums1[idx1], nums2[idx2]);
		}
		
		if(!isOddLength) { //两个数的均值
			if(idx1+1>maxIdx1) {
				median += nums2[idx2+1];
			} else {
				median += Math.min(nums1[idx1+1], nums2[idx2+1]);
			}
			median /= 2.0;
		}
		return median;
	}
	
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {1};
		int[] nums2 = new int[] {2,3};
		MedianOfTwoSortedArrays_4 obj = new MedianOfTwoSortedArrays_4();
		double median = obj.findMedianSortedArrays(nums1, nums2);
		
		System.out.println("nums1: "+Arrays.toString(nums1));
		System.out.println("nums2: "+Arrays.toString(nums2));
		
		double median2 = MedianOfTwoSortedArrays_4.getMedian(nums1, nums2);
		System.out.println("median: "+median);
		System.out.println("median: "+median2);
	}
}
