package math.reference;

/**
 * @author Apollo4634
 * @create 2019/07/12
 * @problem 43
 * @tag Math
 * @tag String
 * @see math.solution.MultiplyStrings_43
 */

public class MultiplyStrings_43 {
    static class Solution {
        public String multiply(String num1, String num2) {
            int m=num1.length(), n=num2.length(), zero=0;
            int[] a = new int[m];
            int[] c = new int[m+n];
            for(int i=0,k=m; i<m; i++)
                a[--k]=num1.charAt(i)-'0'; // reverse the first number
            for(int i=n-1; i>=0; i--)
                add(c,a,num2.charAt(i)-'0',zero++); // multiply each digits of num2 to num1
            carry(c); // handle all carry operation together
            int i = m+n-1;
            while(i>0 && c[i]==0) i -= 1; // find the highest digit
            i++;
            StringBuilder ret = new StringBuilder(i);
            while(i>0) ret.append((char)(c[--i]+'0'));
            return ret.toString();
        }

        void carry(int[] a){
            int i;
            for(int k=0,d=0; k<a.length; k++){
                i=a[k]+d;
                a[k]=i%10;
                d=i/10;
            }
        }

        void add(int[] c, int[] a, int b, int zero){
            for(int i=zero,j=0; j<a.length; j++,i++)
                c[i]+=a[j]*b;
        }
    }


    public static void main(String[] args) {
        String num1 = "0";
        String num2 = "0";

        System.out.println("Input:  "+num1);
        System.out.println("Input:  "+num2);

        long t1 = System.nanoTime();
        String product = new Solution().multiply(num1, num2);
        long t2 = System.nanoTime();

        System.out.println("Output: "+product);
        System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
    }
}
