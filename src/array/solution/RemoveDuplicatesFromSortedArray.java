package array.solution;

import java.util.Arrays;

/** 
 * @author Apollo4634 
 * @create 2019/03/03
 * @problem 26
 * @see array.reference.RemoveDuplicatesFromSortedArray_26
 */

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		if (nums == null) return 0;
		if (nums.length < 2) return nums.length;
		int length = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i-1]) {
				nums[length] = nums[i];
				length += 1;
			}
		}
		return length;
	}
	
	
	public static void main(String[] args) {
		int[] arr = { 0,0,1,1,1,2,2,3,3,4 };
		System.out.println("Input:  "+Arrays.toString(arr));
		
		long t1 = System.nanoTime();
		RemoveDuplicatesFromSortedArray obj = 
				new RemoveDuplicatesFromSortedArray();
		int length = obj.removeDuplicates(arr);
		long t2 = System.nanoTime();
		
		System.out.println("Output: "+length);
		System.out.println("Output: "+Arrays.toString(arr));
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
