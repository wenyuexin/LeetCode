package array.solution;

import java.util.Arrays;

/**
 * 要求：将矩阵顺时针选择90度
 * 思路：逐层旋转，每次选定4个数进行变换
 *
 * @author Apollo4634
 * @create 2019/07/28
 * @problem 48
 * @tag Array
 */

public class RotateImage_48 {
    //Recommend
    static class Solution {
        public void rotate(int[][] matrix) {

            int layerNum = matrix.length / 2;
            for (int i = 0; i < layerNum; i++) {
                int rotateTimes = matrix.length - 2*i - 1;
                for (int j = 0; j < rotateTimes; j++) {
                    swap(matrix, i, matrix.length-1-i, j);
                }
            }
        }

        void swap(int[][] matrix, int b1, int b2, int offset) {
            int tmp = matrix[b1][b1+offset];//top-left
            matrix[b1][b1+offset] = matrix[b2-offset][b1];//bottom-left -> top-left
            matrix[b2-offset][b1] = matrix[b2][b2-offset];//bottom-right -> bottom-left
            matrix[b2][b2-offset] = matrix[b1+offset][b2];//top-right -> bottom-left
            matrix[b1+offset][b2] = tmp;//top-left -> top-right
            //System.out.println(Arrays.deepToString(matrix));
        }
    }


    public static void main(String[] args) {
//        int[][] matrix = new int[][] {
//                { 1,2,3 },
//                { 4,5,6 },
//                { 7,8,9 }
//        };

        int[][] matrix = new int[][] {
                { 0,1,2,3 },
                { 10,11,12,13 },
                { 20,21,22,23 },
                { 30,31,32,33 }
        };

        System.out.println("Input:  "+ Arrays.deepToString(matrix));

        long start = System.nanoTime();
        new Solution().rotate(matrix);
        long end = System.nanoTime();

        System.out.println("Output: "+ Arrays.deepToString(matrix));
        System.out.println("Runtime: "+(end-start)/1.0E6+" ms");
    }
}
