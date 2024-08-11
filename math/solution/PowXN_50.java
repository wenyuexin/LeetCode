package math.solution;

import java.util.Arrays;
import java.util.List;

/**
 * @author Apollo4634
 * @create 2019/07/31
 * @problem 50
 * @tag Math
 * @tag Binary Search
 * @see math.reference.PowXN_50
 * see java.lang.FdLibm.Pow
 */

public class PowXN_50 {
    static class Solution {
        public double myPow(double x, int n) {
            return Math.pow(x, n);
        }
    }


    static class Solution2 {
        public double myPow(double x, int n) {
            if (n == 0) return 1;
            if (n == 1) return x;
            if (Double.isNaN(x)) return Double.NaN;
            if (x == 0 && n < 0) return Double.NaN;
            if (x == 0 && n > 0) return 1.0;
            return calcPow(x, n);
        }

        private double calcPow(double x, int n) {
            boolean nIsPositive = n > 0;
            boolean nIsMinInteger = (n == Integer.MIN_VALUE);
            n = nIsMinInteger? Integer.MAX_VALUE : Math.abs(n);

            double ans = calc(x, n);
            if (nIsMinInteger) ans *= x;
            if (!nIsPositive) ans = 1/ans;
            return ans;
        }

        private double calc(double x, int n) {
            if (n < 3) {
                if (n == 0) return 1;
                if (n == 1) return x;
                return x * x;
            }
            double ans = calc(x, n/2);
            if (Double.isInfinite(ans)) return ans;
            ans = (n%2==1) ? x*ans*ans : ans*ans;
            return ans;
        }
    }


    static class Solution3 {
        public double myPow(double x, int n) {
            if (n == 0) return 1;
            if (n == 1) return x;
            if (x == 0) return (n < 0)? Double.NaN : 0.0;

            double ans = 1;
            if (n == Integer.MIN_VALUE) {
                ans = x;
                n += 1;
            }

            int nn = Math.abs(n);
            while (nn > 0) {
                double tmp = x;
                int m = 1;
                while (2*m > 0 && 2*m <= nn) {
                    m *= 2;
                    tmp *= tmp;
                    if (Double.isInfinite(ans)) {
                        return (n < 0)? 1/ans : ans;
                    }
                }
                ans *= tmp;
                nn -= m;
                if (Double.isInfinite(ans)) {
                    return (n < 0)? 1/ans : ans;
                }
            }
            return (n < 0)? 1/ans : ans;
        }
    }


    public static void main(String[] args) {
        double x = 0; // -100.0 < x < 100.0
        int n = 10;
        System.out.println("Input:  " + "x = " + x);
        System.out.println("Input:  " + "n = " + n);

        long t1 = System.nanoTime();
        double ans = new Solution3().myPow(x, n);
        long t2 = System.nanoTime();

        System.out.println("Output: " + ans);
        System.out.println("Runtime: " + (t2 - t1) / 1.0E6 + " ms");
    }
}
