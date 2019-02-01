package hash_table;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

/** 
 * @author Apollo4634 
 * @creation 2018/11/26
 * @problem 3
 */

public class LongestSubstringWithoutRepeatingCharacters2 {
	
	public int lengthOfLongestSubstring(String s) {
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
		String str = "tmmzuxt";
		
		long t1 = System.nanoTime();
		LongestSubstringWithoutRepeatingCharacters2 obj = 
			new LongestSubstringWithoutRepeatingCharacters2();
		int len = obj.lengthOfLongestSubstring(str);
		long t2 = System.nanoTime();

		System.out.println("Input:  "+str);
		System.out.println("Output: "+len);
		System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
	}
}
