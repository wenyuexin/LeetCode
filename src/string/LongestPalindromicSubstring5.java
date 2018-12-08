package string;


/** 
 * @author Apollo4634 
 * @creation 2018/12/06 19:12
 * 
 * No.5 Longest Palindromic Substring
 * 
 * Runtime: 118 ms, faster than 19.16% of Java online submissions
 */

/**
 * 解题思路：
 * 和之前的解法差不多，区别在于：
 * 第一，预先将输入的字符串s反转为s2
 * 然后使用String类中的regionMatches方法比较子串，
 * 而之前的方法是，使用自定义的for循环实现该功能
 * 第二，按子串从长到短顺序比较，得到回文子串后直接退出搜索
 * 
 * 其实在个人主机上的运行时间不到0.1ms，运行部分testcase的
 * 时间也就2ms以内，不知道为什么提交后的运行时间要那么长，无语
 */

public class LongestPalindromicSubstring5 {
	
	//Solution
	public String longestPalindrome(String s) {
		int sLen = s.length();
		if(sLen < 2) return s;
		
		String s2 = new StringBuilder(s).reverse().toString();
		//System.out.println("reverse: "+s2);
		
		String str = "";
		int ooffset = 0;
		int maxRange = 0;
		
		DoSearch:
		for (int iLen = sLen; iLen>0; iLen--) {
			maxRange = sLen-iLen;
			for (int toffset = 0; toffset <= maxRange; toffset++) {
				ooffset = maxRange - toffset;
				if(s.regionMatches(toffset, s2, ooffset, iLen)) {
					str = s.substring(toffset, toffset+iLen);
					break DoSearch;
				}
			}
		}
		return str;
	}
	
	
	public static void main(String[] args) {
		LongestPalindromicSubstring5 palindrome = new LongestPalindromicSubstring5();
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
