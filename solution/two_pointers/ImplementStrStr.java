package two_pointers;

import string.ZigZagConversion;

/** 
 * @author Apollo4634 
 * @create 2019/03/04
 * @problem 28
 * @see ImplementStrStr_28
 */

public class ImplementStrStr {

	//Solution 1
	public int strStr(String haystack, String needle) {
	    return haystack.indexOf(needle);
    }
	
	//Solution 2
	public int strStr2(String haystack, String needle) {
		
		
	    return haystack.indexOf(needle);
    }
	
	
	public static void main(String[] args) {
		String haystack = "hello";
		String needle = "ll"; 
		System.out.println("Input:  "+haystack);
		System.out.println("Input:  "+needle);
		
		long t1 = System.nanoTime();
		ImplementStrStr obj = new ImplementStrStr();
		int idx = obj.strStr(haystack, needle);
		long t2 = System.nanoTime();
		
		System.out.println("Output: "+idx);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
