package hash_table;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		if (s.length() < wordLen) return null;
		
		Set<String> set = new HashSet<>(Arrays.asList(words));
		for (int i = 0; i < words.length-wordLen; ) {
			if (set.contains(s.substring(i, wordLen))) i += wordLen;
			else i += 1;
		}
		
		
		return null;
	}
}
