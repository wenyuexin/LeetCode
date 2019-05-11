package math.reference;

/**
 * @author -
 * @date 2019/02/01
 * @problem 12
 */

public class IntegerToRoman_12 {

	//My solution
	private static int[] basicValues = new int[] {
			1,4,5,9,10,40,50,90,100,400,500,900,1000};
	private static String[] basicSymbols = new String[] {
			"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
	
	public String intToRoman(int num) {
		int idx = 12;
		if(num<=10) { idx = 4; } 
		else if(num<=100) { idx = 8; }
		
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
	
}
