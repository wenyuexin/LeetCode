package string;

//import java.nio.charset.Charset;

/**
 * @author Apollo4634
 * @creation 2018/12/04
 * 
 * No.5 Longest Palindromic Substring - 最长回文子串
 * 
 * 理解错题目了，以下解答错误
 * 
 * 注：以下解答的是 求字符串中距离最远的字符对之间的子字符串
 * 当输入字符串的长度小于2时返回原字符串
 */

public class LongestPalindromicSubstring2 {
	
	/* 用于测试的函数 */
	
	//打印数组
	static void print(int[] arr) { 
		for (int i = 0; i < arr.length-1; i++) {
			System.out.print(arr[i]+" ");
		}
		if(arr.length>0) {			
			System.out.println(arr[arr.length-1]);
		}
	}
	
	/* My Solution */
	public String longestPalindrome(String s) {
		if(s.length() < 2) return s;
		
		int idx_right = 0;
		int maxLen = 0;
		int[] arr_leftIdx = new int[256];
		boolean[] arr_exist = new boolean[256]; 
		//LongestPalindromicSubstring.print(arr_leftIdx);
		
		int ch = -1;
		for (int i = 0; i < s.length(); i++) {
			ch = (int) s.charAt(i);
			
			if(!arr_exist[ch]) {
				arr_leftIdx[ch] = i;
				arr_exist[ch] = true;
			} else {
				if(i-arr_leftIdx[ch]+1 > maxLen) {
					maxLen = i-arr_leftIdx[ch]+1;
					idx_right = i;
				}
			}
		}
		
		int idx_left = arr_leftIdx[(int)s.charAt(idx_right)];
		String str = s.substring(idx_left, idx_right+1);
		
		return str;
	}
	
	
	public static void main(String[] args) {
		//System.out.println("当前JRE的版本号：" + System.getProperty("java.version")); 
        //System.out.println("当前JVM的默认字符集：" + Charset.defaultCharset()); 
        //System.out.println("asdf".substring(1,4));
		
		LongestPalindromicSubstring2 c = new LongestPalindromicSubstring2();
		//String s = "babad";
		//String s = "cbbd";
		String s = "abcda";
		System.out.println("input:  "+s);
		String str = c.longestPalindrome(s);
		System.out.println("output: "+str);
		
		
	}
}
