package hash_table;

import java.util.List;

/** 
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
		
		
		
		return null;
	}
}
