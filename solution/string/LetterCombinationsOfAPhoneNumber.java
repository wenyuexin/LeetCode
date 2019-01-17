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
	
	//Solution
	private static char[][] mapping = new char[][] {
		{'a','b','c'}, {'d','e','f'}, {'g','h','i'},
		{'j','k','l'}, {'m','n','o'}, {'p','q','r','s'},
		{'t','u','v'}, {'w','x','y','z'}
	};
	
	private static int[] lens = new int[] {3,3,3,3,3,4,3,4};
	
	public List<String> letterCombinations(String digits) {
		List<String> strList = new LinkedList<>(); //output
		int nDigits = digits.length();
		if(nDigits==0) return strList;
		
		int[] digitsArr = new int[nDigits];
		for (int i = 0; i < nDigits; i++) {
			digitsArr[i] = digits.charAt(i)-50; //48+2
		}
		
		int nStr = 1;
		for (int i = 0; i < nDigits; i++) { 
			nStr *= lens[digitsArr[i]];
		}
		System.out.println(nStr);
		
		
		
		
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
