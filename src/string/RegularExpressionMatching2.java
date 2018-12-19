package string;

import java.util.regex.Pattern;


/** 
 * @author Apollo4634 
 * @creation 2018/12/19 12:12
 * 
 * No.10 Regular Expression Matching
 */

public class RegularExpressionMatching2 {

	//Solution1
	public boolean isMatch(String s, String p) {
		return Pattern.matches(p, s);
	}
	
	//Solution2 - 施工中
	private int[] pfilter(String p) {
		char[] pCharArr = p.toCharArray();
		int containStar = 0;
		int containDot = 0;
		int containDotStar = 0;
		boolean afterDotStar = false;
		for (int i = 0; i < pCharArr.length; i++) {
			if(afterDotStar) {
				
			} else {
				if(pCharArr[i]=='.') containDot++;
				if(pCharArr[i]=='*') {
					containStar++;
					if(pCharArr[i-1]=='.') {
						containDotStar++;
						containDot--;
						containStar--;
						afterDotStar = true;
					}
				}	
			}
		}
		
		return new int[] {containStar, containDot, containDotStar};
	}
	
	public boolean isMatch2(String s, String p) {
		if(p.equals(".*")) return true;
		if(s.equals("") && (p.equals(".") || p.equals(".*")));
		char[] sCharArr = s.toCharArray();
		char[] pCharArr = p.toCharArray();
		
		
		
		for (int i = 0; i < pCharArr.length; i++) {
			
		}
		
		return Pattern.matches(p, s);
	}

	
	public static void main(String[] args) {
		String s = "I am noob " + "from runoob.com.";
		String p = ".*runoob.*";

		long t1 = System.nanoTime();
		boolean flag = new RegularExpressionMatching2().isMatch2(s,p);
		long t2 = System.nanoTime();
		
		System.out.println("intput: s -> \""+s+"\"");
		System.out.println("intput: p -> \""+p+"\"");
		System.out.println("output: "+flag);
		System.out.println("output: "+Pattern.matches(p, s));
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
