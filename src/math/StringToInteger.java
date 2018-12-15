package math;

/** 
 * @author Apollo4634 
 * @creation 2018/12/15 17:12
 * 
 * No.8 String to Integer (atoi)
 * 
 * 解题思路：
 * 
 */

public class StringToInteger {
	
	public int myAtoi(String str) {
		String s = str.strip();
		//int sLen = s.length();
		if(str.isBlank()) return 0;
		
		long num = 0; 
		try {
			num = Long.parseLong(s);
			if(num<Integer.MIN_VALUE || num>Integer.MAX_VALUE) {
				return 0;
			} else {
				return (int) num;
			}
		} catch (Exception e) {
		}
		
		char[] charArr = s.toCharArray();
		char[] numCharArr = new char[10];

		int sgn = 0;
		if(charArr[0]=='-') {
			sgn = -1;
		} else if (charArr[0]=='+') {
			sgn = 1;
		} else if (Character.isDigit(charArr[0])) {
			sgn = 1;
		}


		int nDigit = 0;
		for (int i = 0; i < charArr.length; i++) {

		}
			
		
		return 0;
    }

	public static void main(String[] args) {
		String str = "  +13 ";
		
		System.out.println("".isBlank());
		System.out.println(Character.isDigit('-'));
		
		//int num = new StringToInteger().myAtoi(str);
		
		//System.out.println(isNumeric("1234657890"));
		
	}
}
