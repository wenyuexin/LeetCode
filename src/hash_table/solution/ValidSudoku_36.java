package hash_table.solution;

import java.util.Arrays;

/**
 * @author Apollo4634
 * @create 2019/06/27
 * @problem 36
 * @tag Hash Table
 * @see hash_table.reference.ValidSudoku_36
 */

public class ValidSudoku_36 {
    static class Solution {
        boolean[] marked = new boolean[9];

        public boolean isValidSudoku(char[][] board) {
            for (int r = 0; r < 9; r++) {
                if (!isValid(board[r])) return false;
            }

            char[] line = new char[9];
            for (int col = 0; col < 9; col++) {
                int idx = 0;
                fillWithBlank(line);
                for (int row = 0; row < 9; row++) {
                    char ch = board[row][col];
                    if (ch != '.') line[idx++] = ch;
                }
                if (!isValid(line)) return false;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int idx = 0;
                    fillWithBlank(line);
                    for (int p = 0; p < 3; p++) {
                        for (int q = 0; q < 3; q++) {
                            char ch = board[3 * i + p][3 * j + q];
                            if (ch != '.') line[idx++] = ch;
                        }
                    }
                    if (!isValid(line)) return false;
                }
            }
            return true;
        }

        private void fillWithBlank(char[] arr) {
            for (int i = 0; i < arr.length && arr[i] != ' '; i++) {
                arr[i] = ' ';
            }
        }

        private boolean isValid(char[] line) {
            Arrays.fill(marked, false);
            for (char c: line) {
                if (c == ' ') break;
                if (c == '.') continue;
                if (marked[c-'1']) {
                    return false;
                } else {
                    marked[c-'1'] = true;
                }
            }
            return true;
        }
    }


    public static void main(String[] args) {
        char[][] board = new char[][] { //true
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

//        char[][] board = new char[][] { //false
//                { '8','3','.','.','7','.','.','.','.' },
//                { '6','.','.','1','9','5','.','.','.' },
//                { '.','9','8','.','.','.','.','6','.' },
//                { '8','.','.','.','6','.','.','.','3' },
//                { '4','.','.','8','.','3','.','.','1' },
//                { '7','.','.','.','2','.','.','.','6' },
//                { '.','6','.','.','.','.','2','8','.' },
//                { '.','.','.','4','1','9','.','.','5' },
//                { '.','.','.','.','8','.','.','7','9' }
//        };

//        char[][] board = new char[][] { //false
//            {'.','.','.','.','5','.','.','1','.'},
//            {'.','4','.','3','.','.','.','.','.'},
//            {'.','.','.','.','.','3','.','.','1'},
//            {'8','.','.','.','.','.','.','2','.'},
//            {'.','.','2','.','7','.','.','.','.'},
//            {'.','1','5','.','.','.','.','.','.'},
//            {'.','.','.','.','.','2','.','.','.'},
//            {'.','2','.','9','.','.','.','.','.'},
//            {'.','.','4','.','.','.','.','.','.'}
//        };


        System.out.println("Input:  "+ Arrays.deepToString(board));

        long t1 = System.nanoTime();
        boolean valid = new Solution().isValidSudoku(board);
        long t2 = System.nanoTime();

        System.out.println("Output: "+valid);
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
