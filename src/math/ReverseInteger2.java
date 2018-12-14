package math;

/**
 * @author Apollo4634
 * @creation 2018/12/14 20:56
 * 
 * No.7 Reverse Integer
 * 
 * 解题思路：
 * 
 * 
 */

public class ReverseInteger2 {
	
	//Solution
	public int reverse(int x) {
		if(x==Integer.MIN_VALUE) return 0;
		int sgn = (x>0)?1:-1;
		String numReverseStr = new StringBuilder().append(sgn*x).reverse().toString();
		long xRev = sgn*Long.parseLong(numReverseStr);
		if(xRev<Integer.MIN_VALUE || xRev>Integer.MAX_VALUE) xRev = 0;
		return (int) xRev;
	}
	
	
	public static void main(String[] args) {
		//int x = 1534236469;
		int x = -2147483648; //等于Integer.MIN_VALUE 
		
		long t1 = System.nanoTime();
		int xRev = new ReverseInteger2().reverse(x);
		long t2 = System.nanoTime();
		
		System.out.println("intput: "+x);
		System.out.println("output: "+xRev);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
