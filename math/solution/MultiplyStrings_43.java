package math.solution;


/**
 * 对于两个整数num1和num2之间的乘法计算
 * 假设num1的位数len1大于或等于num2的位数len2，即len1>=len2
 *
 * 有两种方法：
 *
 * A)
 * 依次计算num2中的每一位和num1的乘积，然后将length个数组合起来
 * 例如，num1=1234 num2=456，依次计算乘积得到：
 * 1234*6=7404 1234*5=6170 1234*4=4936
 * 然后得到乘积 7404+6170*10+4936*100=562704
 *
 * B)
 * num1和num2的乘积的位数是len1+len2-1或len1+len2
 * 可以依次计算乘积每一位的数值，对于1234*456，
 *             1    2    3    4
 *  x               4    5    6
 * -----------------------------
 *           6(1) 2(1) 8(2) 4(0)
 *      5(1) 0(1) 5(2) 0(0)
 * 4(0) 8(1) 2(1) 6(0)
 * -----------------------------
 *   5    6    2    7    0    4
 * 其中，括号内的为进位输入。
 * 只需要计算并将对应位置结果相加（包括进位输入），即可得到对应位上的数值。
 * 然后更新进位输出，并进入下一位的计算即可。
 *
 * 这里给出的是第二种方法，在具体实现上这里用了StringBuilder，
 * 其实完全可以用一个int数组存储结果，然后再转换成String
 *
 * @author Apollo4634
 * @create 2019/07/09
 * @problem 43
 * @tag Math
 * @tag String
 * @see math.reference.MultiplyStrings_43
 */

public class MultiplyStrings_43 {
    static class Solution {
        StringBuilder sb;
        int[] arr1;
        int[] arr2;

        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) return "0";
            if ("1".equals(num1)) return num2;
            if ("1".equals(num2)) return num1;

            int len = num1.length() + num2.length() - 1;
            sb = new StringBuilder(len+1);
            if (num1.length() >= num2.length()) {
                arr1 = toIntArray(num1);
                arr2 = toIntArray(num2);
            } else {
                arr1 = toIntArray(num2);
                arr2 = toIntArray(num1);
            }

            int c = 0;
            for (int i = 0; i < len; i++) {
                c = calc(i, c);
            }

            if (c > 0) sb.append(c);
            return sb.reverse().toString();
        }

        private int[] toIntArray(String s) {
            int max = s.length() - 1;
            int[] a = new int[max+1];
            for (int i = 0; i <= max; i++) {
                a[i] = s.charAt(max - i) - '0';
            }
            return a;
        }

        private int calc(int idx, int c) {
            int sum = c;
            for (int i2 = 0, i1 = idx-i2; i2 < arr2.length && i2 <= idx; i2++, i1 = idx-i2) {
                if (i1 >= arr1.length) continue;
                sum += (arr1[i1] * arr2[i2]);
            }
            c = sum / 10; //carry output
            sb.append((c > 0)? sum%10 : sum);
            return c;
        }
    }


    public static void main(String[] args) {
        String num1 = "4567";
        String num2 = "1234";

        System.out.println("Input:  "+num1);
        System.out.println("Input:  "+num2);

        long t1 = System.nanoTime();
        String product = new Solution().multiply(num1, num2);
        long t2 = System.nanoTime();

        System.out.println("Output: "+product);
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
