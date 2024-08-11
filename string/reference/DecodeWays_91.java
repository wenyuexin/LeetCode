package string.reference;

/**
 * 假设f(n)表示前n位的字符串有f(n)种解码方式，那么
 * f(n) = flag * [f(n-1) + flag2 * f(n-2)]
 * 其中，flag表示第n位字符不是'0'，
 * flag2表示第n-1位和第n位的字符可以被正确解码
 *
 * @author Apollo4634
 * @create 2019/10/05
 * @problem 91
 * @tag String
 * @tag Dynamic Programming
 * @see string.solution.DecodeWays_91
 */

public class DecodeWays_91 {
    static class Solution {
        public int numDecodings(String s) {
            char[] str = s.toCharArray();
            int prev1 = 1, prev2 = 1;
            for (int i = 0; i < str.length; i++) {
                int cur = prev1;
                if (str[i] == '0') cur = 0;
                if (i > 0) {
                    int num = (str[i-1]-'0')*10 + str[i] - '0';
                    if (num >= 10 && num <= 26)
                        cur += prev2;
                }
                if (cur == 0) return 0;
                prev2 = prev1;
                prev1 = cur;
            }
            return prev1;
        }
    }
}
