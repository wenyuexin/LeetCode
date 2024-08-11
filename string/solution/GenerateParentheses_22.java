package string.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * 对于输入n，可知存在2^(2n)种可能的括号组合，每种组合（字符串）的长度为2n
 * 由于每个位上存在'('和')'两种选择，因此可以将搜索2^(2n)种组合的过程视为
 * 搜索一颗高度为2n的平衡二叉树的过程，即典型的回溯(backtracking)过程
 * 
 * @author Apollo4634
 * @create 2019/02/01
 * @problem 22
 * @see GenerateParentheses_22
 */

public class GenerateParentheses_22 {

	//Solution
	private List<String> list;
	private StringBuilder sb;
	private int N;
	
	private void get(boolean isLeft, int L, int R) {
		if (L<R || L>N || R>N) return;
		
		if (isLeft) sb.setCharAt(L+R-1, '(');
		else        sb.setCharAt(L+R-1, ')');
		
		if (L==N && R==N) {
			list.add(sb.toString());
		} else {
			get(true, L+1, R);
			get(false, L, R+1);
		}
		return;
	}
	
	
	public List<String> generateParenthesis(int n) {
		N = n;
		list = new LinkedList<>();
		sb = new StringBuilder(2*N);
		sb.append(new char[2*N]);
		
		int L=0, R=0;
		get(true, L+1, R);
		get(false, L, R+1);
		return list;
	}
	
	
	public static void main(String[] args) {
		int n = 3;
		
		long t1 = System.nanoTime();
		GenerateParentheses_22 obj =
				new GenerateParentheses_22();
		List<String> list = obj.generateParenthesis(n);
		long t2 = System.nanoTime();

		System.out.println("Input:   "+n);
		System.out.println("Output:  "+list);
		System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
	}
}
