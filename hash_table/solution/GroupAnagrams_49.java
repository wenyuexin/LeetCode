package hash_table.solution;

import java.util.*;

/**
 * 要求：将排列不同但是包含相同字符的字符串放在相同链表中
 *
 * solution
 * 以排序后的字符串作为key，将原序字符串作为value，使用map进行处理
 *
 * solution2
 * 考虑数组很大，并且字符串长短不一的情况，
 * 基本想法是做两次散列，先以字符串长度散列，在按solution中的想法处理
 * 从leetcode的结果看好像并没有什么用 ...
 *
 * reference
 * 做法和solution差不多，主要区别是solution先排序，然后查找排序后的字符串.
 * 参考解法没有使用排序，而使用了自定义的方法，前者为O(nlogn)，后者为O(n)
 *
 * @author Apollo4634
 * @create 2019/07/29
 * @problem 49
 * @tag Hash Table
 * @tag String
 * @see hash_table.reference.GroupAnagrams_49
 */

public class GroupAnagrams_49 {

    //Recommend
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


    //Unrecommend
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
                    LinkedList<String> list = new LinkedList<>();
                    list.add(str);
                    subMap = new HashMap<>();
                    subMap.put(s, list);
                    maps.put(s.length(), subMap);
                }
            }

            List<List<String>> anagrams = new LinkedList<>();
            for (Map<String, List<String>> map : maps.values()) {
                Collection<List<String>> lists = map.values();
                anagrams.addAll(lists);
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
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat", "as", "sa", "q" };
        System.out.println("Input:  " + Arrays.toString(strs));

        long t1 = System.nanoTime();
        List<List<String>> lists = new Solution2().groupAnagrams(strs);
        long t2 = System.nanoTime();

        System.out.println("Output: " + lists);
        System.out.println("Runtime: " + (t2 - t1) / 1.0E6 + " ms");
    }
}
