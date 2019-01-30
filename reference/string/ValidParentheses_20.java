package string;

/**
 * @author Apollo4634
 * @date 2019/01/30
 * @problem 20
 */

public class ValidParentheses_20 {
	
	//Solution
	public boolean isValid(String s) {
		int sLen = s.length();
		if(sLen%2==1) return false;//s包含奇数个字符
		int top = -1;//栈顶
		int N = sLen>>1;//栈的最大容量
		char[] stack = new char[N];//栈
		for(int i = 0; i < sLen; i++) {
			char c = s.charAt(i);
			if (c=='[' || c=='(' || c=='{') {
				top++;
				if(top==N) return false;
				stack[top] = c;//入栈
			} else {
				if(top<0) return false;
				if(Math.abs(c-stack[top])>3) return false;//括号不匹配
				top--;//栈顶下移
			}
		}
		return top==-1;
	}
}
