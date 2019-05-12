package math.reference;

/** 
 * No.7 Reverse Integer
 * 
 * Approach: Pop and Push Digits & Check before Overflow
 * 
 * eversing an integer can be done similarly to reversing a string.
 * We want to repeatedly "pop" the last digit off of xx and 
 * "push" it to the back of the rev. 
 * In the end, rev will be the reverse of the xx.
 * To "pop" and "push" digits without the help of some auxiliary stack/array, 
 * we can use math.
 * 
 * //pop operation:
 * pop = x % 10;
 * x /= 10;
 * 
 * //push operation:
 * temp = rev * 10 + pop;
 * rev = temp;
 * 
 * @author - 
 * @create 2018/12/15
 * @problem 7
 */

public class ReverseInteger_7 {
	
	public int reverse(int x) {
	    int rev = 0;
	    while (x != 0) {
	        int pop = x % 10;
	        x /= 10;
	        if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
	        if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
	        rev = rev * 10 + pop;
	    }
	    return rev;
	}

	
	public static void main(String[] args) {
		//int x = 1534236469;
		//int x = -2147483648; //等于Integer.MIN_VALUE 
		//int x = 2147483647;
		//int x = 7463847412;
		int x = 1234560412;
		
		long t1 = System.nanoTime();
		int xRev = new ReverseInteger_7().reverse(x);
		long t2 = System.nanoTime();
	
		System.out.println("Input:  "+x);
		System.out.println("Output: "+xRev);
		System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
	}
}

