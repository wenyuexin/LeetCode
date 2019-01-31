package array;

/**
 * @author Apollo4634
 * @date 2019/01/30
 * @problem 11
 */

public class ContainerWithMostWater_11 {

	/**
	 * Approach 1: Brute Force
	 * 
	 * In this case, we will simply consider the area for 
	 * every possible pair of the lines and 
	 * find out the maximum area out of those.
	 * 
	 * Time complexity : O(n^2). Calculating area for all [n(n-1)]/2 height pairs.
	 * Space complexity : O(1). Constant extra space is used. 
	 */
	public int maxArea(int[] height) {
		int maxarea = 0;
		for (int i = 0; i < height.length; i++)
			for (int j = i + 1; j < height.length; j++)
				maxarea = Math.max(maxarea, Math.min(height[i],height[j])*(j-i));
		return maxarea;
	}

	/**
	 * Approach 2: Two Pointer Approach
	 * The intuition behind this approach is that the area formed between the lines will always be limited by 
	 * the height of the shorter line. Further, the farther the lines, the more will be the area obtained.
	 * 
	 * We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines. 
	 * Futher, we maintain a variable maxareamaxarea to store the maximum area obtained till now. 
	 * At every step, we find out the area formed between them, 
	 * update maxareamaxarea and move the pointer pointing to the shorter line towards the other end by one step.
	 * 
	 * The algorithm can be better understood by looking at the example below:
	 * 1 8 6 2 5 4 8 3 7
	 * @see <a href="https://leetcode.com/problems/container-with-most-water/solution/">leetcode</a>
	 */
	public int maxArea2(int[] height) {
		int maxarea = 0, l = 0, r = height.length - 1;
		while (l < r) {
			maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r])
				l++;
			else
				r--;
		}
		return maxarea;
	}


	/**
	 * Approach 3: 3ms version
	 */
	public int maxArea3(int[] height) {
		int smax = 0;
		int l = 0;
		int r = height.length-1;
		int hl = height[l];
		int hr = height[r];
		while(l < r) {
			int minh = hl < hr ? hl : hr;
			int curs = minh * (r - l);
			if (curs > smax) {
				smax = curs;
			}
			if (minh == hl) {
				while(minh >= hl && l < r) {
					++l;
					hl = height[l];
				}
			} else {
				while(minh >= hr && l < r) {    
					--r;
					hr = height[r];
				}
			}
		}
		return smax;
	}

}
