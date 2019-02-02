package math;

/**
 * @author -
 * @create 2019/02/01
 * @problem 9
 */

public class PalindromeNumber_9 {

	/*Approach 1: A submission on leetcode*/
	public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(reverse(x) == x) return true;
        return false;
    }
    
    private int reverse(int n) {
        int reverse = 0;
        while(n!=0){
            reverse = reverse * 10 + (n %10);
            n/=10;
        }
        return reverse;
    }
    
    
    /*Approach 2: My solution*/
    public boolean isPalindrome2(int x) {
		if(x<0) return false;//负数
		if(x<10) return true;//个位数
		if(x%10==0) return false;//个位为0

		int nChar = (int) Math.log10(x)+1;
		if(nChar==2) return x%10==x/10;
		if(nChar==10 && x%10>2) return false;
		
		int nChar_h1 = (int) (nChar/2.0+0.5);
		int tenPow = (int) Math.pow(10, nChar_h1);
		int n1 = x/tenPow; //前半段
		if(nChar_h1!=nChar/2) tenPow/=10;
		int n2 = x%tenPow; //后半段

		int n1Rev = 0;
		while(n1>0) {
			n1Rev = n1Rev*10 + n1%10;
			n1 /= 10;
		}
		return n1Rev==n2;
	}
    
}
