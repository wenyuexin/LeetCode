package string;


/** 
 * @author Apollo4634 
 * @creation 2018/12/06 19:12
 * 
 * No.5 Longest Palindromic Substring
 * 
 */

/**
 * 新的解题思路：
 * 
 * 
 *
 */
public class LongestPalindromicSubstring5 {
	
	//Functions for test
	
	//打印数组
	static void print(int[] arr) { 
		for (int i = 0; i < arr.length-1; i++) {
			System.out.print(arr[i]+" ");
		}
		if(arr.length>0) {			
			System.out.println(arr[arr.length-1]);
		}
	}
	
	//Solution
	public String longestPalindrome(String s) {
		int sLen = s.length();
		if(sLen < 2) return s;
		
		int[] n_pair = new int[2*sLen-1];
		int[] maxStrLen_half = new int[2*sLen-1];
		
		int[][] charArr = new int[256][sLen];
		int[] nArr = new int[256];
		
		//int firstChar = s.charAt(0);
		int ch = -1;
		for (int i = 0; i < sLen; i++) {
			ch = s.charAt(i);
			charArr[ch][nArr[ch]] = i;
			nArr[ch]++;
		}
		
		for (int i = 0; i < 256; i++) {
			
		}
		
		
		
		
		
		return "";
	}
	
	
	public static void main(String[] args) {
		LongestPalindromicSubstring5 palindrome = new LongestPalindromicSubstring5();
		//String s = "babad";
		//String s = "cbbd";
		//String s = "abcda";
		//String s = "abcba";
		String s = "abcdaadcb";
		//String s = "aaaabaaa";
		//String s = "ac";
		System.out.println("input:  "+s);
		long t1 = System.nanoTime();
		String str = palindrome.longestPalindrome(s);
		long t2 = System.nanoTime();
		System.out.println("output: "+str);
		System.out.println("time:  "+(t2-t1)/1000.0+" ms");
	}
}
