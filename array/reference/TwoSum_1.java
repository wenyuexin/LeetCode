package array.reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** 
 * @author - 
 * @create 2019/01/15
 * @problem 1
 * @see array.solution.TwoSum_1
 */

public class TwoSum_1 {

	public static class Solution {
		//Approach 1: Brute Force 暴力搜索
		//时间复杂度:O(n^2)  空间复杂度:O(1)
		public int[] twoSum(int[] nums, int target) {
			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[j] == target - nums[i]) {
						return new int[] { i, j };
					}
				}
			}
			throw new IllegalArgumentException("No two sum solution");
		}

		//Approach 2: Two-pass Hash Table
		//时间复杂度:O(n)  空间复杂度:O(n)
		public int[] twoSum2(int[] nums, int target) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				map.put(nums[i], i);
			}
			for (int i = 0; i < nums.length; i++) {
				int complement = target - nums[i];
				if (map.containsKey(complement) && map.get(complement)!=i) {
					return new int[] { i, map.get(complement) };
				}
			}
			throw new IllegalArgumentException("No two sum solution");
		}

		//Approach 3: One-pass Hash Table
		//时间复杂度:O(n)  空间复杂度:O(n)
		public int[] twoSum3(int[] nums, int target) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				int complement = target - nums[i];
				if (map.containsKey(complement)) {
					return new int[] { map.get(complement), i };
				}
				map.put(nums[i], i);
			}
			throw new IllegalArgumentException("No two sum solution");
		}
	}

	
	//测试1
	private static class Test {
		private static int[] stringToIntegerArray(String input) {
			input = input.trim();
			input = input.substring(1, input.length() - 1);
			if (input.length() == 0) return new int[0];

			String[] parts = input.split(",");
			int[] output = new int[parts.length];
			for(int index = 0; index < parts.length; index++) {
				String part = parts[index].trim();
				output[index] = Integer.parseInt(part);
			}
			return output;
		}

		private static String integerArrayToString(int[] nums, int length) {
			if (length == 0) return "[]";

			String result = "";
			for(int index = 0; index < length; index++) {
				int number = nums[index];
				result += (number + ", ");
			}
			return "[" + result.substring(0, result.length() - 2) + "]";
		}

		public static void main(String[] args) throws IOException {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String line;
			while ((line = in.readLine()) != null) {
				int[] nums = stringToIntegerArray(line);
				line = in.readLine();

				int target = Integer.parseInt(line);
				int[] ret = new Solution().twoSum(nums, target);

				String out = integerArrayToString(ret, ret.length);
				System.out.print(out);
			}
		}
	}


	//测试2
	private static class Test2 {
		public static void main(String[] args) {
			int target = 0;
			int[] nums = {-3,4,3,90};

			System.out.println("Input:  nums:   "+ Arrays.toString(nums));
			System.out.println("Input:  target: "+target);

			long t1 = System.nanoTime();
			int[] indices = new Solution().twoSum(nums, target);
			long t2 = System.nanoTime();

			System.out.println("Output: "+Arrays.toString(indices));
			System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
		}
	}
}
