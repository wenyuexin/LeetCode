package array.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Apollo4634
 * @create 2019/08/07
 * @problem 54
 * @tag Array
 */

public class SpiralMatrix_54 {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> list = new LinkedList<>();
            if (matrix == null || matrix.length == 0)  return list;
            int rows = matrix.length;
            int cols = matrix[0].length;
            int nLayer = (matrix.length+1) / 2;
            for (int i = 0; i < nLayer; i++) {
                addElements(matrix, list, true, i, i, cols-i-1, 1);
                addElements(matrix, list, false, cols-i-1, i+1, rows-i-1, 1);
                addElements(matrix, list, true, rows-i-1, cols-i-2, i, -1);
                addElements(matrix, list, false, i, rows-i-2, i+1, -1);
            }
            return list;
        }

        private void addElements(int[][] matrix, List<Integer> list, boolean inRow, int line, int from, int to, int step) {
            if (step > 0 && from > to) return;
            if (step < 0 && from < to) return;
            to += step;
            System.out.println(""+inRow+" "+line+" "+from+" "+to+" "+step);
            if (inRow) {
                for (int i = from; i != to; i += step)
                    list.add(matrix[line][i]);
            } else {
                for (int i = from; i != to; i += step)
                    list.add(matrix[i][line]);
            }
        }
    }


    public static void main(String[] args) {
//        int[][] matrix = new int[][] {
//                { 1, 2, 3 },
//                { 4, 5, 6 },
//                { 7, 8, 9 }
//        };

//        int[][] matrix = new int[][] {
//                { 1 }
//        };

        int[][] matrix = new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };

        System.out.println("Input:  "+ Arrays.deepToString(matrix));

        long start = System.nanoTime();
        List<Integer> list = new Solution().spiralOrder(matrix);
        long end = System.nanoTime();

        System.out.println("Output: "+ list);
        System.out.println("Runtime: "+(end-start)/1.0E6+" ms");
    }
}
