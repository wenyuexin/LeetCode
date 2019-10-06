package string.solution;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Apollo4634
 * @create 2019/10/03
 * @problem 91
 * @tag String
 * @tag Dynamic Programming
 * @see string.reference.DecodeWays_91 - recommended
 */

public class DecodeWays_91 {

    //unrecommended
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


    //recommended
    static class Solution2 {
        private int count;

        public int numDecodings(String s) {
            if (s == null || s.length() == 0) return 0;
            char[] chars = s.toCharArray();

            List<Integer> list = new LinkedList<>() {{ add(0); }};
            for (int i = 0; i < chars.length-1; i++) {
                if (chars[i] != '1' && chars[i] != '2') list.add(i+1);
            }
            list.add(chars.length);

            Iterator<Integer> iter = list.iterator();
            int from = iter.next();
            int totalCount = 1;
            while (iter.hasNext()) {
                if (chars[from] == '0') return 0;
                int to = iter.next();
                if (from+1 == to) continue;
                count = 0;
                decode(chars, from, to);
                if (count == 0) return 0;
                totalCount *= count;
                from = to;
            }
            return totalCount;
        }

        private void decode(char[] chars,  int idx, int to) {
            if (idx >= to) { count += 1; return; }
            if (chars[idx] == '0') return;
            if (idx < to-1) {
                if (chars[idx] == '1' || (chars[idx] == '2' && chars[idx+1] < '7')) {
                    decode(chars, idx+2, to);
                }
            }
            decode(chars, idx+1, to);
        }
    }


    public static void main(String[] args) {
        //String s = "0";
        //String s = "1";
        //String s = "123";
        String s = "12318";
        //String s = "93715976311287";
        //String s = "9371597631128776948387197132267188";
        System.out.println("Input:  "+s);

        long t1 = System.nanoTime();
        int ret = new Solution2().numDecodings(s);
        long t2 = System.nanoTime();

        System.out.println("Output: "+ret);
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
