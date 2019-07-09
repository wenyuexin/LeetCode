package math.solution;

/**
 * @author Apollo4634
 * @create 2019/07/09
 * @problem 43
 * @tag Math
 * @tag String
 */

public class MultiplyStrings_43 {
    static class Solution {
        StringBuilder sb;
        char[] arr;

        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) return "0";
            if ("1".equals(num1)) return num2;
            if ("1".equals(num2)) return num1;
            sb = new StringBuilder();

            if (num1.length() > num2.length()) {
                String temp = num1;
                num1 = num2;
                num2 = temp;
            }
            arr = num1.toCharArray();

            int c = 0;
            for (int i = 0; i < num2.length(); i++) {
                c = calc(i,num2.charAt(i) - '0', c);
            }

            if (c > 0) sb.append(c);
            return sb.reverse().toString();
        }

        private int calc(int idx, int n2, int c) {
            int sum = c;
            for (int i = 0; i < arr.length; i++) {
                int n1 = arr[i] - '0';
                sum += (arr[i]*n2);
            }
            c = sum / 10;
            sb.append((c > 0)? sum%10 : sum);
            return c;
        }
    }


    public static void main(String[] args) {
        String num1 = "45";
        String num2 = "123";

        System.out.println("Input:  "+num1);
        System.out.println("Input:  "+num2);

        long t1 = System.nanoTime();
        String product = new Solution().multiply(num1, num2);
        long t2 = System.nanoTime();

        System.out.println("Output: "+product);
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
