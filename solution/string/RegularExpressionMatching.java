package string;

import java.util.regex.Pattern;


/** 
 * @author Apollo4634 
 * @creation 2018/12/19 12:12
 * 
 * No.10 Regular Expression Matching
 */

public class RegularExpressionMatching {

	//Solution
	public boolean isMatch(String s, String p) {
		return Pattern.matches(p, s);
	}
	
	
	public static void main(String[] args) {
		String s = "asdf wwewrf soop uioh.";
		String p = ".*sdf.*.*oop.*";

		long t1 = System.nanoTime();
		boolean flag = new RegularExpressionMatching().isMatch(s,p);
		long t2 = System.nanoTime();
		
		System.out.println("Input: s -> \""+s+"\"");
		System.out.println("Input: p -> \""+p+"\"");
		System.out.println("Output: "+flag);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
