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
	private int[] getStrLenArr(int sLen, int numRows) {
		int groupLen = numRows-1;
		int nGroup = sLen/groupLen;
		//int nGroup2 = sLen/(2*groupLen);
		int nRemain = sLen%groupLen;
		
		int[] strLenArr = new int[numRows];
		if(nGroup%2==0) {
			if(nRemain<2) {
				Arrays.fill(strLenArr, 0, numRows, nGroup);
			} else {
				Arrays.fill(strLenArr, 0, nRemain, nGroup+1);
				Arrays.fill(strLenArr, nRemain, numRows, nGroup);
			}
		} else {
			if(nRemain<2) {
				Arrays.fill(strLenArr, 0, numRows, nGroup);
			} else {
				Arrays.fill(strLenArr, 0, numRows-nRemain, nGroup);
				Arrays.fill(strLenArr, numRows-nRemain, numRows, nGroup);
			}
		}
		
		strLenArr[0] = (int) Math.ceil(sLen/(2.0*groupLen));
		if(nGroup%2==1 && nRemain>0) {
			strLenArr[numRows-1] = strLenArr[0] + 1;			
		} else {
			strLenArr[numRows-1] = strLenArr[0];
		}

		return strLenArr;
	}
	
	public String convert(String s, int numRows) {	
		int sLen = s.length();
		if(sLen<2 || numRows==1) return s;
		char[] sCharArr = s.toCharArray();
		char[] strCharArr = new char[sLen];
		
		System.out.println("test"+sLen);
		
		/*
		int groupLen = numRows-1;
		int nGroup = sLen/groupLen;
		//int nGroup2 = sLen/(2*groupLen);
		int nRemain = sLen%groupLen;
		*/
		
		int[] strLenArr = getStrLenArr(sLen, numRows); 
		Arrays.toString(strLenArr);
		
		
		String str = "";
		
		return str;
	}
	
	
	public static void main(String[] args) {
		//String s = "PAYPALISHIRING"; //4 "PINALSIGYAHRPI"
		//String s = "PAYPALISHIRING"; //3 "PAHNAPLSIIGYIR"
		String s = "123456789"; 
		int numRows = 2;
		
		long t1 = System.nanoTime();
		String str = new ZigZagConversion3().convert(s, numRows);
		long t2 = System.nanoTime();
		
		System.out.println("intput: "+s);
		System.out.println("output: "+str);
		System.out.println(str.equals("PINALSIGYAHRPI"));
		System.out.println(str.equals("PAHNAPLSIIGYIR"));
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
		
	}
}
