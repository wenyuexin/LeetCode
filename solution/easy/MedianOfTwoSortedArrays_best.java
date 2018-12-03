package easy;

import java.util.Arrays;

/**
 * @author Apollo4634
 * @creation 2018/11/30
 * 
 * No.4 Median of Two Sorted Arrays
 * 
 * Best answer
 * Runtime: 23 ms
 */

public class MedianOfTwoSortedArrays_best {
	
	//用于测试的函数
	static void print(String s, int[] arr) {
		System.out.print(s);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	static double getMedian(int[] nums1, int[] nums2) {
		double median = 0;

		int newLength = nums1.length+nums2.length;
		int[] arr = Arrays.copyOf(nums1, newLength);
		for(int i=0; i<nums2.length; i++) {
			arr[nums1.length+i] = nums2[i];
		}
		Arrays.sort(arr);
		
		MedianOfTwoSortedArrays_best.print("arr: ",arr);
		median = arr[(int) Math.floor((arr.length-1)/2.0)];
		median += arr[(int) Math.ceil((arr.length-1)/2.0)];
		median /= 2.0;
		return median;
	}
	
	//Answer
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len = nums1.length + nums2.length;
		int [] merge = new int[len];
		int firstIndex = 0;
		int secondIndex = 0;
		for(int i=0;i<len;i++) {
			if(firstIndex < nums1.length && secondIndex < nums2.length) {
				if(nums1[firstIndex] <= nums2[secondIndex]) {
					merge[i] = nums1[firstIndex];
					firstIndex ++;
				}else {
					merge[i] = nums2[secondIndex];
					secondIndex ++;
				}
			}else if(firstIndex == nums1.length) {
				merge[i] = nums2[secondIndex];
				secondIndex ++;
			}else {
				merge[i] = nums1[firstIndex];
				firstIndex ++;
			}	
		}
		if(len%2 ==1) {
			return merge[len/2];
		}else {
			return ((double) merge[len/2] + (double) merge[len/2-1] )/2;
		}
	}
	
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {1};
		int[] nums2 = new int[] {2,3};
		MedianOfTwoSortedArrays_best m = new MedianOfTwoSortedArrays_best();
		double median = m.findMedianSortedArrays(nums1, nums2);
		
		MedianOfTwoSortedArrays_best.print("nums1: ",nums1);
		MedianOfTwoSortedArrays_best.print("nums2: ",nums2);
		System.out.println("median: "+
				MedianOfTwoSortedArrays_best.getMedian(nums1, nums2));
		System.out.println("median: "+median);
		
		//MedianOfTwoSortedArrays.print(nums1);
		//MedianOfTwoSortedArrays.print(nums2);
	}
	
}