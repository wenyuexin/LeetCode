package math.solution;


/**
 *
 *
 * @author Apollo4634
 * @create 2019/07/09
 * @problem 43
 * @tag Math
 * @tag String
 * @see math.reference.MultiplyStrings_43
 */

public class MultiplyStrings_43 {
    static class Solution {
        StringBuilder sb;
        int[] arr1;
        int[] arr2;

        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) return "0";
            if ("1".equals(num1)) return num2;
            if ("1".equals(num2)) return num1;

            int len = num1.length() + num2.length() - 1;
            sb = new StringBuilder(len+1);
            if (num1.length() >= num2.length()) {
                arr1 = toIntArray(num1);
                arr2 = toIntArray(num2);
            } else {
                arr1 = toIntArray(num2);
                arr2 = toIntArray(num1);
            }

            int c = 0;
            for (int i = 0; i < len; i++) {
                c = calc(i, c);
            }

            if (c > 0) sb.append(c);
            return sb.reverse().toString();
        }

        private int[] toIntArray(String s) {
            int max = s.length() - 1;
            int[] a = new int[max+1];
            for (int i = 0; i <= max; i++) {
                a[i] = s.charAt(max - i) - '0';
            }
            return a;
        }

        private int calc(int idx, int c) {
            int sum = c;
            for (int i2 = 0, i1 = idx-i2; i2 < arr2.length && i2 <= idx; i2++, i1 = idx-i2) {
                if (i1 >= arr1.length) continue;
                sum += (arr1[i1] * arr2[i2]);
            }
            c = sum / 10; //carry output
            sb.append((c > 0)? sum%10 : sum);
            return c;
        }
    }


    public static void main(String[] args) {
        String num1 = "4567";
        String num2 = "1234";

        System.out.println("Input:  "+num1);
        System.out.println("Input:  "+num2);

        long t1 = System.nanoTime();
        String product = new Solution().multiply(num1, num2);
        long t2 = System.nanoTime();

        System.out.println("Output: "+product);
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
