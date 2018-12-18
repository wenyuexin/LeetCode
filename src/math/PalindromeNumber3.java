package math;

/** 
 * @author Apollo4634 
 * @creation 2018/12/19 00:12
 * 
 * No.9 Palindrome Number
 */

public class PalindromeNumber3 {

	//Solution - 施工中
	public boolean isPalindrome(int x) {
		if(x<0) return false;
		if(x<10) return true;
		if(x%10==0) return false;

		int nChar = (int) Math.log10(x)+1;
		if(nChar==2) return x%10==x/10;
		if(nChar==10 && x%10>2) return false;
		
		int nChar_h1 = (int) (nChar/2.0+0.5);
		int nChar_h2 = nChar/2;
		int tenPow_1 = (int) Math.pow(10, nChar_h1);
		int tenPow_2 = (nChar_h1==nChar_h2)?tenPow_1:tenPow_1/10;
		int n1 = x/tenPow_1;
		int n2 = x%tenPow_2;

		int digit1 = 0;
		int digit2 = 0;
		for (int i = 0; i < nChar_h2; i++) {
			digit1 = n1/tenPow_2;
			n1 %= tenPow_2;
			tenPow_2 /= 10;
			digit2 = n2%10;
			n2 /= 10;
			if(digit1!=digit2) return false;
		}
		return true;
	}

	
	public static void main(String[] args) {
		//int x = -121;
		//int x = -121;
		//int x = 12321;
		//int x = 123321;
		//int x = 120030221;		
		int x = 100030001;		

		long t1 = System.nanoTime();
		boolean flag = new PalindromeNumber3().isPalindrome(x);
		long t2 = System.nanoTime();

		System.out.println("input:  "+x);
		System.out.println("output: "+flag);
		System.out.println("time: "+(t2-t1)/1.0E6+" ms");
	}
}
