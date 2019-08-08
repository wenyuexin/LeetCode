package array.solution;

import java.util.Arrays;

/**
 * @author Apollo4634
 * @create 2019/08/08
 * @problem 56
 * @tag Array
 * @tag Sort
 */

public class MergeIntervals_56 {
    static class Solution {
        public int[][] merge(int[][] intervals) {
            //long t1 = System.nanoTime();
            if (intervals.length < 2) return intervals;
            Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
            //long t2 = System.nanoTime();
            int idx = 0;
            for (int i = 1; i < intervals.length; i++) {
                if (!mergeIntervals(intervals[i-1], intervals[i])) {
                    intervals[idx++] = intervals[i-1];
                }
            }
            intervals[idx] = intervals[intervals.length-1];
            //long t3 = System.nanoTime();
            //int[][] arr = Arrays.copyOfRange(intervals, 0, idx+1);
            //long t4 = System.nanoTime();

            //System.out.println((t2-t1)/1E6);
            //System.out.println((t3-t2)/1E6);
            //System.out.println((t4-t3)/1E6);
            return Arrays.copyOfRange(intervals, 0, idx+1);
        }

        private boolean mergeIntervals(int[] interval, int[] interval2) {
            if (interval2[0] <= interval[1]) {
                interval2[1] = Math.max(interval[1],interval2[1]);
                return true;
            }
            return false;
        }
    }


    //将区间合并和排序结合起来
    static class Solution2 {
        public int[][] merge(int[][] intervals) {
            if (intervals.length < 2) return intervals;

            return intervals;
        }

        private boolean swapOrMerge(int[] interval, int[] interval2) {
            if (interval[1] < interval2[0]) {
                return false;
            } else if (interval2[1] < interval[0]) {
                swap(interval, interval2);
                return false;
            } else {
                interval2[0] = Math.min(interval[0], interval2[0]);
                interval2[1] = Math.max(interval[1], interval2[1]);
                return true;
            }
        }

        private void swap(int[] interval, int[] interval2) {
            int a = interval[0], b = interval[1];
            interval[0] = interval2[0]; interval[1] = interval2[1];
            interval2[0] = a; interval2[1] = b;
        }
    }


    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                { 1, 3 },
                { 2, 6 },
                { 8, 10 },
                { 15, 18 },
                { 30, 80 },
                { 60, 90 }
        };
        System.out.println("Input:  "+ Arrays.deepToString(intervals));

        long start = System.nanoTime();
        int[][] mergedIntervals = new Solution().merge(intervals);
        long end = System.nanoTime();

        System.out.println("Output: "+ Arrays.deepToString(mergedIntervals));
        System.out.println("Runtime: "+(end-start)/1.0E6+" ms");
    }
}
