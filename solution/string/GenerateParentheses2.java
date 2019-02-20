package string;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Apollo4634
 * @create 2019/02/01
 * @problem 22
 */

public class GenerateParentheses2 {

	//Solution
	private List<String> list;
	private int N;
	
	private void get(StringBuilder sb, int i, int L, int R) {
		if (L==N && R==N) {
			list.add(sb.toString());
		} else {
			int sign = 0;
			
			if (L>=R) {
				
			}			
		}
		
		
		return;
	}
	
	public List<String> generateParenthesis(int n) {
		list = new LinkedList<String>();
		N = n;
		
		int L=0, R=0;
		StringBuilder sb = new StringBuilder(2*n);
		
		get(sb, 0, L, R);
		
		
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
