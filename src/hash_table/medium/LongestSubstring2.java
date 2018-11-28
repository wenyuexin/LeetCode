package hash_table.medium;

import java.util.HashMap;

/** 
 * @author Apollo4634 
 * @creation 2018/11/26
 *
 * Tilte: Longest Substring Without Repeating Characters
 * 
 * Runtime: 33 ms, faster than 62.50% of Java online submissions for this.
 */

public class LongestSubstring2 {
	
	public static int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		int strLen = 0;
		Integer idx_left = Integer.valueOf(0);
		Integer idx_tmp = null;
		
		HashMap<Character,Integer> map = new HashMap<>();
		
		for(int i=0; i<s.length(); i++) {
			Character character = Character.valueOf(s.charAt(i));
			Integer integer = Integer.valueOf(i);
			
			if (!map.containsKey(character)) { //判断char是否在keys中, 如果不在
				map.put(character,integer);
				strLen += 1;
				if(maxLen<strLen) maxLen = strLen;
			} else { //如果在
				idx_tmp = map.get(character);
				if(idx_tmp<idx_left) {
					map.put(character,integer);//更新map
					strLen += 1;
					if(maxLen<strLen) maxLen = strLen;
				} else {
					strLen = i - idx_tmp.intValue();
					if(maxLen<strLen) maxLen = strLen;
					idx_left = idx_tmp + 1;
					 
					map.put(character,integer);//更新map
				}
				//System.out.println("test");
			}
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
