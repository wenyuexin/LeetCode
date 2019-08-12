package string.solution;

import java.util.regex.Pattern;


/** 
 * @author Apollo4634 
 * @create 2018/12/19
 * 
 * No.10 Regular Expression Matching
 */

public class RegularExpressionMatching_10 {

	static class Solution {
		public boolean isMatch(String s, String p) {
			return Pattern.matches(p, s);
		}
	}

	static class Solution2 {
		char[] chars;
		char[] parttens;
		boolean[] mode;
		int nPattens;

		boolean isMatch(String str, String partten) {
			chars = str.toCharArray();
			parttens = new char[partten.length()];
			mode = new boolean[partten.length()];
			nPattens = 0;
			for (int i = 0; i < partten.length(); i++) {
				if (partten.charAt(i) != '*') {
					parttens[nPattens] = partten.charAt(i);
					nPattens += 1;
				} else {
					mode[nPattens-1] = true; //可以匹配多个字符
				}
			}
			return matchHepler(0, 0);
		}

		boolean matchHepler(int strIdx, int pattenIdx) {
			int iPartten = pattenIdx;
			for (; iPartten < nPattens; iPartten++) {
				if (strIdx >= chars.length) break;
				if (!mode[iPartten]) {
					if (parttens[iPartten] == '.') {
						System.out.println(strIdx+" "+chars[strIdx]+" "+iPartten+" "+parttens[iPartten]+" *");
						strIdx += 1;
						continue;
					}
					if (chars[strIdx] != parttens[iPartten]) {
						System.out.println(strIdx+" "+chars[strIdx]+" "+iPartten+" "+parttens[iPartten]+" ");
						break;
					}
					System.out.println(strIdx+" "+chars[strIdx]+" "+iPartten+" "+parttens[iPartten]+" *");
					strIdx += 1;
				} else {
					int cnt = 0;
					while (strIdx+cnt < chars.length && (parttens[iPartten] == '.' || chars[strIdx+cnt] == parttens[iPartten])) {
						System.out.println(strIdx+" "+chars[strIdx+cnt]+" "+iPartten+" "+parttens[iPartten]+" *");
						if (matchHepler(strIdx+cnt, iPartten+1)) return true;
						cnt += 1;
					}
					strIdx += cnt;
				}
			}

			if (strIdx < chars.length) return false;
			boolean flag = true;
			for (int i = iPartten; i < nPattens; i++) {
				flag &= mode[i];
			}
			return flag;
		}
	}


	public static void main(String[] args) {
		//String s = "asdf wwewrf soop uioh.";
		//String p = ".*sdf.*.*oop.*";

		String s = "abc";
		String p = "abcd*";

		long t1 = System.nanoTime();
		boolean flag = new Solution2().isMatch(s, p);
		long t2 = System.nanoTime();
		
		System.out.println("Input:  s -> \""+s+"\"");
		System.out.println("Input:  p -> \""+p+"\"");
		System.out.println("Output: "+flag);
		System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
	}
}
