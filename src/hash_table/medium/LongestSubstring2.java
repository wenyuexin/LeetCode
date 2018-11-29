package hash_table.medium;

import java.util.HashMap;

/** 
 * @author Apollo4634 
 * @creation 2018/11/26
 *
 * Tilte: Longest Substring Without Repeating Characters
 * 
 * Runtime: 24 ms, faster than 91.82% of Java online submissions
 * Runtime: 42 ms, faster than 43.79% of Java online submissions
 * Runtime: 34 ms, faster than 59.28% of Java online submissions
 */

public class LongestSubstring2 {
	
	public static int lengthOfLongestSubstring(String s) {
		Integer one = Integer.valueOf(1);
		Integer maxLen = Integer.valueOf(0);
		Integer strLen = Integer.valueOf(0);
		Integer idx_left = Integer.valueOf(0);
		Integer idx_tmp = Integer.valueOf(0);
		
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0; i<s.length(); i++) {
			Character character = Character.valueOf(s.charAt(i));
			Integer integer = Integer.valueOf(i);
			
			if (!map.containsKey(character)) { //判断char是否在keys中
				strLen += one;
			} else { //如果在
				idx_tmp = map.get(character);
				if(idx_tmp<idx_left) {
					strLen += one;
				} else {
					strLen = integer - idx_tmp;
					idx_left = idx_tmp + one;
				}
			}
			map.put(character,integer);//更新map				
			if(maxLen<strLen) maxLen = strLen;
		}
		return maxLen;
    }
	
	
	public static void main(String[] args) {		
		//String str = "bbbbb";
		//String str = "abcabcbb";
		//String str = "pwwkew";
		//String str = "au";
		//String str = "aab";
		//String str = "a";
		String str = "tmmzuxt";
		int len = LongestSubstring2.lengthOfLongestSubstring(str);
		System.out.println(len);
	}
}
