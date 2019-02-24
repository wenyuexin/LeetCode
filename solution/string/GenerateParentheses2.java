package string;

import java.util.List;

/**
 * 
 * 
 * @author Apollo4634
 * @create 2019/02/01
 * @problem 22
 */

public class GenerateParentheses2 {

	//Solution
	private List<String> list;
	private int N;
	
	private void get(StringBuilder sb, boolean isLeft, int L, int R) {
		//boolean left = false;
		//boolean right = false;
		
		if (isLeft) L += 1;
		else        R += 1;
		
		if (L<R || L>N || R>N) return;
		if (L==N && R==N) {
			list.add(sb.toString());
		} else {
			
			
			get(sb, true, L+1, R);
			get(sb, false, L, R+1);
		}
		
		return;
	}
	
	
	public List<String> generateParenthesis(int n) {
		List<String> list = null;
		
		int L=0, R=0;
		StringBuilder sb = new StringBuilder();
		
		//if() {}
	
		
		
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
