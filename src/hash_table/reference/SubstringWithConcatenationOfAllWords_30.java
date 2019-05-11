package hash_table.reference;

import hash_table.SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * @author Apollo4634 
 * @create 2019/03/17
 * @problem 30
 * @see SubstringWithConcatenationOfAllWords
 */

public class SubstringWithConcatenationOfAllWords_30 {
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indexes = new ArrayList<>();
        if (words.length == 0) return indexes;
        int wordSize = words[0].length();
        int size = wordSize * words.length;
        if (size > s.length()) return indexes;
        
        Map<String, Integer> strings = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            strings.put(words[i], strings.getOrDefault(words[i], 0) + 1);
        }
        
        Map<String, Integer> temp = new HashMap<>();
        for (int k = 0; k < wordSize; ++k)
            for (int i = k; i <= s.length() - size; i += wordSize) {
                int j = i + size;
                for (; j > i; j -= wordSize) {
                    String word = s.substring(j - wordSize, j);
                    if (temp.getOrDefault(word, 0) + 1 > strings.getOrDefault(word, 0)) {
                        i = j - wordSize; break;
                    }
                temp.put(word, temp.getOrDefault(word, 0) + 1);
            }
            
            if (j == i) indexes.add(i);
            temp.clear();
        }
        return indexes;
    }
}
