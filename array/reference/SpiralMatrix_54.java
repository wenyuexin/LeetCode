package array.reference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Apollo4634
 * @create 2019/08/08
 * @problem 54
 * @tag Array
 * @see array.solution.SpiralMatrix_54
 * @see <a href="https://leetcode.com/problems/spiral-matrix/solution/">leetcode.com</a>
 */

public class SpiralMatrix_54 {

    /**
     * Simulation
     * Draw the path that the spiral makes. We know that the path should turn clockwise
     * whenever it would go out of bounds or into a cell that was previously visited.
     */
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            if (matrix.length == 0) return ans;
            int R = matrix.length, C = matrix[0].length;
            boolean[][] seen = new boolean[R][C];
            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};
            int r = 0, c = 0, di = 0;
            for (int i = 0; i < R * C; i++) {
                ans.add(matrix[r][c]);
                seen[r][c] = true;
                int cr = r + dr[di];
                int cc = c + dc[di];
                if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                    r = cr;
                    c = cc;
                } else {
                    di = (di + 1) % 4;
                    r += dr[di];
                    c += dc[di];
                }
            }
            return ans;
        }
    }


    /**
     * Layer-by-Layer
     * The answer will be all the elements in clockwise order from the first-outer layer,
     * followed by the elements from the second-outer layer, and so on.
     */
    static class Solution2 {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            if (matrix.length == 0)
                return ans;
            int r1 = 0, r2 = matrix.length - 1;
            int c1 = 0, c2 = matrix[0].length - 1;
            while (r1 <= r2 && c1 <= c2) {
                for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
                for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
                if (r1 < r2 && c1 < c2) {
                    for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
                    for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
                }
                r1++;
                r2--;
                c1++;
                c2--;
            }
            return ans;
        }
    }
}
