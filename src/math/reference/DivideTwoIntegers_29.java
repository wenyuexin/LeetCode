package math.reference;

import math.solution.DivideTwoIntegers;

/**
 * @author Apollo4634
 * @create 2019/03/06
 * @problem 29
 * @see DivideTwoIntegers
 */

public class DivideTwoIntegers_29 {

	//My approch
	public int divide(int dividend, int divisor) {
		if (divisor == 1) return dividend;
		if (divisor == -1) {
			if (dividend != Integer.MIN_VALUE) return -dividend;
			else return Integer.MAX_VALUE;			
		}

		long d1 = Math.abs(dividend*1L);
		long d2 = Math.abs(divisor*1L);
		if (d1 < d2) return 0;

		int times = 1;
		int quotient = 1;
		long sum = d2;
		while (sum+sum <= Integer.MAX_VALUE && d1 > sum+sum) {
			times += times;
			quotient += quotient;
			sum += sum;
		}

		long factor = sum; //factor = times*d2
		while (d1>sum && factor>=d2) {
			if (d1 >= sum+factor) {
				quotient += times;
				sum += factor;
			} else {
				factor = (factor>>1);
				times = (times>>1);
			}
		}
		if ((dividend<0) != (divisor<0)) quotient = -quotient;
		return quotient;
	}


	//Approch
	public int divide2(int dividend, int divisor) {
		//Reduce the problem to positive long integer to make it easier.
		//Use long to avoid integer overflow cases.
		int sign = 1;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
			sign = -1;
		long ldividend = Math.abs((long) dividend);
		long ldivisor = Math.abs((long) divisor);

		//Take care the edge cases.
		if (ldivisor == 0) return Integer.MAX_VALUE;
		if ((ldividend == 0) || (ldividend < ldivisor))	return 0;

		long lans = ldivide(ldividend, ldivisor);

		int ans;
		if (lans > Integer.MAX_VALUE){ //Handle overflow.
			ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
		} else {
			ans = (int) (sign * lans);
		}
		return ans;
	}

	private long ldivide(long ldividend, long ldivisor) {
		// Recursion exit condition
		if (ldividend < ldivisor) return 0;

		//  Find the largest multiple so that (divisor * multiple <= dividend), 
		//  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
		//  Think this as a binary search.
		long sum = ldivisor;
		long multiple = 1;
		while ((sum+sum) <= ldividend) {
			sum += sum;
			multiple += multiple;
		}
		//Look for additional value for the multiple from the reminder (dividend - sum) recursively.
		return multiple + ldivide(ldividend - sum, ldivisor);
	}
}
