package math.reference;

/**
 * @author Apollo4634
 * @create 2019/08/01
 * @problem 50
 * @tag Math
 * @tag Binary Search
 * @see math.solution.PowXN_50
 */

public class PowXN_50 {
    static class Solution {
        public double myPow(double x, int n) {
            int m = n < 0 ? -n - 1 : n;
            double p = 1.0;
            for (double q = x; m > 0; m = m/2) {
                if ((m & 1) != 0) {
                    p *= q;
                }
                q *= q;
            }
            return n < 0 ? 1.0 / p / x : p;
        }
    }
}
