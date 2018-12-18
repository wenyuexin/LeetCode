package math;

/** 
 * @author Apollo4634 
 * @creation 2018/12/17 22:12
 * 
 * No.9 Palindrome Number
 * 
 * 解题思路：
 * 先将输入的数字x按中轴线拆分为前半段n1和后半段n2：
 * 例如，x=123321，则n1=123，n2=321
 * 又如，x=1234321，则n1=123，n2=321
 * 然后将n2按位进行反转得到n2Rev，最后返回 (n1==n2Rev)
 * 
 * 关于整数的反转可以参考 No.7 Reverse Integer
 */

public class PalindromeNumber {

	//Solution1
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
			n2Rev = n2Rev*10 + digit;
		}
		return n1==n2Rev;
	}
	
	//Solution2 - Recommendation
	public boolean isPalindrome2(int x) {
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

		int digit = 0;
		int n2Rev = 0;
		for (int i = 0; i < nChar_h2; i++) {
			digit = n2%10;
			n2 /= 10;
			n2Rev = n2Rev*10 + digit;
		}
		return n1==n2Rev;
	}
		
	//Solution3
	public boolean isPalindrome3(int x) {
		if(x<0) return false;
		if(x<10) return true;
		if(x%10==0) return false;
		
		int nChar = (int) Math.log10(x)+1;
		switch (nChar) {
		case 2:
			return (x%10==x/10);
		case 3:
			return (x%10==x/100);
		default:
			if(nChar==10 && x%10>2) return false;
			int nChar_h1 = (int) (nChar/2.0+0.5);
			int nChar_h2 = nChar/2;
			int tenPow_1 = (int) Math.pow(10, nChar_h1);
			int tenPow_2 = (nChar_h1==nChar_h2)?tenPow_1:tenPow_1/10;
			int n2 = x%tenPow_2;
			
			int digit = 0;
			int n2Rev = 0;
			for (int i = 0; i < nChar_h2; i++) {
				digit = n2%10;
				n2 /= 10;
				n2Rev = n2Rev*10 + digit;
			}
			return (x/tenPow_1)==n2Rev;
		}
	}
	

	public static void main(String[] args) {
		//int x = -121;
		//int x = -121;
		//int x = 12321;
		//int x = 123321;
		//int x = 120030221;		
		int x = 1000030001;		

		long t1 = System.nanoTime();
		boolean flag = new PalindromeNumber().isPalindrome2(x);
		long t2 = System.nanoTime();

		System.out.println("input:  "+x);
		System.out.println("output: "+flag);
		System.out.println("time: "+(t2-t1)/1.0E6+" ms");
	}
}
