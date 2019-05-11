package math.solution;

/** 
 * 解题思路：
 * 借鉴贪心算法的思想
 * 
 * 参考：
 * I 1, V 5, X 10, L 50, C 100, D 500, M 1000
 * 
 * @author Apollo4634 
 * @creation 2019/01/01
 * @problem 12
 */

public class IntegerToRoman {

	private static int[] basicValues = new int[] {
			1,4,5,9,10,40,50,90,100,400,500,900,1000};
	private static String[] basicSymbols = new String[] {
			"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};

	//Solution - java11
	public String intToRoman(int num) {
		int nSymbol = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = basicValues.length-1; i>0; i--) {
			if(num>=basicValues[i]) {
				nSymbol = num/basicValues[i];
				sb.append(basicSymbols[i].repeat(nSymbol));
				num -= nSymbol*basicValues[i];
			}
		}
		return sb.toString();
	}

	
	//Solution2
	public String intToRoman2(int num) {
		int idx = 12;
		if(num<=10) { idx = 4; } 
		else if (num<=100) { idx = 8; }
		
		StringBuilder sb = new StringBuilder();
		while(num>0) {
			if(num<basicValues[idx]) { 
				idx--; continue; 
			}
			num -= basicValues[idx];
			sb.append(basicSymbols[idx]);
		}
		return sb.toString();
	}
	

	public static void main(String[] args) {
		//输入数字的范围是 1 至 3999
		int num = 3999; //MMMCMXCIX
		//int num = 1000; //M
		//int num = 3; //III

		long t1 = System.nanoTime();
		IntegerToRoman obj = new IntegerToRoman(); 
		String romanStr = obj.intToRoman2(num);
		long t2 = System.nanoTime();

		System.out.println("Input:  "+num);
		System.out.println("Output: "+romanStr);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
