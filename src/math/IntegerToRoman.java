package math;

import java.util.Arrays;

import array.ContainerWithMostWater2;

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
 * I 1    V 5    X 10    L 50
 * C 100  D 500  M 1000
 */

public class IntegerToRoman {

	private static int[] basicValue = new int[] {
			1,4,5,9,10,40,50,90,100,400,500,900,1000};
	private static String[] basicSymbolArr = new String[] {
			"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};

	//Solution - java11
	public String intToRoman(int num) {
		int residual = num;
		int nSymbol = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = basicValue.length-1; i>0; i--) {
			if(residual>=basicValue[i]) {
				nSymbol = residual/basicValue[i];
				sb.append(basicSymbolArr[i].repeat(nSymbol));
				residual -= nSymbol*basicValue[i];
			}
		}
		return sb.toString();
	}

	//Solution2
	public String intToRoman2(int num) {
		int residual = num;
		int nSymbol = 0;
		int idx = 12;
		if(residual<=10) {
			idx = 4;
		} else if (residual<=100) {
			idx = 8;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = idx; i>=0; i--) {
			if(residual>=basicValue[i]) {
				nSymbol = residual/basicValue[i];
				residual -= nSymbol*basicValue[i];
				while(nSymbol>0) {
					sb.append(basicSymbolArr[i]);
					nSymbol--;
				}
			}
		}
		return sb.toString();
	}

	//Solution3
	public String intToRoman3(int num) {
		int residual = num;
		int idx = 12;
		if(residual<=10) {
			idx = 4;
		} else if (residual<=100) {
			idx = 8;
		}
		
		StringBuilder sb = new StringBuilder(20);
		while(residual>0) {
			if(residual>=basicValue[idx]) {
				residual -= basicValue[idx];
				sb.append(basicSymbolArr[idx]);
			} else {
				idx--;
			}
		}
		return sb.toString();
	}
	

	public static void main(String[] args) {
		int num = 3999; //MMMCMXCIX
		//int num = 1000; //MMMCMXCIX
		//int num = 3; //III

		long t1 = System.nanoTime();
		String romanStr = new IntegerToRoman().intToRoman3(num);
		long t2 = System.nanoTime();

		System.out.println("input: "+num);
		System.out.println("output: "+romanStr);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
