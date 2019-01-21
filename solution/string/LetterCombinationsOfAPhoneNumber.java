package string;


import java.util.Arrays;
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
	private static final char[][] mapping = new char[][] {
		{'a','b','c'}, {'d','e','f'}, {'g','h','i'}, //2(0) 3(1) 4(2)
		{'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, //5(3) 6(4) 7(5) 
		{'t','u','v'}, {'w','x','y','z'} //8(6) 9(7)
	};
	
	private static final int[] lensArr = new int[] {3,3,3,3,3,4,3,4};
	
	public List<String> letterCombinations(String digits) {
		List<String> strList = new LinkedList<>(); //output
		int nDigits = digits.length();
		if(nDigits==0) return strList;
		
		int[] digitsArr = new int[nDigits];//输入字符串转int数组
		int[] state = new int[nDigits];//字符的组合状态
		int nStr = 1; //输出字符串的总数
		StringBuilder sb = new StringBuilder();
		for (int iDigit = 0; iDigit < nDigits; iDigit++) {
			digitsArr[iDigit] = digits.charAt(iDigit)-50; //48+2
			nStr *= lensArr[digitsArr[iDigit]];
			sb.append(mapping[digitsArr[iDigit]][0]);
		}
		//System.out.println(Arrays.toString(digitsArr)+" "+sb);
		
		int iStr = 0;
		int carrier = 0;
		while (iStr<nStr) {
			strList.add(sb.toString());
			//System.out.print(iStr+" "+Arrays.toString(state)+" ");
			carrier = 1;
			for (int iDigit = nDigits-1; iDigit>=0; iDigit--) {
				if(carrier==0) break; 
				if(state[iDigit]+carrier<lensArr[digitsArr[iDigit]]) { 
					state[iDigit] += carrier;
					sb.setCharAt(iDigit, mapping[digitsArr[iDigit]][state[iDigit]]);
					carrier = 0;
				} else {
					state[iDigit] = 0;
					sb.setCharAt(iDigit, mapping[digitsArr[iDigit]][0]);		
					carrier = 1;
				}
			}
			iStr++;
		}
		return strList;
	}

	
	public static void main(String[] args) {
		String digits = "23";
		
		long t1 = System.nanoTime();
		LetterCombinationsOfAPhoneNumber obj = 
				new LetterCombinationsOfAPhoneNumber();
		List<String> strList = obj.letterCombinations(digits);
		long t2 = System.nanoTime();

		System.out.println("input:   "+digits);
		System.out.println("output:  "+strList.size()+" "+strList);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
