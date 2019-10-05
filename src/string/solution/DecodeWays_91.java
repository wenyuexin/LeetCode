package string.solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Apollo4634
 * @create 2019/10/03
 */

public class DecodeWays_91 {
    static class Solution {
        private int count;
        private int maxIdx;

        public int numDecodings(String s) {
            if (s == null || s.length() == 0) return 0;
            count = 0;
            maxIdx = s.length() - 1;
            decode(s, 0);
            return count;
        }

        private void decode(String s, int idx) {
            if (idx > maxIdx) {
                count += 1; return;
            }
            char ch = s.charAt(idx);
            if (ch == '0') return;
            if (idx < maxIdx) {
                if (ch == '1' || (ch == '2' && s.charAt(idx+1) < '7')) {
                    decode(s, idx+2);
                }
            }
            decode(s, idx+1);
        }
    }


    public static void main(String[] args) {
        //String s = "123";
        String s = "93715976311287769483871971322671886773499467423442178461584251978418763151253";
        System.out.println("Input:  "+s);

        long t1 = System.nanoTime();
        int ret = new Solution().numDecodings(s);
        long t2 = System.nanoTime();

        System.out.println("Output: "+ret);
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
