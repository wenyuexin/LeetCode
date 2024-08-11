package hash_table.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Apollo4634
 * @create 2019/07/30
 * @problem 49
 * @tag Hash Table
 * @tag String
 * @see hash_table.solution.GroupAnagrams_49
 */

public class GroupAnagrams_49 {
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            for (String str : strs) {
                String valKey = createAngVal(str);
                ArrayList<String> list = map.get(valKey);
                if (list == null) list = new ArrayList<>();
                list.add(str);
                map.put(valKey, list);
            }
            return new ArrayList<>(map.values());
        }

        public String createAngVal(String str) {
            char[] arr = new char[26];
            for (int i=0; i<str.length(); i++) {
                ++arr[str.charAt(i)-'a'];
            }
            return new String(arr);
        }
    }
}
