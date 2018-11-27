package hash_table.medium;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/** 
 * @author Apollo4634 
 * @creation 2018/11/26
 */

/**
 * Tilte: 
 * - Longest Substring Without Repeating Characters
 * 
 * Difficulty:
 * - Medium
 * 
 */


public class LongestSubstring {
	
	static boolean inTheSet(HashSet<Character> set, char c) {
		boolean flag = false;
		Character character = Character.valueOf(c);
		flag = set.contains(character);
		if(!flag) {
			set.add(character);
		}
		return flag;
	}
	
	public static int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		
		char c = ' ';
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
		Set<Character> set = map.keySet();
		
		for(int i=0; i<s.length(); i++) {
			c = s.charAt(i);
			Character character = Character.valueOf(c);
			Integer integer = Integer.valueOf(i);
			
			//这里需要判断新来的char是否在keys中
			set = map.keySet();
			if (!set.contains(character)) { //如果不在
				map.put(character,integer);
			} else { //如果在
				if(maxLen<map.size()) 
					maxLen = map.size();
				//更新map
				int idx = map.get(character);
				//map = new HashMap<Character,Integer>();
				
			}

		}
		
		
		return maxLen;
    }
	
	
	public static void main(String[] args) {
		String str = "bbbbb";
		int len = LongestSubstring.lengthOfLongestSubstring(str);
		System.out.println(len);
	}
}
