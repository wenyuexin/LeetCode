package hash_table;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

/** 
 * @author Apollo4634 
 * @creation 2018/11/26
 *
 * No.3 Longest Substring Without Repeating Characters
 */


public class LongestSubstring2 {
	
	public static int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		//if(1==s.length()) return 1;
		
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
		Set<Character> set = map.keySet();
		
		for(int i=0; i<s.length(); i++) {
			Character character = Character.valueOf(s.charAt(i));
			Integer integer = Integer.valueOf(i);
			
			set = map.keySet();
			if (!set.contains(character)) { //判断char是否在keys中, 如果不在
				map.put(character,integer);
			} else { //如果在
				if(maxLen<map.size()) maxLen = map.size();
				Integer idx = map.get(character);
				
				Iterator<Entry<Character, Integer>> iter = map.entrySet().iterator(); 
				while (iter.hasNext()) { //注意，不能再迭代的同时直接对集合类进行修改
					Entry<Character, Integer> entry = iter.next();
					iter.remove();
					if(entry.getValue().equals(idx)) break;
				}
				map.put(character,integer);//更新map
				System.out.println("test");
			}
		}
		if(maxLen<map.size()) maxLen = map.size();
		return maxLen;
    }
	
	
	public static void main(String[] args) {
		//String str = "bbbbb";
		//String str = "abcabcbb";
		//String str = "pwwkew";
		//String str = "au";
		//String str = "aab";
		String str = "a";
		int len = LongestSubstring2.lengthOfLongestSubstring(str);
		System.out.println(len);
	}
}
