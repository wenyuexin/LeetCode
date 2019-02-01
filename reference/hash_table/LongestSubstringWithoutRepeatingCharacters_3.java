package hash_table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author -
 * @date 2019/02/01
 * @problem 3
 */

public class LongestSubstringWithoutRepeatingCharacters_3 {

	//Approach 1: Brute Force
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= n; j++)
				if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
		return ans;
	}	

	public boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if (set.contains(ch)) return false;
			set.add(ch);
		}
		return true;
	}


	//Approach 2: Sliding Window
	public int lengthOfLongestSubstring2(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}


	//Approach 3: Sliding Window Optimized - Recommend
	public int lengthOfLongestSubstring3(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>();//current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}


	//Approach 4: 16ms submission on leetcode
	public int lengthOfLongestSubstring4(String s) {
		int[] charArr = new int[127];
		for(int i=0;i<127;i++) {
			charArr[i] = -1;
		}

		int chrIdx = -1, idx = 0, maxSubLen = 0, curLen = 0;        
		char[] arr = s.toCharArray();

		while( idx < arr.length )
		{            
			chrIdx = charArr[arr[idx]];            
			curLen++;//current best

			// Charecter prest in sliding window
			if( chrIdx != -1 && chrIdx > idx - curLen ) {
				curLen = idx - chrIdx;
			} else { // if charecter has not been encountered
				maxSubLen = Math.max(maxSubLen, curLen);                             
			}
			charArr[arr[idx]] = idx++;
		}
		return maxSubLen;
	}
}
