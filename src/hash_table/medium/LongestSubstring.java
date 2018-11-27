package hash_table.medium;

import java.util.HashMap;

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
		int strLen = -1;
		//int j = 0;
		
		char c = ' ';
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0; i<s.length(); i++) {
			c = s.charAt(i);
			Character character = Character.valueOf(c);
			Integer integer = Integer.valueOf(i);
			
			//这里需要判断新来的char是否在keys中
			if (!set.contains(character)) { //如果不在
				map.put(character,integer);
				strLen++;
			} else { //如果在
				if(maxLen<map.size()) 
					maxLen = strLen;
				//更新map
				map = new HashMap<Character,Integer>();
				strLen = 0;
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
