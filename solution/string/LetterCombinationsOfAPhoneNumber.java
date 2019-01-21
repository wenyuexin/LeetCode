package string;


import java.util.LinkedList;
import java.util.List;

/** 
 * @author Apollo4634 
 * @creation 2019/01/16 19:01
 * 
 * No.17 Letter Combinations of a Phone Number
 * 
 * 解题思路：
 * 
 * 
 */

public class LetterCombinationsOfAPhoneNumber {
	
	//Solution - 施工中
	private static final char[][] mapping = new char[][] {
		{'a','b','c'}, {'d','e','f'}, {'g','h','i'},
		{'j','k','l'}, {'m','n','o'}, {'p','q','r','s'},
		{'t','u','v'}, {'w','x','y','z'}
	};
	
	private static final int[] lensArr = new int[] {3,3,3,3,3,4,3,4};
	
	//private int[] digitsArr;
	//private int[] state; //字符的组合状态
	//private StringBuilder sb;
	
	/*
	private static String getStr(int idx) {
		
		//更新组合状态
		String str = "";
		boolean isLastOne = false;
		for (int i = 0; i < state.length; i++) {
			if(state[i]+1==lens[digitsArr[i]]) { //进位
				
			} else {
				
			}
		}
		
		
		return str;
	}
	*/
	
	public List<String> letterCombinations(String digits) {
		List<String> strList = new LinkedList<>(); //output
		int nDigits = digits.length();
		if(nDigits==0) return strList;
		
		int[] digitsArr = new int[nDigits];
		int[] state = new int[nDigits];//字符的组合状态
		
		int nStr = 1; //输出字符串的总数
		for (int iDigit = 0; iDigit < nDigits; iDigit++) {
			digitsArr[iDigit] = digits.charAt(iDigit)-50; //48+2
			nStr *= lensArr[digitsArr[iDigit]];
		}
		
		StringBuilder sb = new StringBuilder();
		int iStr = 0;
		while (iStr<nStr) {
			for (int iDigit = nDigits-1; iDigit>0; iDigit--) {
				if(state[iDigit]+1<lensArr[digitsArr[iDigit]]) { 
					state[iDigit]++;
					sb.setCharAt(iDigit, mapping[digitsArr[iDigit]][state[iDigit]]);					
				} else {
					
				}
			}
			strList.add(sb.toString());
			iStr++;
		}
		
		return strList;
	}

	
	public static void main(String[] args) {
		String digits = "235";
		
		long t1 = System.nanoTime();
		LetterCombinationsOfAPhoneNumber obj = 
				new LetterCombinationsOfAPhoneNumber();
		List<String> strList = obj.letterCombinations(digits);
		long t2 = System.nanoTime();

		System.out.println("input:   "+digits);
		System.out.println("output:  "+strList);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
