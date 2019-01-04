package math;

/** 
 * @author Apollo4634 
 * @creation 2019/01/04 23:01
 * 
 * No.13 Roman to Integer
 * 
 * 参考：
 * I 1, V 5, X 10, L 50, C 100, D 500, M 1000
 * 
 * 解题思路：
 * 
 */

public class RomanToInteger2 {

	//Solution
	public int romanToInt(String s) {

		return 0;
	}

	public static void main(String[] args) {
		//输入字符串对应数字的范围是 1 至 3999
		String s = "LVIII"; //58
		//String s = "MCMXCIV"; //1994
		//String s = "III"; //3

		long t1 = System.nanoTime();
		int num = new RomanToInteger2().romanToInt(s);
		long t2 = System.nanoTime();

		System.out.println("input: "+s);
		System.out.println("output: "+num);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
