package string;

import java.util.LinkedList;
import java.util.List;

/**
 * @author -
 * @creation 2019/01/22
 * @problem 17
 */

public class LetterCombinationsOfAPhoneNumber_17 {

	//Approch1
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
			numbers[iDigit] = digits.charAt(iDigit)-'0'-2;
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


	//Approch2
	public List<String> letterCombinations2(String digits) {
        String[] s = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new LinkedList<>();
        if (digits.length() == 0) return list;
        dfs(list, s, "", digits, digits.length());
        return list;
    }
    
    public void dfs(List<String> list, String[] s, String t, String d, int len) {
        if (t.length() == len) {
            list.add(t);
            return;
        }
        
        String str = s[d.charAt(0) - '0'];
        for (int i = 0; i < str.length(); i++) {
            dfs(list, s, t + str.charAt(i), d.substring(1), len);
        }
        
    }
	
}
