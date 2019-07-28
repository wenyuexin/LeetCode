package array.solution;

import java.util.Arrays;

/**
 * @author Apollo4634
 * @create 2019/07/28
 * @problem 48
 * @tag Array
 */

public class RotateImage_48 {
    static class Solution {
        public void rotate(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    //todo swap
                }
            }
        }

        void swap(int[][] matrix, int r, int c) {

        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 1,2,3 },
                { 4,5,6 },
                { 7,8,9 }
        };
        System.out.println("Input:  "+ Arrays.deepToString(matrix));

        long start = System.nanoTime();
        new Solution().rotate(matrix);
        long end = System.nanoTime();

        System.out.println("Output: "+ Arrays.deepToString(matrix));
        System.out.println("Runtime: "+(end-start)/1.0E6+" ms");
    }
}
