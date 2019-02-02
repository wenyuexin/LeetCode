package array;

/**
 * leetcode url:
 * https://leetcode.com/problems/container-with-most-water/solution/
 * 
 * Approach 1: Brute Force
 * Approach 2: Two Pointer Approach - Recommend
 * 
 * @author -
 * @create 2019/01/30
 * @problem 11
 */

public class ContainerWithMostWater_11 {

	/**
	 * Approach 1: Brute Force
	 * 
	 * Time complexity : O(n^2).
	 * Space complexity : O(1).
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
	 * 
	 * Algorithm
	 * The intuition behind this approach is that the area formed between the lines will 
	 * always be limited by the height of the shorter line. Further, the farther the lines, 
	 * the more will be the area obtained.
	 * 
	 * We take two pointers, one at the beginning and one at the end of the array 
	 * constituting the length of the lines. Futher, we maintain a variable maxareamaxarea 
	 * to store the maximum area obtained till now. At every step, we find out the area 
	 * formed between them, update maxareamaxarea and move the pointer pointing to 
	 * the shorter line towards the other end by one step.
	 * 
	 * Proof:
	 * Suppose we get n numbers Q1, Q2, ... , Qn-1, Qn.
	 * then we define the set Sk to contains k (the length) continued numbers
	 * (e.g. {Q1, Q2, ... Qk} or {Q3, Q4, ... , Qk+2} ...), 
	 * define Ski be the set start with Qi -- {Qi, Qi+1, ... , Qk+i-1} and 
	 * then the area of Ski (let it be A(Ski) ) is (min(Qi, Qk+i-1) * k).
	 * Suppose we start with Ski, when we minus one item, 
	 * we get two subsets S(k-1)i and S(k-1)(i+1), 
	 * if Qi < Qk+i-1, we can see A(S(k-1)i)=min(Qi, Qk+i-2)(k-1)< A(Ski)=Qik, 
	 * so we can determine any set contains Qi and length is smaller than k 
	 * will not be the candidate that area will surpass the prior max area. 
	 * So the candidates sets can only be found in the other subset 
	 * S(k-1)(i+1)--{Qi+1, Qi+2, ... , Qi+k-1}. 
	 * 
	 * Time complexity : O(n).
	 * Space complexity : O(1).
	 */
	public int maxArea2(int[] height) {
		int maxarea = 0, l = 0, r = height.length - 1;
		while (l < r) {
			maxarea = Math.max(maxarea, Math.min(height[l],height[r])*(r-l));
			if (height[l] < height[r])
				l++;
			else
				r--;
		}
		return maxarea;
	}
}
