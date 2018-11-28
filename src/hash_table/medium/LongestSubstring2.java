package hash_table.medium;

import java.util.LinkedHashMap;

/** 
 * @author Apollo4634 
 * @creation 2018/11/26
 *
 * Tilte: Longest Substring Without Repeating Characters
 * 
 * Runtime: 
 */

public class LongestSubstring2 {
	
	public static int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		int strLen = 0;
		Integer idx_left = Integer.valueOf(0);
		Integer idx_tmp = null;
		
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
		//Set<Character> set = map.keySet();
		
		for(int i=0; i<s.length(); i++) {
			Character character = Character.valueOf(s.charAt(i));
			Integer integer = Integer.valueOf(i);
			
			//set = map.keySet();
			if (!map.containsKey(character)) { //判断char是否在keys中, 如果不在
				map.put(character,integer);
			} else { //如果在
				if(maxLen<map.size()) maxLen = map.size();
				idx_tmp = map.get(character);
				
				if(idx_tmp<idx_left) {
					map.put(character,integer);//更新map
				} else {
					strLen = i - idx_tmp.intValue();
					if(maxLen<strLen) maxLen = strLen;
					idx_left = idx_tmp + 1;
					
					map.put(character,integer);//更新map
				}
				
				
				System.out.println("test");
			}
		}
		
		strLen = s.length() - idx_tmp.intValue();
		if(maxLen<strLen) maxLen = strLen;
		return maxLen;
    }
	
	
	public static void main(String[] args) {
		//String str = "bbbbb";
		//String str = "abcabcbb";
		String str = "pwwkew";
		//String str = "au";
		//String str = "aab";
		//String str = "a";
		int len = LongestSubstring2.lengthOfLongestSubstring(str);
		System.out.println(len);
	}
}
