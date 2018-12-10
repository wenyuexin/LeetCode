package string;

import java.util.Arrays;

/** 
 * @author Apollo4634 
 * @creation 2018/12/10 23:12
 * 
 * No.6 ZigZag Conversion
 */

/**
 * 解题思路：
 * 直接获取坐标对应关系，然后循环复制各个字符
 * 
 * 没写完，施工中...
 */


public class ZigZagConversion3 {
	
	//Solution
	public String convert(String s, int numRows) {	
		int sLen = s.length();
		if(sLen<2 || numRows==1) return s;
		char[] sCharArr = s.toCharArray();
		
		//sLen==2
		char[] strCharArr = new char[sLen];
		if(sLen==2) {
			for (int i=0; i<sLen; i++) {
				strCharArr[i] = sCharArr[i];
			}
		}
		
		int groupLen = numRows-1;
		int nGroup = sLen/groupLen;
		//int nGroup2 = sLen/(2*groupLen);
		int nRemain = sLen%groupLen;
		
		int[] strLenArr = new int[numRows]; 
		strLenArr[0] = (int) Math.ceil(sLen/(2.0*groupLen));
		strLenArr[numRows-1] = (int) Math.ceil(nGroup/2.0);
		
		Arrays.fill(strLenArr, 1, numRows-1, nGroup);
		
		
		String str = "";
		
		return str;
	}
	
	
	public static void main(String[] args) {
		//String s = "PAYPALISHIRING"; //4 "PINALSIGYAHRPI"
		//String s = "PAYPALISHIRING"; //3 "PAHNAPLSIIGYIR"
		String s = "a"; 
		int numRows = 1;
		
		long t1 = System.nanoTime();
		String str = new ZigZagConversion2().convert(s, numRows);
		long t2 = System.nanoTime();
		
		System.out.println("intput: "+s);
		System.out.println("output: "+str);
		System.out.println(str.equals("PINALSIGYAHRPI"));
		System.out.println(str.equals("PAHNAPLSIIGYIR"));
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
