package string;

import java.util.Arrays;

/** 
 * @author Apollo4634 
 * @creation 2019/01/05 21:01
 *  
 * No.14 Longest Common Prefix
 * 
 * 解题思路：
 * 可以认为输入的数组strs是一个二维字符矩阵， 一行代表一个字符串:
 * s1: s1c1 s1c2 s1c3 s1c4 ...
 * s2: s2c1 s2c2 s2c3 ...
 * ...
 * sn: snc1 snc2 snc3 snc4 snc5 ...
 * 
 * 那么，就存在两种基本遍历方式：
 * 第一，横向为主对比两个字符串，从上到下两两比较，
 * 即，s1先和s2比较找到最长前缀p，然后p和s3得到更新后的p，依次类推；
 * 第二，纵向比较为主，然后横向推进，直到最后一个相同的字符
 * 即，先比较第一列s1c1 s2c1 ... snc1的值，若相同则比较第二列，依次类推；
 * 
 * 当然横向比较不一定是从左到右，纵向不一定是从上到下，可以调整。
 * 这里已第二种方式为基础
 * 
 * 说明：
 * 第二种方法相比于第一种方法稍微好一点，因为可能存在以下情况，
 * 即，输入的字符串数组strs的前若干个字符串存在共同前缀p1,
 * 而后半部分的若干字符串的共同前缀是p2，如果p1的长度远大于p2，
 * 那么就会进行多次不必要的比较
 */

public class LongestCommonPrefix {

	//Solution
	public String longestCommonPrefix(String[] strs) {
		if(strs.length==0) return "";
		if(strs.length==1) return strs[0];

		int minStrLen = strs[0].length();
		for (int i_s = 1; i_s < strs.length; i_s++) {
			if(minStrLen>strs[i_s].length()) minStrLen = strs[i_s].length();
		}

		int prefixLength = 0;
		for (int i_c = 0; i_c < minStrLen; i_c++) {
			for (int i_s = 1; i_s < strs.length; i_s++) {
				if(strs[i_s].charAt(i_c)!=strs[0].charAt(i_c)) {
					return strs[0].substring(0, prefixLength);
				}
			}
			prefixLength++;
		}
		return strs[0].substring(0, prefixLength);
	}


	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};

		LongestCommonPrefix obj = new LongestCommonPrefix();
		long t1 = System.nanoTime();
		String prefix = obj.longestCommonPrefix(strs);
		long t2 = System.nanoTime();

		System.out.println("input:  "+Arrays.toString(strs));
		System.out.println("output: "+prefix);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}

