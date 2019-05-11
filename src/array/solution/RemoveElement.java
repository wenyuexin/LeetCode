package array.solution;

import array.reference.RemoveElement_27;

import java.util.Arrays;

/** 
 * @author Apollo4634 
 * @create 2019/03/04
 * @problem 27
 * @see array.reference.RemoveElement_27
 */

public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		if (nums == null) return 0;
		int length = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[length] = nums[i];
				length += 1;
			}
		}
		return length;
	}
	
	
	public static void main(String[] args) {
		int[] arr = { 0,0,3,1,3,1,1,2,2,3,3,4 };
		int val = 3;
		System.out.println("Input:  "+Arrays.toString(arr));
		System.out.println("Input:  "+val);
		
		long t1 = System.nanoTime();
		RemoveElement obj = new RemoveElement();
		int length = obj.removeElement(arr, val);
		long t2 = System.nanoTime();
		
		System.out.println("Output: "+length);
		System.out.println("Output: "+Arrays.toString(arr));
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
