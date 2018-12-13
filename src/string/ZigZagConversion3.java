package string;

import java.util.Arrays;

/** 
 * @author Apollo4634 
 * @creation 2018/12/10 23:12
 * 
 * No.6 ZigZag Conversion
 * 
 * Rumtime: 0.035602 ms
 */

/**
 * 解题思路：
 * (参考problem文件夹中的0006_ZigZagConversion.md)
 * 
 * 首先，输入s对应的字符数组是 char[] sCharArr = s.toCharArray()
 * 输出str对应的字符数组 char[] strCharArr = new char[sLen]
 * 
 * 先计算各行子串s1 s2 s3...的长度数组strLenArr，
 * 然后使用2层for循环，依次对各行子串进行遍历，
 * 依次将各个字符复制到strCharArr中，最后返回new String(strCharArr)
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
					Arrays.fill(strLenArr, 1, numRows-nRemain, nGroup);
					Arrays.fill(strLenArr, numRows-nRemain, numRows-1, nGroup+1);	
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
		char[] sCharArr = s.toCharArray();
		char[] strCharArr = new char[sLen];
		int[] strLenArr = getStrLenArr(sLen, numRows); 
		
		int i_char = 0;
		int idx = -1;
		int groupLen2 = 2*groupLen;
		
		for (int i_Group = 0; i_Group < strLenArr[0]; i_Group++) {
			idx = i_Group*groupLen2;
			strCharArr[i_char++] = sCharArr[idx];
		}
		
		if(numRows>2) {
			for (int i_row = 1; i_row < groupLen; i_row++) {
				for (int i_Group = 0; i_Group < strLenArr[i_row]; i_Group++) {
					idx = i_Group*groupLen + ((i_Group%2==0)?i_row:groupLen-i_row);
					strCharArr[i_char++] = sCharArr[idx];
				}
			}	
		}
		
		for (int i_Group = 0; i_Group < strLenArr[groupLen]; i_Group++) {
			idx = (2*i_Group+1)*groupLen;
			strCharArr[i_char++] = sCharArr[idx];
		}
		return new String(strCharArr);
	}
	
	
	public static void main(String[] args) {
		String s = "PAYPALISHIRING"; //4 "PINALSIGYAHRPI"
		//String s = "PAYPALISHIRING"; //3 "PAHNAPLSIIGYIR"
		//String s = "123456789012345678"; 
		//String s = "12345"; 
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
