package math.solution;

import java.util.Arrays;

/**
 * 二分法,主要是得考虑到int的取值范围
 *
 * (int) sqrt(Integer.MAX_VALUE) == 46340
 *
 * @author Apollo4634
 * @create 2019/08/06
 * @problem 96
 * @tag Math
 * @tag Binary Search
 */

public class SqrtX_69 {
    static class Solution {
        public int mySqrt(int x) {
            if (x == 0) return 0;
            if (x < 4) return 1;

            int left = 3;
            int right = x/2+1;
            if (right > 46340) right = 46340;
            int mid;
            int product;
            while (left <= right) {
                mid = (left + right)/2;
                product = mid * mid;
                if (product == x) {
                    return mid;
                } else if (product > x) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left-1;
        }
    }


    public static void main(String[] args) {
        System.out.println(Math.sqrt(Math.pow(2,31)-1));
        int x = 2147395599; //x>=0
        System.out.println("Input:  "+ x);

        long start = System.nanoTime();
        int largestSum = new Solution().mySqrt(x);
        long end = System.nanoTime();

        System.out.println("Output: "+ largestSum);
        System.out.println("Runtime: "+(end-start)/1.0E6+" ms");
    }
}
