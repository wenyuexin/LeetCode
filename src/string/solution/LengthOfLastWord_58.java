package string.solution;

/**
 * @author Apollo4634
 * @create 2019/12/23
 * @problem 17
 * @tag String
 */

public class LengthOfLastWord_58 {
    static class Solution {
        public int lengthOfLastWord(String s) {
            if (s == null) return 0;
            char[] chars = s.trim().toCharArray();
            if (chars.length == 0) return 0;

            int endIdx = chars.length - 1;
            int startIdx = 0;
            for (int i = endIdx - 1; i >= -1; i--) {
                if (i == -1 || chars[i] == ' ') {
                    startIdx = i; break;
                }
            }
            return endIdx - startIdx;
        }
    }


    public static void main(String[] args) {
        //String s = "Hello";
        //String s = " Hello";
        String s = " Hello  ";
        //String s = "Hello World";
        //String s = "11 222 ";
        //String s = "";
        //String s = "  ";

        long t1 = System.nanoTime();
        int len = new Solution().lengthOfLastWord(s);
        long t2 = System.nanoTime();

        System.out.println("Input:   "+s);
        System.out.println("Output:  "+len);
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
