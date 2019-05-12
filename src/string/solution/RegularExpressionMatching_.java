package string.solution;

import java.util.regex.Pattern;


/** 
 * @author Apollo4634 
 * @create 2018/12/19
 * 
 * No.10 Regular Expression Matching
 */

public class RegularExpressionMatching_ {

	//Solution
	public boolean isMatch(String s, String p) {
		return Pattern.matches(p, s);
	}
	
	
	public static void main(String[] args) {
		String s = "asdf wwewrf soop uioh.";
		String p = ".*sdf.*.*oop.*";

		long t1 = System.nanoTime();
		boolean flag = new RegularExpressionMatching_().isMatch(s,p);
		long t2 = System.nanoTime();
		
		System.out.println("Input:  s -> \""+s+"\"");
		System.out.println("Input:  p -> \""+p+"\"");
		System.out.println("Output: "+flag);
		System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
	}
}
