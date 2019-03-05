package math;

/** 
 * @author Apollo4634 
 * @create 2019/03/05
 * @problem 29
 * @see DivideTwoIntegers_29
 */

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		boolean isNegative1 = dividend<0;
		boolean isNegative2 = divisor<0;
		
		int quotient = 0;
		if (isNegative1 != isNegative2) {
			while(true) {
				dividend += divisor;
				if (dividend==0) { quotient -= 1; break; }
				if (isNegative1 != (dividend<0)) break;
				quotient -= 1;
			}
		} else {
			long dividendCopy = dividend;
			long divisorCopy = divisor;
			while(true) {
				dividendCopy -= divisorCopy;
				if (dividend < Integer.MIN_VALUE || dividend > Integer.MAX_VALUE) 
					return Integer.MAX_VALUE;
				if (dividendCopy==0) { quotient += 1; break; }
				if (isNegative1 != (dividendCopy<0)) break;
				quotient += 1;
			}
		}
		return quotient;
	}
	
	
	public static void main(String[] args) {
		//int dividend = 10;	int divisor = -3;
		//int dividend = 10;	int divisor = 3;
		//int dividend = 7;	int divisor = -3;
		//int dividend = -1;	int divisor = 1;
		//int dividend = 1;	int divisor = -1;
		int dividend = -2147483648;	int divisor = -1;
		
		System.out.println("Input:  "+dividend);
		System.out.println("Input:  "+divisor);

		long t1 = System.nanoTime();
		DivideTwoIntegers obj = new DivideTwoIntegers(); 
		int quotient = obj.divide(dividend, divisor);
		long t2 = System.nanoTime();

		System.out.println("Output: "+quotient);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
