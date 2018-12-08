package string;

/** 
 * @author Apollo4634 
 * @creation 2018/12/08 22:12
 * 
 * No.5 Longest Palindromic Substring
 * Runtime: 121 ms, faster than 18.79% of Java online submissions
 * Runtime: 117 ms, faster than 19.35% of Java online submissions
 * 
 * 感觉leetcode的Runtime不太准确，参考意义不大，下次就不管这个了
 */

public class LongestPalindromicSubstring6 {

	//Solution
	public String longestPalindrome(String s) {
		int sLen = s.length();
		if(sLen < 2) return s;
		
		char[] chArr = s.toCharArray();
		int maxRange = 0;
		boolean flag = false;
		int left, right, len_half;
		for (int iLen = sLen; iLen>1; iLen--) {
			maxRange = sLen-iLen;
			for (int offset=0; offset<=maxRange; offset++) {
				flag = true;
				left = maxRange-offset;
				right = left+iLen-1;
				len_half = iLen/2;
				for (int i=0; i<len_half; i++) {
					if(chArr[left+i]!=chArr[right-i]) {
						flag=false; 
						break;
					}
				}
				if(flag) {
					return s.substring(maxRange-offset, maxRange-offset+iLen);
				}
			}
		}
		return String.valueOf(chArr[0]);
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring6 palindrome = new LongestPalindromicSubstring6();
		//String s = "babad";
		//String s = "cbbd";
		//String s = "abcda";
		//String s = "abcba";
		//String s = "abcdaadcb";
		//String s = "aaaabaaa";
		//String s = "ac";
		String s = "acdfghertysdarveartb";
		
		System.out.println("input:  "+s);
		long t1 = System.nanoTime();
		String str = palindrome.longestPalindrome(s);
		long t2 = System.nanoTime();
		System.out.println("output: "+str);
		System.out.printf("time: "+(t2-t1)/1.0E6+" ms");
		
	}
}
