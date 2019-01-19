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
	private static char[][] mapping = new char[][] {
		{'a','b','c'}, {'d','e','f'}, {'g','h','i'},
		{'j','k','l'}, {'m','n','o'}, {'p','q','r','s'},
		{'t','u','v'}, {'w','x','y','z'}
	};
	
	private static final int[] lens = new int[] {3,3,3,3,3,4,3,4};
	
	private int[] state; //字符的组合状态
	
	private static String getStr(int idx) {
		
		
		return "";
	}
	
	public List<String> letterCombinations(String digits) {
		List<String> strList = new LinkedList<>(); //output
		int nDigits = digits.length();
		if(nDigits==0) return strList;
		
		int nStr = 1; //输出字符串数组的长度
		int[] digitsArr = new int[nDigits];
		state = new int[nDigits];
		for (int iDigit = 0; iDigit < nDigits; iDigit++) {
			digitsArr[iDigit] = digits.charAt(iDigit)-50; //48+2
			nStr *= lens[digitsArr[iDigit]];
			state[iDigit] = 0;
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
