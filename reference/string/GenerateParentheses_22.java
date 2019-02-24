package string;

import java.util.LinkedList;
import java.util.List;

/** 
 * @author - 
 * @create 2019/02/24
 * @problem 22
 */

public class GenerateParentheses_22 {
	
	//My Approch - Backtracking
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
}
