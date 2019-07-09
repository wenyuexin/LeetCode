package math.solution;

/**
 * @author Apollo4634
 * @create 2019/07/09
 * @problem 67
 * @tag Math
 * @tag String
 */

public class AddBinary_67 {
    static class Solution {
        StringBuilder sb;

        public String addBinary(String a, String b) {
            if ("0".equals(a)) return b;
            if ("0".equals(b)) return a;

            if (a.length() > b.length()) {
                String temp = a;
                a = b;
                b = temp;
            }
            sb = new StringBuilder(b.length()+1);

            int c = 0;
            int aMaxIdx = a.length() - 1;
            int bMaxIdx = b.length() - 1;
            for (int i = 0; i <= aMaxIdx; i++) {
                int n1 = a.charAt(aMaxIdx - i) - '0';
                int n2 = b.charAt(bMaxIdx - i) - '0';
                c = calc(n1, n2, c);
            }

            int restMaxIdx = bMaxIdx - aMaxIdx - 1;
            for (int i = 0; i <= restMaxIdx; i++) {
                int n2 = b.charAt(restMaxIdx - i) - '0';
                c = calc(0, n2, c);
            }

            if (c == 1) sb.append('1');
            return sb.reverse().toString();
        }

        private int calc(int n1, int n2, int c) {
            int n = n1 + n2 + c;
            if (n == 0 || n == 2) {
                sb.append('0');
            } else {
                sb.append('1');
            }
            c = (n == 0 || n == 1)? 0 : 1;
            return c;
        }
    }


    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "11";

        System.out.println("Input:  "+num1);
        System.out.println("Input:  "+num2);

        long t1 = System.nanoTime();
        String sum = new Solution().addBinary(num1, num2);
        long t2 = System.nanoTime();

        System.out.println("Output: "+sum);
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
