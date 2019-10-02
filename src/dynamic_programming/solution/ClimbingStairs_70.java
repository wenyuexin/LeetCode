package dynamic_programming.solution;

/**
 * @author Apollo4634
 * @create 2019/10/02
 * @problem 70
 * @tag Dynamic Programming
 */

public class ClimbingStairs_70 {

    //unrecommended
    static class Solution {
        private int count;

        public int climbStairs(int n) {
            count = 0;
            climb(n, 1);
            climb(n, 2);
            return count;
        }

        private void climb(int stairsNum, int currentSteps) {
            if (currentSteps > stairsNum) return;
            if (currentSteps == stairsNum) { count += 1; return; }
            climb(stairsNum-currentSteps, 1);
            climb(stairsNum-currentSteps, 2);
        }
    }


    static class Solution2 {
        private int count;

        public int climbStairs(int n) {
            count = 0;

            return count;
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        int methods = new Solution().climbStairs(2);
        long end = System.nanoTime();

        System.out.println("Output: "+ methods);
        System.out.println("Runtime: "+(end-start)/1.0E6+" ms");
    }
}
