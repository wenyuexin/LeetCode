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
 * 输入digits是一个包含多个数字的字符串，每个数字对应3至4种可能的字母，
 * 这里使用二维数组mapping保存数字和字母的对应关系；
 * 同时，为了便于从mapping中读取字母，先将digits转化为int数组numbers，
 * 并将数字的数值减2，例如，digits="639"时，numbers=[4,1,7]
 * 
 * 假设字符串digits里的数字个数为nDigits
 * 设输出的结果为strList，该列表中有nStr个字符串
 * 假设digits某一位数字对应的字母总数即为该位的基数radix
 * 
 * 这里使用状态数组state表示当前的字母组合str，例如，当digits="639"时，
 * state的初始值为[0,0,0]，可知数字6对应3个字母['m','n','o']，
 * 数字3对应3个字母['d','e','f']，数字9对应4个字母['w','x','y','z']，
 * 因此总共存在3*3*4=36种可能的组合，即nStr=36
 * 依次更新状态并获取对应的str，当state从[0,0,0]变为[2,2,3]时，
 * 就获得了对所有可能的字母组合
 * 
 * 更新state的方法类似于使用数组实现加法计算，每次更新就是执行state+1
 * 具体示例如下，仍然以digits="639"为例，state=[0,0,0]时，
 * state+1=[0,0,1]，state+2=[0,0,2]，state+3=[0,0,3]，
 * state+4=[0,1,0]，state+5=[0,1,1]，state+6=[0,1,2]，
 * state+7=[0,1,3]，...，state+35=[2,2,3]
 * 
 * 更为通用的描述如下，假设某状态下state=[sn,...,s1,s0]
 * 先判断s0+1是否小于对应的基数（数字7和9的基数为4，其他数字的基数为3）
 * 若满足小于关系，则不存在进位，直接令s0=s0+1，然后完成更新，
 * 若不满足，则说明存在进位操作，此时令s0=0，然后对s1执行以上过程，
 * 以此类推直到最后一位sn
 * 
 * 需要说明的是，state和某种字母组合str是一一对应的关系，
 * 每次更新state时，state中有些位存在更改，而有些位不存在更改，
 * 因而只需要基于上一次的str修改那些存在变化的位上的字母即可
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
		
		int[] numbers = new int[nDigits]; //输入字符串转int数组
		int[] state = new int[nDigits]; //字符的组合状态
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
				if(state[iDigit]+1<radix) { //不进位，直接加1
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
