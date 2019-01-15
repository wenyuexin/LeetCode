package hash_table;

/** 
 * @author Apollo4634 
 * @creation 2018/11/26
 *
 * No.3 Longest Substring Without Repeating Characters
 * 
 */

public class LongestSubstring3 {
	
	public int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		int strLen = 0;
		int idx_left = 0;
		int idx_tmp = 0;
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			String str = s.substring(0, i);
			idx_tmp = str.lastIndexOf(c);
			if(idx_tmp < idx_left) {
				strLen += 1;
				if(maxLen<strLen) maxLen = strLen;
			} else {
				strLen = i - idx_tmp;
				if(maxLen<strLen) maxLen = strLen;
				idx_left = idx_tmp + 1;
			}
		}
		return maxLen;
    }
	
	
	public static void main(String[] args) {
		//String str = "bbbbb";
		//String str = "abcabcbb"; //3
		//String str = "pwwkew"; //3
		//String str = "au";
		//String str = "aab";
		//String str = "a";
		String str = "tmmzuxt"; //5
		
		int len = new LongestSubstring3().lengthOfLongestSubstring(str);
		System.out.println(len);
	}
}
