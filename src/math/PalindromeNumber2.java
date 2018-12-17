package math;

/** 
 * @author Apollo4634 
 * @creation 2018/12/16 17:12
 * 
 * No.9 Palindrome Number
 */

public class PalindromeNumber2 {
	
	//Solution1
	public boolean isPalindrome(int x) {
		String xStr = String.valueOf(x);
		String xStrRev = new StringBuilder(xStr).reverse().toString();
		return xStr.equals(xStrRev);
	}

	//Solution2 - 有bug
	public boolean isPalindrome2(int x) {
		StringBuilder xStringBuilder = new StringBuilder().append(x);
		//StringBuilder sb = xStringBuilder.reverse();
		return xStringBuilder.equals(xStringBuilder.reverse());//reverse有副作用?
	}
	
	public static void main(String[] args) {
		//int x = -121;
		int x = -121;
		
		long t1 = System.nanoTime();
		boolean flag = new PalindromeNumber2().isPalindrome(x);
		long t2 = System.nanoTime();
		
		System.out.println("input:  "+x);
		System.out.println("output: "+flag);
		System.out.println("time:  "+(t2-t1)/1.0E6+" ms");
	}
}
