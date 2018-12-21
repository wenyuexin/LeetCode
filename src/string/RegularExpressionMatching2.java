package string;

import java.util.regex.Pattern;


/** 
 * @author Apollo4634 
 * @creation 2018/12/19 12:12
 * 
 * No.10 Regular Expression Matching
 */

public class RegularExpressionMatching2 {

	//Solution
	public boolean isMatch(String s, String p) {
		return Pattern.matches(p, s);
	}
	
	
	public static void main(String[] args) {
		String s = "asdf wwewrf soop uioh.";
		String p = ".*sdf.*.*oop.*";

		long t1 = System.nanoTime();
		boolean flag = new RegularExpressionMatching2().isMatch(s,p);
		long t2 = System.nanoTime();
		
		System.out.println("intput: s -> \""+s+"\"");
		System.out.println("intput: p -> \""+p+"\"");
		System.out.println("output: "+flag);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
