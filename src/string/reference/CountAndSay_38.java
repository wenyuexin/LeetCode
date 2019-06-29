package string.reference;

/**
 * 这里countAndSay函数的递归可以改成循环，
 * 该解法为每次Count and Say操作都new了一个数组，
 * 用于存放Count and Say的结果
 *
 * @author Apollo4634
 * @create 2019/06/29
 * @problem 38
 * @tag String
 * @see string.solution.CountAndSay_38
 */

public class CountAndSay_38 {
    class Solution {
        public String countAndSay(int n) {
            if (n < 1 || n > 30)
                throw new IllegalArgumentException("" + n);
            if (n == 1)
                return "1";
            String s = countAndSay(n-1);
            char[] buffer = new char[s.length() * 2];
            return new String(buffer, 0, fill(buffer, s));
        }

        int fill(char[] buffer, String s) {
            int current = 0;
            int si = 0;
            int l = s.length();
            while (si != l) {
                char c = s.charAt(si);
                int count = 1;
                while (si + count < l && s.charAt(si + count) == c) {
                    count++;
                }
                buffer[current++] = (char) (((int)'0') + count);
                buffer[current++] = c;
                si = si + count;
            }
            return current;
        }
    }
}
