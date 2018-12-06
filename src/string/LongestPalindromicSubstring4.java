package string;

//import java.nio.charset.Charset;

/**
 * @author Apollo4634
 * @creation 2018/12/06
 * 
 * No.5 Longest Palindromic Substring - 最长回文子串
 * 
 * Runtime: 39 ms, faster than 51.42% of Java online submissions
 * Runtime: 27 ms, faster than 58.78% of Java online submissions
 */

/**
 * 此方法是LongestPalindromicSubstring3的改进
 */

public class LongestPalindromicSubstring4 {
	
	//用于测试的函数
	
	//打印数组
	static void print(int[] arr) { 
		for (int i = 0; i < arr.length-1; i++) {
			System.out.print(arr[i]+" ");
		}
		if(arr.length>0) {			
			System.out.println(arr[arr.length-1]);
		}
	}
	
	//Answer
	public String longestPalindrome(String s) {
		int sLen = s.length();
		if(sLen < 2) return s;
		
		int maxRange = -1;
		int i_char = -1;
		char c1 = ' ';
		char c2 = ' ';
		double t = 0;

		double idx_StrCenter = 0;
		double idx_center = 0;		
		double strLen_half = 0;
		double maxStrLen_half = 0.5;
		for(int i_center=0; i_center<2*sLen-1; i_center++) {
			idx_center = 0.5*i_center;
			maxRange = Math.min((int)(idx_center+0.5), sLen-(int)(idx_center)-1);
			if(maxRange<(int)maxStrLen_half) break;
			
			strLen_half = (idx_center>(int)idx_center) ? 0 : 0.5;
			t = strLen_half;
			for(int i_range=0; i_range<maxRange; i_range++) {
				i_char = (i_range<(int)maxStrLen_half) ? ((int)maxStrLen_half-i_range-1) : i_range;
				
				c1 = s.charAt((int)(idx_center-i_char-0.5-t));
				c2 = s.charAt((int)(idx_center+i_char+0.5+t));
				if(c1==c2) {
					strLen_half += 1;
					if(maxStrLen_half<strLen_half) {
						maxStrLen_half = strLen_half;
						idx_StrCenter = idx_center;
					}
				} else {
					break;
				}
			}
		}
		
		//计算并返回最长回文子串
		String str = "";
		int idx_left = (int)(idx_StrCenter-maxStrLen_half+0.5); 
		str = s.substring(idx_left, idx_left+(int)(2*maxStrLen_half));
		return str;
	}
	
	
	public static void main(String[] args) {
		//System.out.println("当前JRE的版本号：" + System.getProperty("java.version")); 
        //System.out.println("当前JVM的默认字符集：" + Charset.defaultCharset()); 
		
		LongestPalindromicSubstring4 c = new LongestPalindromicSubstring4();
		String s = "babad";
		//String s = "cbbd";
		//String s = "abcda";
		//String s = "abcbk";
		//String s = "abcdaadcb";
		System.out.println("input:  "+s);
		String str = c.longestPalindrome(s);
		System.out.println("output: "+str);
	}
}
