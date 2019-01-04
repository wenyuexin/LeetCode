package math;

/** 
 * @author Apollo4634 
 * @creation 2019/01/04 23:01
 * 
 * No.13 Roman to Integer
 * 
 * 参考：
 * I 1, V 5, X 10, L 50, C 100, D 500, M 1000
 * 
 * I IV IX, X XL XC, C CD CM, V L D M
 * 
 * 解题思路：
 * 
 */

public class RomanToInteger2 {

	/*
	private static int[] basicValue = new int[] {
			1,4,5,9,10,40,50,90,100,400,500,900,1000};
	private static String[] basicSymbolArr = new String[] {
			"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
	 */

	//Solution - 施工中
	public int romanToInt(String s) {
		char[] sCharArr = s.toCharArray();

		int num = 0;
		for (int i = 0; i < sCharArr.length; i++) {
			switch (sCharArr[i]) {
			case 'I': //I IV IX
				num += 1;
				if(i!=sCharArr.length-1) {
					if(sCharArr[i+1]=='V') { num += 3; i++; continue; }
					if(sCharArr[i+1]=='X') { num += 8; i++; continue; }
				}
				break;
			case 'V':
				num += 5;
				break;
			case 'X': //X XL XC
				num += 10;
				if(i!=sCharArr.length-1) {
					if(sCharArr[i+1]=='L') { num += 30; i++; continue; }
					if(sCharArr[i+1]=='C') { num += 80; i++; continue; }
				}
				break;
			case 'L':
				num += 50;
				break;
			case 'C': //C CD CM
				num += 100;
				if(i!=sCharArr.length-1) {
					if(sCharArr[i+1]=='D') { num += 300; i++; continue; }
					if(sCharArr[i+1]=='M') { num += 800; i++; continue; }
				}
				break;
			case 'D':
				num += 500;
				break;
			case 'M':
				num += 1000;
				break;
			default:
				break;
			}
		}
		return num;
	}


	public static void main(String[] args) {
		//输入字符串对应数字的范围是 1 至 3999
		String s = "LVIII"; //58
		//String s = "MCMXCIV"; //1994
		//String s = "III"; //3

		long t1 = System.nanoTime();
		int num = new RomanToInteger2().romanToInt(s);
		long t2 = System.nanoTime();

		System.out.println("input: "+s);
		System.out.println("output: "+num);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
