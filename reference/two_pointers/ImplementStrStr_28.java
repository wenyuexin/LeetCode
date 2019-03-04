package two_pointers;

/** 
 * @author Apollo4634 
 * @create 2019/03/05
 */

public class ImplementStrStr_28 {

	//Solution 1
	public int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	//Solution 2
	public int strStr2(String haystack, String needle) {
		if (needle.length() == 0) return 0;
		if (haystack.length() < needle.length()) return -1;

		char[] haystackCharArr = haystack.toCharArray();
		char[] needleCharArr = needle.toCharArray();
		int j;
		int maxIdx = haystack.length() - needle.length() + 1;
		for (int i = 0; i < maxIdx; i++) {
			for (j = 0; j < needleCharArr.length; j++) 
				if (haystackCharArr[i+j] != needleCharArr[j]) break;
			if (j == needleCharArr.length) return i;
		}
		return -1;
	}
	
	//Solution 3
	public int strStr3(String haystack, String needle) {
		if (needle.length() == 0) return 0;
		if (haystack.length() < needle.length()) return -1;
		
		char[] string = haystack.toCharArray();
		char[] str = needle.toCharArray();
		char first = str[0];
        int max = (string.length - str.length);
        for (int i = 0; i <= max; i++) {
            // Look for first character.
            if (string[i] != first) {
                while (++i <= max && string[i] != first);
            }
            // Found first character, now look at the rest of value
            if (i <= max) {
                int j = i + 1;
                int end = j + str.length - 1;
                for (int k = 1; j < end && string[j] == str[k]; j++, k++);
                if (j == end) {
                    // Found whole string.
                    return i;
                }
            }
        }
        return -1;
	}
}
