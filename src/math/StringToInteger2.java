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

public class StringToInteger2 {
	
	//Solution1
	public int myAtoi(String str) {
		//String s = str.strip(); //strip() since Java 11
		String s = str.trim();
		int sLen = s.length();
		//if(s.isBlank()) return 0; //isBlank() since Java 11
		if(sLen==0) return 0;
		char[] charArr = s.toCharArray();
		
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
		
		if(sgn==0) return 0;
		for (int i = left; i < charArr.length; i++) {
			if(charArr[i]!='0') break;
			left++;
		}
		
		int right = left;
		int end = (left+11<sLen)? left+11:sLen;
		for (int i = left; i < end; i++) {
			if (!Character.isDigit(charArr[i])) break;
			right++;
		}
		
		if(right-left==0) return 0;
		long num = sgn*Long.parseLong(s.substring(left, right));
		if(num<Integer.MIN_VALUE) return Integer.MIN_VALUE;
		if(num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
		return (int) num;
    }

	
	//Solution2 - 施工中
	public int myAtoi2(String str) {
		int strLen = str.length();
		if(strLen==0) return 0;
		char[] charArr = str.toCharArray();

		int left = 0;
		int sgn = 1; //符号位
		for (int i = left; i < charArr.length; i++) {
			if(charArr[i]==' ' || charArr[i]=='0') {
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

		int right = left;
		int end = (left+11<strLen)? left+11:strLen;
		for (int i = left; i < end; i++) {
			if (!Character.isDigit(charArr[i])) break;
			right++;
		}

		if(right-left==0) return 0;
		long num = sgn*Long.parseLong(str.substring(left, right));
		if(num<Integer.MIN_VALUE) return Integer.MIN_VALUE;
		if(num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
		return (int) num;
	}
	
	
	public static void main(String[] args) {
		//String str = "  -13 ";
		String str = "   -42";
		//String str = "  1 ";
		//String str = "  1b ";
		//String str = "  a1b ";
		//String str = "  -1 ";
		//String str = "  -123456789 ";
		//String str = "  + ";
		//String str = "-91283472332";
		//String str = "  0000000000012345678";
		//String str = "20000000000000000000 ";
		//String str = "  0000000000012345678";
		
		long t1 = System.nanoTime();
		int num = new StringToInteger2().myAtoi2(str);
		long t2 = System.nanoTime();
		
		System.out.println("intput: \""+str+"\"");
		System.out.println("output: "+num);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
		
		//System.out.println(System.getProperty("java.version"));
	}
}
