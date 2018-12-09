package string;

/** 
 * @author Apollo4634 
 * @creation 2018/12/09 16:12
 * 
 * No.6 ZigZag Conversion
 */

/**
 * 解题思路：
 * 
 * 
 * 
 */


public class ZigZagConversion {
	
	//Solution1
	public String convert(String s, int numRows) {		
		int sLen = s.length();
		if(numRows==1 || sLen==0) return s;
		int groupLen = 2*numRows-2;
		int nGroup = sLen/(2*numRows-2)+1;
		char[] sCharArr = s.toCharArray();
		char[][] strCharArr = new char[numRows][2*nGroup+2];
		int[] lenStrArr = new int[numRows];
		
		CONVERT:
		for (int i_Group=0; i_Group<nGroup; i_Group++) {
			int idx = i_Group*groupLen;
			for(int i_r=0; i_r<numRows; i_r++) {
				if(idx>sLen-1) break CONVERT;
				strCharArr[i_r][lenStrArr[i_r]] = sCharArr[idx];
				idx++;
				lenStrArr[i_r]++;
			}
			for(int i_r=numRows-2; i_r>0; i_r--) {
				if(idx>sLen-1) break CONVERT;
				strCharArr[i_r][lenStrArr[i_r]] = sCharArr[idx];
				idx++;
				lenStrArr[i_r]++;
			}
		}
		
		String str = "";
		for (int i = 0; i < numRows; i++) {
			str += new String(strCharArr[i], 0, lenStrArr[i]);
		}
		return str;
	}
	
	
	public static void main(String[] args) {
		//String s = "PAYPALISHIRING"; //nR=4, "PINALSIGYAHRPI"
		//String s = "PAYPALISHIRING"; //nR=3, "PAHNAPLSIIGYIR"
		String s = "a"; 
		int numRows = 1;
		
		long t1 = System.nanoTime();
		String str = new ZigZagConversion().convert(s, numRows);
		long t2 = System.nanoTime();
		
		System.out.println("intput: "+s);
		System.out.println("output: "+str);
		System.out.println(str.equals("PINALSIGYAHRPI"));
		System.out.println(str.equals("PAHNAPLSIIGYIR"));
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
