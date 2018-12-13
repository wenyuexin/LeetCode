package string;

import java.util.Arrays;

/** 
 * @author Apollo4634 
 * @creation 2018/12/10 23:12
 * 
 * No.6 ZigZag Conversion
 * 
 * 施工中..
 */

/**
 * 解题思路：
 * 直接获取坐标对应关系，然后循环复制各个字符
 * 
 */


public class ZigZagConversion3 {
	
	//Solution
	private int[] getStrLenArr(int sLen, int numRows) {
		int groupLen = numRows-1;
		int nGroup = sLen/groupLen;
		int nGroup2 = nGroup/2;
		int nRemain2 = sLen%(2*groupLen);
		int nRemain = nRemain2%groupLen;
		int[] strLenArr = new int[numRows];
		
		if(numRows>2) {
			if(nRemain<2 || nRemain2<2) {
				Arrays.fill(strLenArr, 1, numRows-1, nGroup);
			} else {
				if(nRemain==nRemain2) {
					Arrays.fill(strLenArr, 1, nRemain, nGroup+1);
					Arrays.fill(strLenArr, nRemain, numRows-1, nGroup);					
				} else {
					Arrays.fill(strLenArr, 1, numRows-nRemain, nGroup+1);
					Arrays.fill(strLenArr, numRows-nRemain, numRows-1, nGroup);	
				}
			}
		}
		
		strLenArr[0] = nGroup2 + ((nRemain2>0)?1:0);
		strLenArr[numRows-1] = nGroup2;			
		if(nRemain<nRemain2 && nRemain2>groupLen) strLenArr[numRows-1]++;
		return strLenArr;
	}
	
	public String convert(String s, int numRows) {	
		int sLen = s.length();
		if(sLen<2 || numRows==1) return s;
		int groupLen = numRows-1;
		//int nRemain = sLen/groupLen;
		char[] sCharArr = s.toCharArray();
		char[] strCharArr = new char[sLen];
		System.out.println("sLen: "+sLen+" , "+"numRows: "+numRows);
		
		int[] strLenArr = getStrLenArr(sLen, numRows); 
		System.out.println("strLenArr: "+Arrays.toString(strLenArr));
		
		//String str = "";
		int i_char = 0;
		int idx = -1;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < strLenArr[i]; j++) {
				System.out.println("i="+i+", j="+j);
				
				if(i==1 && j==1) {
					System.out.println("test");
				}
				
				if(i==0) {
					idx = 2*j*groupLen;
				} else if(i==numRows-1) {
					idx = (2*j+1)*groupLen;
				} else {
					idx = j*groupLen + ((j%2==0)?i:numRows-i-1);										
				}
				strCharArr[i_char] = sCharArr[idx];
				i_char++;
			}
		}
		return new String(strCharArr);
	}
	
	
	public static void main(String[] args) {
		//String s = "PAYPALISHIRING"; //4 "PINALSIGYAHRPI"
		//String s = "PAYPALISHIRING"; //3 "PAHNAPLSIIGYIR"
		//String s = "123456789012345678"; 
		String s = "12345"; 
		int numRows = 4;
		
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
