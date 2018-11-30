package array.hard;

/**
 * @author Apollo4634
 * @creation 2018/11/30
 * 
 * No.4 Median of Two Sorted Arrays
 * 
 * 
 * 
 */
public class MedianOfTwoSortedArrays {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median = 0;
		int len1 = nums1.length;
		int len2 = nums2.length;
		int minLen = Math.min(len1, len2);
		int e2 = (int) Math.log(minLen);
		int pow2 = (int) Math.pow(2, e2);
		
		double s = (len1+len2)/2.0;
		
		int idx1 = 0;
		int idx2 = 0;
		
		int idx1_tmp = 0;
		int idx2_tmp = 0;
		//int num1 = 0;
		//int num2 = 0;
		
		int offset = 0;
		while(e2 > 0) {
			offset = pow2/2;
			idx1_tmp = idx1 + offset;
			idx2_tmp = idx2 + offset;
			
			if(nums1[idx1_tmp] < nums2[idx2_tmp]) {
				idx1 = idx1_tmp;
			} else {
				idx2 = idx2_tmp;				
			}
		}
		
		int n1 = minLen - idx1;
		int n2 = minLen - idx2;
		
		
		
		
		return median;
	}
	
	
	public static void main(String[] args) {
		
	}
	
}
