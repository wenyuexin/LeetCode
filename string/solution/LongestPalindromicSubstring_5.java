package string.solution;


/**
 * 寻找最长回文子串
 *
 * Solution 1
 *
 * 由于回文字符串具有对称性，可以利用此特性进行搜索
 *
 * 分为两种情况进行讨论：
 * 第一，以某个某个字符为中心向两边进行搜索
 * 第二，以两个相连字符中点为中心进行搜索向两边进行搜索
 * 如果发现关于中心点对称的两个字符不相同，则直接break
 *
 * 改进点如下：
 * 之前的方法是以某个中心点向两端搜索，直到字符串s第一个或最后一个字符
 * 然而不许要每次都搜索至两端，存在两个情况可以直接跳出：
 * 
 * 假设输入字符串s的长度为sLen，某次搜索时的最长回文子串str的长度为maxStrLen
 * 
 * 第一，对于某个中心点idx，当最大可搜索长度小于当前最长回文子串的长度maxStrLen时，
 * 可以使用continue直接跳出当前搜索，换下一个中心点
 * 其中，最大可搜索长度maxRange为min(idx-0, sLen-idx)，这个公式不准确，
 * 大概的意思就是中心点以左的子串长度和中心点以右的子串长度的最小值。
 * 
 * 这样处理的原因是，最大可搜索长度maxRange小于maxStrLen说明，
 * 就算idx为中心的maxRange范围内子串是回文子串，其长度也小于当前最长回文子串的长度，
 * 因而没有必要进行多余的比较
 * 
 * 第二，确定某个中心点idx时，若通过上一条判断可以搜索时，
 * 之前的搜索方式是以idx为中心依次向两边进行搜索，
 * 但是其实可以直接从maxRange向中心点搜索，然后从maxRange向两端搜索
 * 
 * 这样处理的原因是，若maxRange范围内的子串是回文子串，
 * 那么必要会遍历范围内的所有字符对，但是可能存在以下情况：
 * 中心点idx附近几个字符构成回文子串，而接近maxRange处的字符对不相等
 *
 * 
 * @author Apollo4634
 * @create 2018/12/06
 * @problem 5
 * @see string.reference.LongestPalindromicSubstring_5
 */


public class LongestPalindromicSubstring_5 {

	public static class Solution {
		//Method 1
		public String longestPalindrome(String s) {
			int sLen = s.length();
			if(sLen < 2) return s;

			int maxRange, i_char;
			char c1, c2;
			double t;

			double idx_StrCenter = 0;
			double idx_center;
			double strLen_half;
			double maxStrLen_half = 0.5;
			for(int i_center=0; i_center<2*sLen-1; i_center++) {
				idx_center = 0.5*i_center;
				maxRange = Math.min((int)(idx_center+0.5), sLen-(int)(idx_center)-1);
				if(maxRange<(int)maxStrLen_half) continue;

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
			int idx_left = (int)(idx_StrCenter-maxStrLen_half+0.5);
			return s.substring(idx_left, idx_left+(int)(2*maxStrLen_half));
		}

		//Method 2
		public String longestPalindrome2(String s) {
			int sLen = s.length();
			if(sLen < 2) return s;

			char[] chArr = s.toCharArray();
			int maxRange;
			int strLen_half;
			String str;
			int idx_left = -1;

			//以某个某个字符为中心进行搜索
			int maxStrLen_half = 0;
			for(int i_center=0; i_center<sLen; i_center++) {
				strLen_half = 0;
				maxRange = Math.min(i_center, sLen-i_center-1);
				if(maxRange<=maxStrLen_half) continue;
				if(chArr[i_center-maxStrLen_half]!=chArr[i_center+maxStrLen_half]) continue;
				for(int i_range=0; i_range<maxRange; i_range++) {
					if(chArr[i_center-i_range-1]!=chArr[i_center+i_range+1]) break;
					strLen_half += 1;
					if(maxStrLen_half<strLen_half) {
						maxStrLen_half = strLen_half;
						idx_left = i_center-maxStrLen_half;
					}
				}
			}
			if(maxStrLen_half==0) {
				str = String.valueOf(chArr[0]);
			} else {
				str = s.substring(idx_left, idx_left+2*maxStrLen_half+1);
			}

			//以两个相连字符中点为中心进行搜索
			for(int i_center=0; i_center<sLen-1; i_center++) {
				strLen_half = 0;
				maxRange = Math.min(i_center+1, sLen-i_center-1);
				if(maxRange<=maxStrLen_half) continue;
				if(chArr[i_center-maxStrLen_half]!=chArr[i_center+maxStrLen_half+1]) continue;
				for(int i_range=0; i_range<maxRange; i_range++) {
					if(chArr[i_center-i_range]!=chArr[i_center+i_range+1]) break;
					strLen_half += 1;
					if(maxStrLen_half<strLen_half) {
						maxStrLen_half = strLen_half;
						idx_left = i_center-strLen_half+1;
					}
				}
			}
			if(2*maxStrLen_half>str.length()) {
				str = s.substring(idx_left, idx_left+2*maxStrLen_half);
			}
			return str;
		}
	}


	public static void main(String[] args) {
		//String s = "babad";
		//String s = "cbbd";
		//String s = "abcda";
		//String s = "abcba";
		//String s = "abcdaadcb";
		//String s = "aaaabaaa";
		//String s = "ac";
		String s = "tattarrattat"; //"tattarrattat"
		
		long t1 = System.nanoTime();
		Solution obj = new Solution();
		String str = obj.longestPalindrome2(s);
		long t2 = System.nanoTime();
		
		System.out.println("Input:  "+s);
		System.out.println("Output: "+str);
		System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
	}
}
