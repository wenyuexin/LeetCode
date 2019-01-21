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
 * 输入digits是一个包含多个数字的字符串，每个数字对应3至4中可能的字母，
 * 这里使用二维数mapping组保存数字和字母的对应关系
 * 
 * 首先将digits转化为int数组numbers，为了便于从mapping中读取字母，
 * 这里将数字的数值减2，例如，digits="6359"时，digitsArr=[4,1,3,7]
 * 
 * 基于numbers即可开始获取各种可能的字母组合：
 * 使用一个状态数组state表示当前的字母组合str，
 * 总体思路类似于使用数组加法计算，...
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
	
	public List<String> letterCombinations(String digits) {
		List<String> strList = new LinkedList<>(); //output
		int nDigits = digits.length();
		if(nDigits==0) return strList;
		
		int[] numbers = new int[nDigits];//输入字符串转int数组
		int[] state = new int[nDigits];//字符的组合状态
		int nStr = 1; //输出字符串的总数
		StringBuilder sb = new StringBuilder();
		for (int iDigit = 0; iDigit < nDigits; iDigit++) {
			numbers[iDigit] = digits.charAt(iDigit)-50; //48+2
			nStr *= ((numbers[iDigit]==5||numbers[iDigit]==7)?4:3);
			sb.append(mapping[numbers[iDigit]][0]);
		}
		
		int radix = 0; //基数
		while (nStr>0) {
			strList.add(sb.toString());
			for (int iDigit = nDigits-1; iDigit>=0; iDigit--) {
				radix = (numbers[iDigit]==5||numbers[iDigit]==7)?4:3;
				if(state[iDigit]+1<radix) { 
					state[iDigit]++;
					sb.setCharAt(iDigit, mapping[numbers[iDigit]][state[iDigit]]);
					break;
				} else { //进位
					state[iDigit] = 0;
					sb.setCharAt(iDigit, mapping[numbers[iDigit]][0]);
				}
			}
			nStr--;
		}
		return strList;
	}

	
	public static void main(String[] args) {
		String digits = "237";
		
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
