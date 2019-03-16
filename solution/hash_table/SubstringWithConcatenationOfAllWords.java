package hash_table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/** 
 * 施工中 ...
 * 
 * @author Apollo4634 
 * @create 2019/03/11
 * @problem 30
 * @see SubstringWithConcatenationOfAllWords_30
 */

public class SubstringWithConcatenationOfAllWords {
	
	public List<Integer> findSubstring(String s, String[] words) {
		if (s==null || words==null || words.length==0) return null;
		int wordLen = words[0].length();
		int totalLen = words.length * wordLen;
		if (s.length() < totalLen) return null;
		
		Map<String, Integer> map = new HashMap<String,Integer>();
		for (int i = 0; i < words.length; i++) {
			
		}

		for (int i = 0; i < s.length() - totalLen; i++) {
			
			for (int j = 0; j < words.length; j++) {
				if (!map.keySet().contains(s.substring(i, wordLen))) break;
				else {
					
				}
			}
		}
		
		return null;
	}
}
