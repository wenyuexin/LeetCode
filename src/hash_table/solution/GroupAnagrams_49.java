package hash_table.solution;

import java.util.*;

/**
 * @author Apollo4634
 * @create 2019/07/29
 * @problem 49
 * @tag Hash Table
 * @tag String
 */

public class GroupAnagrams_49 {

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, LinkedList<String>> map = new HashMap<>();
            for (String str: strs) {
                String s = transform(str);
                if (map.containsKey(s))
                    map.get(s).add(str);
                else {
                    LinkedList<String> list = new LinkedList<>();
                    list.add(str);
                    map.put(s, list);
                }
            }

            return new ArrayList<>(map.values());
        }

        private String transform(String str) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }


    static class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<Integer, Map<String, List<String>>> maps = new HashMap<>();
            Map<String, List<String>> subMap;
            for (String str: strs) {
                String s = transform(str);
                if (maps.containsKey(s.length())) {
                    subMap = maps.get(s.length());
                    if (subMap.containsKey(s)) {
                        subMap.get(s).add(str);
                    } else {
                        LinkedList<String> list = new LinkedList<>();
                        list.add(str);
                        subMap.put(s, list);
                    }
                }
                else {
                    subMap = new HashMap<>();
                    LinkedList<String> list = new LinkedList<>();
                    list.add(str);
                    subMap.put(s, list);
                    maps.put(s.length(), subMap);
                }
            }

            //整合结果
            List<List<String>> anagrams = new LinkedList<>();
            for (Map map : maps.values()) {
                //Collection<List<String>> lists = subMap.values();
                anagrams.addAll((List<List<String>>) map.values());
            }

            return anagrams;
        }

        private String transform(String str) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }


    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println("Input:  " + Arrays.toString(strs));

        long t1 = System.nanoTime();
        List<List<String>> lists = new Solution().groupAnagrams(strs);
        long t2 = System.nanoTime();

        System.out.println("Output: " + lists);
        System.out.println("Runtime: " + (t2 - t1) / 1.0E6 + " ms");
    }
}
