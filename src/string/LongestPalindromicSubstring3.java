package string;

//import java.nio.charset.Charset;

/**
 * @author Apollo4634
 * @creation 2018/12/05
 * 
 * No.5 Longest Palindromic Substring - 最长回文子串
 * 
 * Runtime: 29 ms, faster than 56.71% of Java online submissions
 */

/**
 * 基本思路：
 * 由于回文字符串具有对称性，可以利用此特性进行搜索
 * 
 * 分为两种情况进行讨论：
 * 第一，以某个某个字符为中心向两边进行搜索
 * 第二，以两个相连字符中点为中心进行搜索向两边进行搜索
 * 如果发现关于中心点对称的两个字符不相同，则直接break
 * 
 * 两种情况在获取字符下标的时候有些许区别，
 * 简单起见，以下解法对上述情况分开讨论
 */

public class LongestPalindromicSubstring3 {
	
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
		
		int maxRange = -1;
		int strLen = 0;
		
		//以某个某个字符为中心进行搜索
		int idx_center = 0;
		int maxStrLen = 1;
		for(int i_center=0; i_center<sLen; i_center++) {
			strLen = 1;
			maxRange = Math.min(i_center, sLen-i_center-1);
			for(int i_range=0; i_range<maxRange; i_range++) {
				if(s.charAt(i_center-i_range-1)==s.charAt(i_center+i_range+1)) {
					strLen += 2;
					if(maxStrLen<strLen) {
						maxStrLen = strLen;
						idx_center = i_center;
					}
				} else {
					break;
				}
			}
		}
		
		//以两个相连字符中点为中心进行搜索
		int idx_center2 = -1;
		int maxStrLen2 = 0;
		for(int i_center=0; i_center<sLen-1; i_center++) {
			strLen = 0;
			maxRange = Math.min(i_center+1, sLen-i_center-1);
			for(int i_range=0; i_range<maxRange; i_range++) {
				if(s.charAt(i_center-i_range)==s.charAt(i_center+i_range+1)) {
					strLen += 2;
					if(maxStrLen2<strLen) {
						maxStrLen2 = strLen;
						idx_center2 = i_center;
					}
				} else {
					break;
				}
			}
		}
		
		//计算并返回最长回文子串
		String str = "";
		int idx_left = -1;
		if(maxStrLen>maxStrLen2) {
			idx_left = idx_center - (maxStrLen-1)/2;
			str = s.substring(idx_left, idx_left+maxStrLen);
		} else {
			idx_left = idx_center2 - maxStrLen2/2 + 1;
			str = s.substring(idx_left, idx_left+maxStrLen2);
		}
		return str;
	}
	
	
	public static void main(String[] args) {
		//System.out.println("当前JRE的版本号：" + System.getProperty("java.version")); 
        //System.out.println("当前JVM的默认字符集：" + Charset.defaultCharset()); 
        //System.out.println("asdf".substring(1,4));
		
		LongestPalindromicSubstring3 c = new LongestPalindromicSubstring3();
		//String s = "babad";
		//String s = "cbbd";
		//String s = "abcda";
		String s = "abcdaadcb";
		System.out.println("input:  "+s);
		String str = c.longestPalindrome(s);
		System.out.println("output: "+str);
		
	}
}
