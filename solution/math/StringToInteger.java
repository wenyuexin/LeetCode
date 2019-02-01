package math;

/** 
 * 解题思路：
 * 字符串到数字的转换包含三个主要主要步骤：
 * 确定数字的符号（正负）、确定左端点left、确定右端点right，
 * 最后，只需将left到right之间的子串转变为数字，再加上符号即可。
 * 其中过程需要注意是否溢出等问题。
 * 
 * 其他：
 * 2018-12-16 17:31
 * 在以下方法中使用了Character.isDigit()判断是个字符是否为数字，
 * 参考leetcode上的解法，可以这样判断：
 * int digit = str.charAt(index) - '0';
 * if(digit < 0 || digit > 9) ...;
 * 
 * @author Apollo4634 
 * @creation 2018/12/15 17:12
 * @problem 8
 */

public class StringToInteger {

	//Solution
	public int myAtoi(String str) {
		int strLen = str.length();
		if(strLen==0) return 0;
		char[] charArr = str.toCharArray();

		//去除空格字符
		int left = 0;
		for (int i=0; i<strLen && charArr[i]==' '; i++) left++;
		if(left>=strLen) return 0;
		
		//确定符号位
		int sgn = 1; 
		if(charArr[left]=='-' || charArr[left]=='+') {
			sgn = 44 - charArr[left];
			left++;
		} else if (!Character.isDigit(charArr[left])) {
			return 0;
		}

		//确定左端点
		for (int i=left; i<strLen && charArr[i]=='0'; i++) left++;

		//确定右端点
		int right = left;
		int end = Math.min(left+11, strLen);
		for (int i=left; i<end && Character.isDigit(charArr[i]); i++) right++;

		//获取数值
		int nDigit = right-left;
		if(nDigit==0) return 0;
		if(nDigit>10) return (sgn>0)? Integer.MAX_VALUE:Integer.MIN_VALUE;
		long num = sgn*Long.parseLong(str.substring(left, right));
		if(num<Integer.MIN_VALUE) return Integer.MIN_VALUE;
		if(num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
		return (int) num;
	}


	public static void main(String[] args) {
		System.out.println((int)('+')+" "+(int)('-')); //43 45
		
		//String str = "  -13 ";
		//String str = "   -42";
		//String str = "  1 ";
		//String str = "  1b ";
		//String str = "  a1b ";
		//String str = "  -1 ";
		//String str = "  -123456789 ";
		//String str = "  + ";
		//String str = "-91283472332";
		//String str = "  0000000000012345678";
		//String str = "20000000000000000000 ";
		//String str = "  +0000000000012345678";
		//String str = "0-1";
		String str = " ";

		long t1 = System.nanoTime();
		StringToInteger obj = new StringToInteger();
		int num = obj.myAtoi(str);
		long t2 = System.nanoTime();

		System.out.println("Intput: \""+str+"\"");
		System.out.println("Output: "+num);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
