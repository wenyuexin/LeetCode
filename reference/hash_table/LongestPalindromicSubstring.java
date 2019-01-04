package hash_table;


/** 
 * @author -
 * @creation 2018/12/08 22:12
 */

public class LongestPalindromicSubstring {
	int len = 0, maxLength = 0, start = 0;

	public String longestPalindrome(String s) {
		char[] arr = s.toCharArray();
		len = s.length();
		if (len <= 1)
			return s;
		for (int i = 0; i < len; i++) {
			i = getNextCenterAndProcess(arr, i);
		}
		return s.substring(start, start + maxLength);
	}

	public int getNextCenterAndProcess(char[] arr, int ctr) {
		int left = ctr - 1;
		int right = ctr;
		while (right < len - 1 && arr[right] == arr[right + 1]) {
			right++;
		}
		int nextCenter = right++;
		while(left >= 0 && right < len && arr[left] == arr[right]) {
			left--;
			right++;
		}
		if (right - left - 1 > maxLength) {
			maxLength = right - left - 1;
			start = left + 1;
		}
		return nextCenter;
	}
	
	
	public static void main(String[] args) {
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
		String str = new LongestPalindromicSubstring().longestPalindrome(s);
		long t2 = System.nanoTime();
		System.out.println("output: "+str);
		System.out.printf("time: "+(t2-t1)/1.0E6+" ms");
		
	}
}
