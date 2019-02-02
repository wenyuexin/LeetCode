package math;

/**
 * @author -
 * @create 2019/02/01
 * @problem 8
 */

public class StringToInteger_8 {
	
	/*Approach 1: submission on leetcode*/
	public int myAtoi(String str) {
		if(str==null || str.length() == 0) return 0;

		int index = 0;
		while(index < str.length() && str.charAt(index) == ' ') index++;

		int sign = 1;
		if(index < str.length() && str.charAt(index) == '-') {
			sign = -1;
			index++;
		} else if (index < str.length() && str.charAt(index) == '+') {
			index++;
		}

		int total = 0;
		while(index < str.length()) {
			int digit = str.charAt(index) - '0';
			if(digit < 0 || digit > 9) break;

			if((Integer.MAX_VALUE - digit)/10 < total) {
				return ((sign==1)? Integer.MAX_VALUE : Integer.MIN_VALUE);
			}
			total = total * 10 + digit;
			index++;
		}
		return total * sign;
	}
	
	
	/*Approach 2: my solution*/
	public int myAtoi2(String str) {
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
		if(nDigit>10) return ((sgn>0)? Integer.MAX_VALUE : Integer.MIN_VALUE);
		long num = sgn*Long.parseLong(str.substring(left, right));
		if(num<Integer.MIN_VALUE) return Integer.MIN_VALUE;
		if(num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
		return (int) num;
	}
}
