package string.solution;

/**
 * @author Apollo4634
 * @create 2019/06/28
 * @problem 38
 * @tag String
 */

public class CountAndSay_38 {
    static class Solution {
        public String countAndSay(int n) {
            StringBuilder sb = new StringBuilder(2*n);
            sb.append("11");

            for (int i = 1; i < n; i++) {
                char ch = ' ';
                int cnt = 1;
                for (int j = 0; j < sb.length(); ) {
                    if (sb.charAt(j) != ch) {
                        String str = ""+cnt+sb.charAt(j);
                        sb.replace(j-cnt+1, j+1, str);
                        j = j - cnt + str.length();
                        ch = sb.charAt(j);
                        cnt = 1;
                    } else {
                        j += 1;
                        cnt += 1;
                    }
                }
                System.out.println(""+i+" "+sb);
            }
            return sb.toString();
        }
    }


    public static void main(String[] args) {
        int num = 5;
        System.out.println("Input:  "+num);

        long t1 = System.nanoTime();
        String sequence = new Solution().countAndSay(num);
        long t2 = System.nanoTime();

        System.out.println("Output: "+sequence);
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
