package hash_table;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author Apollo4634 
 * @creation 2018/11/26
 * @problem 3
 */

public class LongestSubstringWithoutRepeatingCharacters {
	
	//Solution
	public int lengthOfLongestSubstring(String s) {
		int maxLen=0, strLen=0, left=0, tmpIdx=0;
		
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) { //判断char是否在keys中
				strLen++;
			} else {
				tmpIdx = map.get(c);
				if(tmpIdx<left) {
					strLen++;
				} else {
					strLen = i - tmpIdx;
					left = tmpIdx + 1;
				}
			}
			map.put(c,i);//更新map				
			if(maxLen<strLen) maxLen=strLen;
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
		
		long t1 = System.nanoTime();
		LongestSubstringWithoutRepeatingCharacters obj = 
			new LongestSubstringWithoutRepeatingCharacters();
		int len = obj.lengthOfLongestSubstring(str);
		long t2 = System.nanoTime();
		
		System.out.println("Input:  "+str);
		System.out.println("Output: "+len);
		System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
	}
}
