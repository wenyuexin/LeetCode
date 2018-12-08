package medium;

/** 
 * @author -
 * @creation 2018/12/08 22:12
 */

public class LongestPalindromicSubstring {
	int len = 0, maxLength = 0, start = 0;

	public String longestPalindrome(String s) {
		char[] arr = s.toCharArray();
		len = s.length();
		if (len <= 1)
			return s;
		for (int i = 0; i < len; i++) {
			i = helper(arr, i);
		}
		return s.substring(start, start + maxLength);
	}

	public int helper(char[] arr, int k) {
		int i = k - 1, j = k;
		while (j < len - 1 && arr[j] == arr[j + 1])
			j++;
		int nextCenter = j++;
		while (i >= 0 && j < len && arr[i] == arr[j]) {
			i--;
			j++;
		}
		if (j - i - 1 > maxLength) {
			maxLength = j - i - 1;
			start = i + 1;
		}
		return nextCenter;
	}
}
