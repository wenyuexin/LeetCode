package math;

/**
 * @author Apollo4634
 * @creation 2018/12/14 20:56
 * 
 * No.7 Reverse Integer
 * 
 * 解题思路：
 * 转化为字符串进行处理，并使用StringBuilder类的字符串反转实现数字的反转
 * 具体操作时还需要注意符号位的处理
 * 
 * Solution2:
 * 基本方法和solution1差不多，区别在于 
 * 使用了自定义的函数替换StringBuilder类的字符串反转功能
 */

public class ReverseInteger2 {
	
	//Solution1
	public int reverse(int x) {
		if(x==Integer.MIN_VALUE) return 0;
		int sgn = (x>0)?1:-1;
		String numReverseStr = new StringBuilder().append(sgn*x).reverse().toString();
		long xRev = Long.parseLong(numReverseStr);
		xRev = (xRev>Integer.MAX_VALUE)? 0:sgn*xRev;
		return (int) xRev;
	}
	
	//Solution2
	private String StrReverse(String s) {
		int sLen = s.length();
		char[] sCharArr = s.toCharArray();
		char ch;
		for (int i = (sLen>>1)-1; i >= 0; i--) {
			ch = sCharArr[i];
			sCharArr[i] = sCharArr[sLen-i-1];
			sCharArr[sLen-i-1] = ch;
		}
		return new String(sCharArr);
	}
	
	public int reverse2(int x) {
		if(x==Integer.MIN_VALUE) return 0;
		int num = (x>0)?x:-1*x;
		String numReverseStr = StrReverse(String.valueOf(num));
		long xRev = Long.parseLong(numReverseStr);
		if(xRev>Integer.MAX_VALUE) return 0;
		if(x<0) xRev*=-1;
		return (int) xRev;
	}
	
	
	public static void main(String[] args) {
		//int x = 1534236469;
		//int x = -2147483648; //等于Integer.MIN_VALUE 
		int x = -214748;
		
		long t1 = System.nanoTime();
		int xRev = new ReverseInteger2().reverse2(x);
		long t2 = System.nanoTime();
		
		System.out.println("Input: "+x);
		System.out.println("output: "+xRev);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
