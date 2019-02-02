package string;

import java.util.List;

/**
 * @author Apollo4634
 * @create 2019/02/01
 * @problem 22
 */

public class GenerateParentheses2 {

	//Solution
	public List<String> generateParenthesis(int n) {
		List<String> list = null;
		
		
		
		
		return list;
	}
	
	
	public static void main(String[] args) {
		int n = 3;
		
		long t1 = System.nanoTime();
		GenerateParentheses2 obj = 
				new GenerateParentheses2();
		List<String> list = obj.generateParenthesis(n);
		long t2 = System.nanoTime();

		System.out.println("Input:   "+n);
		System.out.println("Output:  "+list);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
