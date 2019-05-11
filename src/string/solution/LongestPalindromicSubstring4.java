package string.solution;


/**
 * 解题思路：
 * 和之前的解法差不多，区别在于：
 * 第一，预先将输入的字符串s反转为s2
 * 然后使用String类中的regionMatches方法比较子串，
 * 而之前的方法是，使用自定义的for循环实现该功能
 * 第二，按子串从长到短顺序比较，得到回文子串后直接退出搜索
 * 
 * @author Apollo4634
 * @creation 2018/12/06
 * @problem 5
 */

public class LongestPalindromicSubstring4 {

	//Solution1
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

	//Solution2
	//此方法是对Solution1的修改：
	//主要使用char[]替代了String以及regionMatches
	public String longestPalindrome2(String s) {
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
		LongestPalindromicSubstring4 palindrome = new LongestPalindromicSubstring4();
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
		//String str = palindrome.longestPalindrome2(s);
		long t2 = System.nanoTime();
		System.out.println("output: "+str);
		System.out.printf("time: "+(t2-t1)/1.0E6+" ms");

	}
}
