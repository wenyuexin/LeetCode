package string;

//import java.util.Arrays;

/**
 * 依次遍历字符串s中的各个字符，若为 [ ( { 三种左括号之一则将字符压入栈，
 * 若为 ] ) } 三种右括号之一，则将栈顶元素弹出，判断弹出元素与当前字符是否匹配 
 * 
 * 在多次压栈入栈操作中，有一些特殊情况可以直接得到判断结果：
 * 假设输入的字符串的长度为sLen
 * 假设用于存储左括号的栈为stack
 * a) 若字符串s有效，则括号必须是成对出现的，因此s中的字符总数是偶数
 * b) 基于括号成对的原则，s中的左括号总数必然小于等于sLen/2，
 *   因此，如果stack中的元素大于sLen/2 (即上溢)，那么直接得出s无效
 * c) 如果某次循环中stack为空栈 (即下溢)，而当前s给出的字符是右括号，
 *   那么直接得出s无效
 * 
 * @author Apollo4634
 * @date 2019/01/29
 * @problem 20
 */

public class ValidParentheses2 {

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
	
	
	public static void main(String[] args) {
		//System.out.println((int)('[')); //91
		//System.out.println((int)(']')); //93
		//System.out.println((int)('(')); //40
		//System.out.println((int)(')')); //41
		//System.out.println((int)('{')); //123
		//System.out.println((int)('}')); //125
		
		//String s = "()[]{}";
		//String s = "([)]";
		//String s = "{[]}";
		//String s = "(()(";
		String s = "{{)}";
		//String s = "";
		
		long t1 = System.nanoTime();
		ValidParentheses2 obj = new ValidParentheses2();
		boolean validBool = obj.isValid(s);
		long t2 = System.nanoTime();
		
		System.out.println("input:   "+s);
		System.out.println("output:  "+validBool);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
