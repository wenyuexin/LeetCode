package array.solution;

/**
 * @author Apollo4634
 * @create 2019/12/24
 * @problem 66
 * @tag Array
 */

public class PlusOne_66 {
    static class Solution {
        public int[] plusOne(int[] digits) {
            if (digits == null) return null;
            if (digits.length == 0) return digits;

            int c = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int s = digits[i] + c;
                c = s / 10;
                digits[i] = s % 10;
            }

            if (c == 0) return digits;
            int[] ret = new int[digits.length + 1];
            ret[0] = c;
            System.arraycopy(digits, 0, ret, 1, digits.length);
            return ret;
        }
    }
}
