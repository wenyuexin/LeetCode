package string.reference;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode solution:
 * https://leetcode.com/problems/zigzag-conversion/solution/
 * 
 * @author -
 * @create 2019/02/01
 * @problem 6
 */

public class ZigZagConversion_6 {

	/*
	 * Approach 1: Sort by Row
	 * 
	 * By iterating through the string from left to right, 
	 * we can easily determine which row in the Zig-Zag pattern 
	 * that a character belongs to.
	 */
	public String convert(String s, int numRows) {
		if (numRows == 1) return s;

		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0; i < Math.min(numRows, s.length()); i++)
			rows.add(new StringBuilder());

		int curRow = 0;
		boolean goingDown = false;
		for (char c : s.toCharArray()) {
			rows.get(curRow).append(c);
			if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
			curRow += goingDown ? 1 : -1;
		}

		StringBuilder ret = new StringBuilder();
		for (StringBuilder row : rows) ret.append(row);
		return ret.toString();
	}


	/*
	 * Approach 2: Visit by Row - Recommend
	 * 
	 * Visit the characters in the same order 
	 * as reading the Zig-Zag pattern line by line.
	 */
	public String convert2(String s, int numRows) {
		if (numRows == 1) return s;

		StringBuilder ret = new StringBuilder();
		int sLen = s.length();
		int cycleLen = 2 * numRows - 2;

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j + i < sLen; j += cycleLen) {
				ret.append(s.charAt(j + i));
				if (i != 0 && i != numRows - 1 && j + cycleLen - i < sLen)
					ret.append(s.charAt(j + cycleLen - i));
			}
		}
		return ret.toString();
	}


	/*Approach 3: My solution*/
	public String convert3(String s, int numRows) {
		int sLen = s.length();
		if(numRows==1 || sLen==0 || sLen<numRows) return s;

		int groupLen = numRows-1;
		int nGroup = sLen/groupLen;
		int nRemain = sLen%groupLen;	
		char[] sCharArr = s.toCharArray();
		char[][] strCharArr = new char[numRows][nGroup+((nRemain>0)?1:0)];
		int[] lenStrArr = new int[numRows]; //各行子串的长度

		int idx = 0; //i_Group*groupLen;
		for (int i_Group=0; i_Group<nGroup; i_Group++) {
			if(i_Group%2==0) {
				for(int i_r=0; i_r<groupLen; i_r++) 
					strCharArr[i_r][lenStrArr[i_r]++] = sCharArr[idx++];
			} else {
				for(int i_r=numRows-1; i_r>0; i_r--) 
					strCharArr[i_r][lenStrArr[i_r]++] = sCharArr[idx++];
			}
		}

		if(nRemain>0) {
			if(nGroup%2==0) {
				for(int i_r=0; i_r<nRemain; i_r++) 
					strCharArr[i_r][lenStrArr[i_r]++] = sCharArr[idx++];
			} else {
				for(int i_r=numRows-1; i_r>numRows-nRemain-1; i_r--) 
					strCharArr[i_r][lenStrArr[i_r]++] = sCharArr[idx++];
			}
		}

		int destPos = 0;
		char[] strCharArr2 = new char[sLen];
		for (int i = 0; i < numRows; i++) {
			System.arraycopy(strCharArr[i],0,strCharArr2,destPos,lenStrArr[i]);
			destPos += lenStrArr[i];
		}
		return new String(strCharArr2);
	}

}
