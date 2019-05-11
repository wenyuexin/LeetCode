package math.reference;

/**
 * @author -
 * @date 2019/01/05
 * @problem 13
 */

public class RomanToInteger_13 {
 	public static int romanToInt(String s) {
         int num = 0;
         int n = s.length();
        
        for (int i = 0; i < n-1; i++) {
            int curr = map(s.charAt(i));
            int next = map(s.charAt(i+1));
            num = curr < next ? num - curr : num + curr;
        }
        
        num += map(s.charAt(n-1));
        
        return num;
    }
    
    private static int map(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

  
    public static void main(String[] args) {
    	//输入字符串对应数字的范围是 1 至 3999
    	String s = "LVIII"; //58
    	//String s = "MCMXCIV"; //1994
    	//String s = "III"; //3
    
    	long t1 = System.nanoTime();
    	int num = RomanToInteger_13.romanToInt(s);
    	long t2 = System.nanoTime();
    
    	System.out.println("input: "+s);
    	System.out.println("output: "+num);
    	System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
    }
}

