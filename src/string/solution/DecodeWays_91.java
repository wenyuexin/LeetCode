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
        private static Map<String, Character> map = new HashMap<>() {{
            map.put("10", 'J'); map.put("11", 'K'); map.put("12", 'L');
            map.put("13", 'M'); map.put("14", 'N'); map.put("15", 'O');
            map.put("16", 'P'); map.put("17", 'Q'); map.put("18", 'R'); map.put("19", 'S');
            map.put("20", 'T'); map.put("21", 'U'); map.put("22", 'V');
            map.put("23", 'W'); map.put("24", 'X'); map.put("25", 'Y'); map.put("26", 'Z');
        }};

        private List<String> list;

        public int numDecodings(String s) {
            if (s == null || s.length() == 0) return 0;
            list = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            decode(s, 0, sb);
            return list.size();
        }

        private void decode(String s, int idx, StringBuilder sb) {
            int maxIdx = s.length() - 1;
            char ch = s.charAt(idx);
            if (idx > maxIdx || ch == '0') return;
            if (idx == maxIdx) {
                list.add(sb.toString());
            }

            if (idx < maxIdx) {
                if (ch == '1' || (ch == '2' && s.charAt(idx+1) < '7')) {
                    String sub = s.substring(idx, idx+2);
                    sb.append(map.get(sub));
                    decode(s, idx+2, sb);
                    sb.deleteCharAt(sb.length()-1);
                }
            }

            sb.append((char) (s.charAt(idx) - '1' + 'A'));
            decode(s, idx+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public static void main(String[] args) {
        String s = "123";
        System.out.println("Input:  "+s);

        long t1 = System.nanoTime();
        int ret = new Solution().numDecodings(s);
        long t2 = System.nanoTime();

        System.out.println("Output: "+ret);
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
