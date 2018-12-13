package string;

//import java.util.Arrays;

/** 
 * @author Apollo4634 
 * @creation 2018/12/09 16:12
 * 
 * No.6 ZigZag Conversion
 *
 * 解题思路：
 * (参考problem文件夹中的0006_ZigZagConversion.md)
 * 先将输入字符串s按Z字形排列得到二维字符数组strCharArr（忽略空格）
 * 然后得到各行字符串s1 s2 s3 ... 最后拼接各行字符串得到结果str
 * 
 * 以下两个solution大同小异，推荐solution2
 */


public class ZigZagConversion {
	
	//Solution1
	public String convert(String s, int numRows) {		
		int sLen = s.length();
		if(numRows==1 || sLen==0) return s;
		
		//long t1 = System.nanoTime();
		int groupLen = 2*numRows-2;
		int nGroup = sLen/(2*numRows-2)+1;
		char[] sCharArr = s.toCharArray();
		char[][] strCharArr = new char[numRows][2*nGroup];
		int[] lenStrArr = new int[numRows]; //各行子串的长度
		//long t2 = System.nanoTime();
		//System.out.println("Rumtime12: "+(t2-t1)/1.0E6+" ms");
		
		CONVERT:
		for (int i_Group=0; i_Group<nGroup; i_Group++) {
			int idx = i_Group*groupLen;
			for(int i_r=0; i_r<numRows; i_r++) {
				if(idx>sLen-1) break CONVERT;
				strCharArr[i_r][lenStrArr[i_r]++] = sCharArr[idx++];
			}
			for(int i_r=numRows-2; i_r>0; i_r--) {
				if(idx>sLen-1) break CONVERT;
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
	
	//Solution2 - Recommendation
	//2018-12-14 01:02
	public String convert2(String s, int numRows) {	
		//long t1 = System.nanoTime();
		int sLen = s.length();
		if(numRows==1 || sLen==0 || sLen<numRows) return s;
		
		//long t2 = System.nanoTime();
		int groupLen = numRows-1;
		int nGroup = sLen/groupLen;
		int nRemain = sLen%groupLen;	
		char[] sCharArr = s.toCharArray();
		char[][] strCharArr = new char[numRows][nGroup+((nRemain>0)?1:0)];
		int[] lenStrArr = new int[numRows]; //各行子串的长度
		
		//long t3 = System.nanoTime();
		int idx = 0; //i_Group*groupLen;
		for (int i_Group=0; i_Group<nGroup; i_Group++) {
			if(i_Group%2==0) {
				for(int i_r=0; i_r<groupLen; i_r++) {
					strCharArr[i_r][lenStrArr[i_r]++] = sCharArr[idx++];
				}
			} else {
				for(int i_r=numRows-1; i_r>0; i_r--) {
					strCharArr[i_r][lenStrArr[i_r]++] = sCharArr[idx++];
				}
			}
		}
		
		//long t4 = System.nanoTime();
		if(nRemain>0) {
			if(nGroup%2==0) {
				for(int i_r=0; i_r<nRemain; i_r++) {
					strCharArr[i_r][lenStrArr[i_r]++] = sCharArr[idx++];
				}
			} else {
				for(int i_r=numRows-1; i_r>numRows-nRemain-1; i_r--) {
					strCharArr[i_r][lenStrArr[i_r]++] = sCharArr[idx++];
				}
			}
		}
		//System.out.println(Arrays.deepToString(strCharArr));
		
		//long t5 = System.nanoTime();
		int destPos = 0;
		char[] strCharArr2 = new char[sLen];
		for (int i = 0; i < numRows; i++) {
			System.arraycopy(strCharArr[i],0,strCharArr2,destPos,lenStrArr[i]);
			destPos += lenStrArr[i];
		}
		
		/*
		long t6 = System.nanoTime();
		System.out.println("Rumtime12: "+(t2-t1)/1.0E6+" ms");
		System.out.println("Rumtime23: "+(t3-t2)/1.0E6+" ms");
		System.out.println("Rumtime34: "+(t4-t3)/1.0E6+" ms");
		System.out.println("Rumtime45: "+(t5-t4)/1.0E6+" ms");
		System.out.println("Rumtime56: "+(t6-t5)/1.0E6+" ms");
		long t7 = System.nanoTime();
		System.out.println("Rumtime67: "+(t7-t6)/1.0E6+" ms");
		System.out.println("Rumtime16: "+(t6-t1)/1.0E6+" ms");
		*/
		return new String(strCharArr2);
	}
	
	public static void main(String[] args) {
		//String s = "PAYPALISHIRING"; //nR=4, "PINALSIGYAHRPI"
		//String s = "PAYPALISHIRING"; //nR=3, "PAHNAPLSIIGYIR"
		//String s = "a"; 
		String s = "1234567890123456"; 
		int numRows = 4;
		
		long t1 = System.nanoTime();
		String str = new ZigZagConversion().convert2(s, numRows);
		long t2 = System.nanoTime();
		
		System.out.println("intput: "+s);
		System.out.println("output: "+str);
		System.out.println(str.equals("PINALSIGYAHRPI"));
		System.out.println(str.equals("PAHNAPLSIIGYIR"));
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
