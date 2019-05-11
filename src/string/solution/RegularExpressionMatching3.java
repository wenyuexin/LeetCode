package string.solution;

import java.util.Arrays;
import java.util.regex.Pattern;

/** 
 * @author Apollo4634 
 * @creation 2018/12/21 23:12
 */

public class RegularExpressionMatching3 {
	//Solution2 - 施工中

	private static int[] pFilter(String p) {
		int pLen = p.length();
		if(pLen<2) return new int[] {};
		int[] idxArr = new int[pLen/2];
		int nIdx = 0;

		int idx = -1;
		int fromIndex = 0;
		while (fromIndex<pLen) {
			idx = p.indexOf(".*",fromIndex);
			if(idx==-1) break;
			if(nIdx==0 || (nIdx>0 && idx-idxArr[nIdx-1]>2)) {
				idxArr[nIdx] = idx;
				fromIndex = idx+2; 
				nIdx++;
			}
			if(nIdx>0 && idx-idxArr[nIdx-1]>2) {
				fromIndex = idx+2;
			} else {
				fromIndex++;
			}
		}
		return Arrays.copyOfRange(idxArr,0,nIdx);
	}
	
	
	public boolean isMatch(String s, String p) {
		if(p.equals(".*")) return true;
		if(s.equals("") && (p.equals(".") || p.equals(".*"))) return true;
		char[] sCharArr = s.toCharArray();
		//char[] pCharArr = p.toCharArray();

		String p2 = p.replaceAll("\\.\\**", " ");
		
		

		
		return true;
		//return Pattern.matches(p, s);
	}

	public static void main(String[] args) {
		String s = "I am noob " + "from runoob.com.";
		String p = ".*run.*.*oob.*";

		long t1 = System.nanoTime();
		boolean flag = new RegularExpressionMatching3().isMatch(s,p);
		long t2 = System.nanoTime();

		System.out.println("Input:  s -> \""+s+"\"");
		System.out.println("Input:  p -> \""+p+"\"");
		System.out.println("output: "+flag);
		System.out.println("output: "+Pattern.matches(p, s));
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");

		//String[] ss = new String("o.*asdf.*ww").split(".*");
		System.out.println(Arrays.toString(RegularExpressionMatching3.pFilter(p)));


	}
}
