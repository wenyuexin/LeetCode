package hash_table.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/** 
 * 使用了2个Map，其中map用于保存words中各个单词出现的次数
 * 而tempMap用于记录s某区间内包含的words中的单词的次数
 * 
 * 如果s中出现了不在words中的单次，则跳过该区间
 * 否则将tempMap对应单次的计数加1
 * 
 * @author Apollo4634 
 * @create 2019/03/11
 * @problem 30
 * @see hash_table.reference.SubstringWithConcatenationOfAllWords_30
 */

public class SubstringWithConcatenationOfAllWords_30 {

	static class Solution {
		public List<Integer> findSubstring(String s, String[] words) {
			List<Integer> list = new LinkedList<>();
			if (s==null || words==null || words.length==0) return list;
			int wordLen = words[0].length();
			int totalLen = words.length * wordLen;
			if (s.length() < totalLen) return list;

			Map<String, Integer> map = new HashMap<>();
			for (String value : words) {
				if (!map.containsKey(value)) map.put(value, 1);
				else map.put(value, map.get(value) + 1);
			}

			int j;
			int max = s.length() - totalLen;
			Map<String, Integer> tempMap = new HashMap<>();
			for (int left = 0; left <= max; left++) {
				for (j = 0; j < words.length; j++) {
					int idx = left + j*wordLen;
					String word = s.substring(idx, idx + wordLen);
					if (!map.containsKey(word)) { tempMap.clear(); break; }
					int cnt = tempMap.getOrDefault(word, 0);
					if (cnt + 1 > map.get(word)) { tempMap.clear(); break; }
					tempMap.put(word, cnt+1);
				}
				if (j == words.length) list.add(left);
				tempMap.clear();
			}
			return list;
		}
	}
	
	
	public static void main(String[] args) {		
		String s = "barfoothefoobarman";
		String[] words = new String[] { "foo","bar" }; //0,9

		//String s = "wordgoodgoodgoodbestword";
		//String[] words = new String[] { "word","good","best","good" };//8

		//String s = "wordgoodgoodgoodbestword";
		//String[] words = new String[] { "word","good","best","word" };//[]
				
		System.out.println("Input:  "+s);
		System.out.println("Input:  "+Arrays.toString(words));

		long t1 = System.nanoTime();
		List<Integer> list = new Solution().findSubstring(s, words);
		long t2 = System.nanoTime();

		System.out.println("Output: "+list);
		System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
	}
}
