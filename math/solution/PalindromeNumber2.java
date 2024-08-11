package math.solution;

/** 
 * @author Apollo4634 
 * @create 2018/12/16 17:12
 * 
 * No.9 Palindrome Number
 * 
 * 解题思路：
 * 先将数字转变为字符串，然后将字符串反转，最后对比两个字符串是否相同
 */

public class PalindromeNumber2 {
	
	//Solution
	public boolean isPalindrome(int x) {
		if(x<0) return false;
		if(x<10) return true;
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
		
		System.out.println("Input:  "+x);
		System.out.println("Output: "+flag);
		System.out.println("time:  "+(t2-t1)/1.0E6+" ms");
	}
}
