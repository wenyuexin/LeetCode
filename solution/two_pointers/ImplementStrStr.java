package two_pointers;


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
		if (needle.length() == 0) return 0;
		if (haystack.length() < needle.length()) return -1;
		
		char[] haystackCharArr = haystack.toCharArray();
		char[] needleCharArr = needle.toCharArray();
		int j;
		int maxIdx = haystack.length() - needle.length() + 1;
		for (int i = 0; i < maxIdx; i++) {
			for (j = 0; j < needleCharArr.length; j++) 
				if (haystackCharArr[i+j] != needleCharArr[j]) break;
			if (j == needleCharArr.length) return i;
		}
	    return -1;
    }
	
	
	public static void main(String[] args) {
		String haystack = "hello";
		String needle = "ll"; 
		
		//String haystack = "aaaaa";
		//String needle = "bba";
		
		System.out.println("Input:  "+haystack);
		System.out.println("Input:  "+needle);
		
		long t1 = System.nanoTime();
		ImplementStrStr obj = new ImplementStrStr();
		int idx = obj.strStr2(haystack, needle);
		long t2 = System.nanoTime();
		
		System.out.println("Output: "+idx);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
