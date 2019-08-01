package math.solution;

import java.util.Arrays;
import java.util.List;

/**
 * @author Apollo4634
 * @create 2019/07/31
 * @problem 50
 * @tag Math
 * @tag Binary Search
 * see math.reference.PowXN_50
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
            if (x == Double.POSITIVE_INFINITY && n > 0) return Double.POSITIVE_INFINITY;
            if (x == Double.POSITIVE_INFINITY && n < 0) return 0;
            if (x == Double.NEGATIVE_INFINITY && n > 0) return Double.NEGATIVE_INFINITY;
            if (x == Double.NEGATIVE_INFINITY && n < 0) return 0;
            if (x == 0 && n < 0) return Double.NaN;
            if (x == 0 && n > 0) return 1.0;
            return calcPow(x, n);
        }

        private double calcPow(double x, int n) {
            boolean xIsPositive = true;
            if (n % 2 == 1 && (Math.abs(x) / x < 0)) xIsPositive = false;
            x = Math.abs(x);
            boolean nIsPositive = (Math.abs(n) / n > 0);
            n = Math.abs(n); //有问题

            double ans = calc(x, n);
            if (!xIsPositive) ans = -ans;
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
            return (n%2==1) ? x*ans*ans : ans*ans;
        }
    }


    public static void main(String[] args) {
        double x = 2.; // -100.0 < x < 100.0
        int n = Integer.MIN_VALUE;
        System.out.println("Input:  " + "x = " + x);
        System.out.println("Input:  " + "n = " + n);

        long t1 = System.nanoTime();
        double ans = new Solution2().myPow(x, n);
        long t2 = System.nanoTime();

        System.out.println("Output: " + ans);
        System.out.println("Runtime: " + (t2 - t1) / 1.0E6 + " ms");
    }
}
