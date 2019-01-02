package math;

/** 
 * @author Apollo4634 
 * @creation 2019/01/01 17:01
 * 
 * No.12 Integer to Roman
 * 
 * 解题思路：
 * 感觉可以借鉴贪心算法的思想
 * 
 * 施工中... 2019-01-02
 * 
 * 参考：
 * I 1
 * V 5
 * X 10
 * L 50
 * C 100
 * D 500
 * M 1000
 */

public class IntegerToRoman2 {

	//Solution
	enum Symbol {I, V, X, L, C, D, M};
	
	public String intToRoman(int num) {
		int[] basicValue = new int[] {1,4,5,9,10,40,50,90,100,400,500,900,1000};
		String[] basicSymbolArr = new String[] {
				"I","IV","V","IX","X","IL","L","IC","C","ID","D","IM","M"};
		
		int residual = num;
		int nSymbol = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = basicSymbolArr.length-1; i>0; i--) {
			if(residual>=basicValue[i]) {
				nSymbol = residual/basicValue[i];
				sb.append(basicSymbolArr[i]);
				for (int j = 0; i < nSymbol-1; j++) {
					sb.append('I');				
				}
				residual -= basicValue[i];
				residual -= (nSymbol-1)*1000; //这里需要修改
			}
		}
		
		return sb.toString();
	}

	
	public static void main(String[] args) {
		
		char[] arr = new char[5];
		arr[0] = 'a';
		arr[1] = 'b';
		String s = new String(arr);
		System.out.println(s);
	}
}
