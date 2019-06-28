package hash_table.reference;

/**
 * @author Apollo4634
 * @create 2019/06/28
 * @problem 36
 * @tag Hash Table
 * @see hash_table.solution.ValidSudoku_36
 */

public class ValidSudoku_36 {
    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                boolean[] co = new boolean[9];
                boolean[] ro = new boolean[9];
                for (int j = 0; j < 9; j++) {
                    char c1 = board[j][i];
                    if (c1 != '.') {
                        if (co[c1-'1']) {
                            return false;
                        }
                        co[c1-'1'] = true;
                    }

                    char c2 = board[i][j];
                    if (c2 != '.') {
                        if (ro[c2-'1']) {
                            return false;
                        }
                        ro[c2-'1'] = true;
                    }
                }
            }

            for (int i = 0; i < 9; i++) {
                boolean[] sub = new boolean[9];
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        char c = board[j+3*(i/3)][k+3*(i%3)];
                        if (c != '.') {
                            if (sub[c-'1']) {
                                return false;
                            }
                            sub[c-'1'] = true;
                        }
                    }
                }
            }

            return true;
        }
    }
}
