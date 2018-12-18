package math;

/** 
 * @author Apollo4634 
 * @creation 2018/12/17 22:12
 * 
 * No.9 Palindrome Number
 */

public class PalindromeNumber3 {

	//Solution1 - 施工中
	public boolean isPalindrome(int x) {
		if(x<0) return false;
		if(x<10) return true;
		final double[] tenPow = new double[] {1E0,1E1,1E2,1E3,1E4,1E5,1E6,1E7,1E8,1E9};
		
		int nChar = (int) Math.log10(x)+1;
		int nChar_h1 = (int) (nChar/2.0+0.5);
		int n1 = (int) (x/tenPow[nChar_h1]);
		int nChar_h2 = (int) nChar/2;
		int n2 = x%((int)tenPow[nChar_h2]);
		
		int digit = 0;
		int n2Rev = 0;
		for (int i = 0; i < nChar_h2; i++) {
			digit = n2%10;
			n2 /= 10;
			n2Rev += (int) (digit*tenPow[nChar_h2-i-1]);
		}
		return n1==n2Rev;
	}
	

	public static void main(String[] args) {
		//int x = -121;
		//int x = -121;
		//int x = 12321;
		int x = 123321;

		long t1 = System.nanoTime();
		boolean flag = new PalindromeNumber3().isPalindrome(x);
		long t2 = System.nanoTime();

		System.out.println("input:  "+x);
		System.out.println("output: "+flag);
		System.out.println("time: "+(t2-t1)/1.0E6+" ms");
	}
}
