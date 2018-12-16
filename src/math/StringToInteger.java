package math;

/** 
 * @author Apollo4634 
 * @creation 2018/12/15 17:12
 * 
 * No.8 String to Integer (atoi)
 * 
 * 解题思路：
 * 字符串到数字的转换包含三个主要主要步骤：
 * 确定数字的符号（正负）、确定左端点left、确定右端点right，
 * 最后，只需将left到right之间的子串转变为数字，再加上符号即可。
 * 其中过程需要注意是否溢出等问题。
 * 
 * Solution1:
 * 使用String自带的方法trim()去除输入字符串str开头的空格
 * Solution2:
 * 通过for循环跳过空格字符
 * 
 * 其他：
 * 2018-12-16 17:31
 * 在以下方法中使用了Character.isDigit()判断是个字符是否为数字，
 * 参考leetcode上的解法，可以这样判断：
 * int digit = str.charAt(index) - '0';
 * if(digit < 0 || digit > 9) ...;
 */

public class StringToInteger {
	
	//Solution1
	public int myAtoi(String str) {
		//String s = str.strip(); //strip() since Java 11
		String s = str.trim(); //去除空格
		int sLen = s.length();
		//if(s.isBlank()) return 0; //isBlank() since Java 11
		if(sLen==0) return 0;
		char[] charArr = s.toCharArray();
		
		//确定符号
		int left = 0;
		int sgn = 0; //符号位
		if(charArr[0]=='-') {
			sgn = -1;
			left++;
		} else if (charArr[0]=='+') {
			sgn = 1;
			left++;
		} else if (Character.isDigit(charArr[0])) {
			sgn = 1;
		}
		
		//确定左端点
		if(sgn==0) return 0;
		for (int i = left; i < charArr.length; i++) {
			if(charArr[i]!='0') break;
			left++;
		}
		
		//确定右端点
		int right = left;
		int end = (left+11<sLen)? left+11:sLen;
		for (int i = left; i < end; i++) {
			if (!Character.isDigit(charArr[i])) break;
			right++;
		}
		
		//获取数值
		if(right-left==0) return 0;
		long num = sgn*Long.parseLong(s.substring(left, right));
		if(num<Integer.MIN_VALUE) return Integer.MIN_VALUE;
		if(num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
		return (int) num;
    }

	
	//Solution2
	public int myAtoi2(String str) {
		int strLen = str.length();
		if(strLen==0) return 0;
		char[] charArr = str.toCharArray();

		//确定符号
		int left = 0;
		int sgn = 1; //符号位
		for (int i = left; i < charArr.length; i++) {
			if(charArr[i]==' ') {
				left++;
			} else {
				if(charArr[left]=='-') {
					sgn = -1;
					left++;
				} else if (charArr[left]=='+') {
					left++;
				} else if (!Character.isDigit(charArr[left])) {
					return 0;
				}
				break;
			}
		}

		//确定左端点
		for (int i = left; i < charArr.length; i++) {
			if(charArr[i]!='0') break;
			left++;
		}
		
		//确定右端点
		int right = left;
		int end = (left+11<strLen)? left+11:strLen;
		for (int i = left; i < end; i++) {
			if (!Character.isDigit(charArr[i])) break;
			right++;
		}

		//获取数值
		int nDigit = right-left;
		if(nDigit==0) return 0;
		if(nDigit>10) return (sgn==1)? Integer.MAX_VALUE:Integer.MIN_VALUE;
		long num = sgn*Long.parseLong(str.substring(left, right));
		if(num<Integer.MIN_VALUE) return Integer.MIN_VALUE;
		if(num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
		return (int) num;
	}
	
	
	public static void main(String[] args) {
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
		String str = "0-1";
		
		long t1 = System.nanoTime();
		int num = new StringToInteger().myAtoi2(str);
		long t2 = System.nanoTime();
		
		System.out.println("intput: \""+str+"\"");
		System.out.println("output: "+num);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
		
		//System.out.println(System.getProperty("java.version"));
	}
}
