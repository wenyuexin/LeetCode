package array;

/** 
 * @author Apollo4634 
 * @create 2019/03/04
 * @problem 27
 * @see RemoveElement
 */

public class RemoveElement_27 {

	//My approch
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
}
