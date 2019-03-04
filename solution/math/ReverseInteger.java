package math;

/** 
 * @author Apollo4634 
 * @creation 2018/12/14 22:12
 * 
 * No.7 Reverse Integer
 * 
 * 解题思路：
 * 先将x转换为正数，计算数x的总位数nDigit，然后使用取余和整数除法，
 * 由低位到高位依次取各个位上的值，乘以对应的位权，转换后叠加到xRev，
 * 如果xRev的值在int取值范围内，则输出转换后的值
 * 
 * 其他：
 * 大部分写法都比较麻烦，日常码代码推荐ReverseInteger2中的solution1
 */

public class ReverseInteger {
	
	//Solution	
	public int reverse(int x) {
		if(x==Integer.MIN_VALUE) return 0;
		
		int num = (x>0)?x:-x;
		int nDigit = (int)Math.log10(num) + 1;
		if(nDigit>10) return 0;
		
		double xRev = 0;
		int digit = 0;
		
		final double[] tenPow = new double[] {1E0,1E1,1E2,1E3,1E4,1E5,1E6,1E7,1E8,1E9};
		for (int i = 0; i < nDigit; i++) {
			digit = num%10;
			num /= 10;
			xRev += digit*tenPow[nDigit-i-1];
			if(xRev>Integer.MAX_VALUE) return 0;
		}
		
		if(x<0) xRev=-xRev;
		return (int) xRev;
	}
	
	public static void main(String[] args) {
		//int x = 1534236469;
		//int x = -2147483648; //等于Integer.MIN_VALUE 
		//int x = 2147483647;
		//int x = 7463847412;
		int x = 1234560412;
		
		long t1 = System.nanoTime();
		int xRev = new ReverseInteger().reverse(x);
		long t2 = System.nanoTime();

		System.out.println("Input: "+x);
		System.out.println("output: "+xRev);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
