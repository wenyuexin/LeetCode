package array;

/** 
 * @author Apollo4634 
 * @create 2019/03/03
 * @problem 26
 * @see RemoveDuplicatesFromSortedArray
 */

public class RemoveDuplicatesFromSortedArray_26 {

	//My approch
	public int removeDuplicates(int[] nums) {
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
}
