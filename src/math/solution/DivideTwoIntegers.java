package math.solution;

/** 
 * dividend = quotient*divisor + r
 * factor = times*divisor
 * 
 * 为了简化对除数dividend和被除数divisor的符号问题的讨论，
 * 这里先取两者的绝对值，即 d1=abs(dividend)  d2=abs(divisor)
 * 之后只需根据dividend和divisor是否异号，判断是否需要对商数quotient取反即可
 * 
 * Solution 1
 * 假设 d1 = quotient*d2 + r (d1>0, d2>0, quotient>0, r>0)
 * 即 d1 = d2 + d2 + d2 + ... + d2 + r
 * 在不使用乘除和取模的条件下，最简单的方法是使用循环，看看包含几个d2
 * 每次循环使用 d1 = d1-d2 更新d1的值，同时记录更新次数cnt
 * 当d1==0, 说明d1可以整除d2，余数r==0，此时quotient==cnt
 * 当d1<0，说明d1不能整除d2，余数r>0，此时quotient==cnt-1
 * 当d1>0，说明余数r>d2，此时继续循环
 * 总之，该方法相当于将除法运算拆分多次减法运算
 * 
 * Solution 2
 * 方法1的逻辑较为简单，但程序复杂度高，需要循环 abs(dividend/divisor)+1 次
 * 当计算值较大的除数和值较小的被除数时，运行时间过长
 * 
 * 如果d1 = k*d2 + r，那么方法1就是使用k=k+1逐步增加k，直到r<=0
 * 方法2则使用k=2*k的方式递增，相当于k=2^n的方式递增，直到r<=0 (此时令K=k, N=n)
 * 上述过程相当于手动求解 N=log2(d1/d2)
 * 
 * 注意，此时仍然可能有r>d2，例如d1=202, d2=3时，d1=(2^6)*d2+10，而10>d2 
 * 因此需要减小k值继续搜索，这里有两种方案：
 * 第一，将余数r视为新的d1进行分析，按序列 { d2, d2*2, d2*4, ... }更新d1，
 * 如果减去其中一个值后余数仍然大于0，则继续减去该值，否则选择下一个数，直到余数小于等于0
 * 第二，将余数r视为新的d1进行分析，按序列 { d2*N, d2*N/2, d2*N/4 ... }更新d1
 * 如果减去其中一个值后余数仍然大于0，则继续减去该值，否则选择下一个数，直到余数小于等于0
 * 这里使用了第二种方式
 * 
 * 举个例子说明一下方法2：
 * 假设dividend=-202, divisor=3，那么d1=202, d2=3， 可知 202 = 67*3 + 1
 * k=1, d1=202, d2=3, factor=3*(2^1)=  6, sum=6  < d1
 * k=2, d1=202, d2=3, factor=3*(2^2)= 12, sum=12 < d1
 * ...
 * k=6, d1=202, d2=3, factor=3*(2^6)=192, sum=192 < d1 (q=2^6)
 * k=7, d1=202, d2=3, factor=3*(2^7)=384, sum=384 > d1 (break)
 * 
 * 此时余数r=10，即r>d2
 * k=6, d1=202, d2=3, factor=3*(2^6)=192, sum=192+192 > d1
 * k=5, d1=202, d2=3, factor=3*(2^5)= 96, sum=192+96 > d1
 * ...
 * k=1, d1=202, d2=3, factor=3*(2^1)=  6, sum=192+6=198 < d1 (q=2^6+2^1)
 * k=0, d1=202, d2=3, factor=3*(2^0)=  3, sum=192+6+3=201 < d1 (q=2^6+2^1+2^0)
 * k=0, d1=202, d2=3, factor=3*(2^0)=  3, sum=192+6+3+3=204 > d1 (break)
 * 结果：quotient=2^6+2^1+2^0=67
 * 
 * @author Apollo4634 
 * @create 2019/03/05
 * @problem 29
 * @see DivideTwoIntegers_29
 */

public class DivideTwoIntegers {

	//Solution 1 - Unrecommended
	public int divide(int dividend, int divisor) {
		if (divisor == 1) return dividend;
		if (divisor == -1) {
			if (dividend != Integer.MIN_VALUE) return -dividend;
			else return Integer.MAX_VALUE;			
		}

		long d1 = Math.abs(dividend*1L);
		long d2 = Math.abs(divisor*1L);
		if (d1 < d2) return 0;
		
		int quotient = 0;
		while(true) {
			d1 -= d2;
			if (d1 < 0) break;
			quotient += 1;
			if (d1 == 0) break;
		}
		if ((dividend<0) != (divisor<0)) quotient = -quotient;
		return quotient;
	}


	//Solution 2 - Recommended
	public int divide2(int dividend, int divisor) {
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
			//System.out.println(factor+" "+sum);
			if (d1 >= sum+factor) {
				quotient += times;
				sum += factor;
			} else {
				factor = (factor>>1);
				times = (times>>1);
			}
			//System.out.println(factor+" "+sum+"\n");
		}
		if ((dividend<0) != (divisor<0)) quotient = -quotient;
		return quotient;
	}

	
	public static void main(String[] args) {
		//int dividend = 10;	int divisor = -3;
		//int dividend = 10;	int divisor = 3;
		//int dividend = 7;	int divisor = -3;
		//int dividend = -1;	int divisor = 1;
		//int dividend = 1;	int divisor = -1;
		//int dividend = -2147483648;	int divisor = -1;
		//int dividend = 20;	int divisor = 2;
		//int dividend = 200;	int divisor = 2;
		//int dividend = 2147483647;	int divisor = 2;
		//int dividend = -2147483648;	int divisor = 2;
		int dividend = -380;	int divisor = 3;
		
		System.out.println("Input:  "+dividend);
		System.out.println("Input:  "+divisor);

		long t1 = System.nanoTime();
		DivideTwoIntegers obj = new DivideTwoIntegers(); 
		int quotient = obj.divide2(dividend, divisor);
		long t2 = System.nanoTime();

		System.out.println("Output: "+quotient+" ("+dividend/divisor+")");
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
