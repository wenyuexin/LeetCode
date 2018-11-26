package hash_table.medium;

/** 
 * @author Apollo4634 
 * @creation 2018/11/26
 * 
 * Tilte: 
 * - Longest Substring Without Repeating Characters
 * 
 * Difficulty:
 * - Medium
 * 
 */


public class LongestSubstring {
	public static int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		int strLen = -1;
		//int j = 0;
		
		char c = ' ';
		char char_s = ' ';
		boolean flag = true;
		for(int i=0; i<s.length(); i++) {
			if (flag) {
				char_s = s.charAt(i);
				if (c != char_s) {
					c = char_s;
					strLen++;
				} else {
					//flag = false;
					if(maxLen<strLen+1) 
						maxLen = strLen+1;
					strLen = 0;
				}
			} else {
				
			}
		}
		
		
		return maxLen;
    }
	
	
	public static void main(String[] args) {
		String str = "abcabcbb";
		int len = LongestSubstring.lengthOfLongestSubstring(str);
		System.out.println(len);
	}
}
