package hash_table.solution;

import java.util.Arrays;

/**
 * @author Apollo4634
 * @create 2019/06/27
 * @problem 36
 * @tag Hash Table
 */

public class ValidSudoku_36 {
    static class Solution {
        public boolean isValidSudoku(char[][] board) {

            return false;
        }

        private boolean isValidLine(char[] line) {
            boolean[] marked = new boolean[9];

            return false;
        }
    }


    public static void main(String[] args) {
        char[][] board = new char[][] {
                { '5','3','.','.','7','.','.','.','.' },
                { '6','.','.','1','9','5','.','.','.' },
                { '.','9','8','.','.','.','.','6','.' },
                { '8','.','.','.','6','.','.','.','3' },
                { '4','.','.','8','.','3','.','.','1' },
                { '7','.','.','.','2','.','.','.','6' },
                { '.','6','.','.','.','.','2','8','.' },
                { '.','.','.','4','1','9','.','.','5' },
                { '.','.','.','.','8','.','.','7','9' }
        };

        char[][] board2 = new char[][] {
                { '8','3','.','.','7','.','.','.','.' },
                { '6','.','.','1','9','5','.','.','.' },
                { '.','9','8','.','.','.','.','6','.' },
                { '8','.','.','.','6','.','.','.','3' },
                { '4','.','.','8','.','3','.','.','1' },
                { '7','.','.','.','2','.','.','.','6' },
                { '.','6','.','.','.','.','2','8','.' },
                { '.','.','.','4','1','9','.','.','5' },
                { '.','.','.','.','8','.','.','7','9' }
        };

        System.out.println("Input:  "+ Arrays.deepToString(board));

        long t1 = System.nanoTime();
        boolean valid = new Solution().isValidSudoku(board);
        long t2 = System.nanoTime();

        System.out.println("Output: "+valid);
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
