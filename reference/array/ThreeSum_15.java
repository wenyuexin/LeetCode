package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
 * @author - 
 * @creation 2019/01/15
 * @problem 15
 */

public class ThreeSum_15 {

	//Approach1
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > 0) break;
			if (i > 0 && nums[i] == nums[i - 1]) continue;

			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				if (nums[i] + nums[left] + nums[right] > 0) {
					right--;
				} else if (nums[i] + nums[left] + nums[right] < 0) {
					left++;
				} else {
					ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1]) left++;
					while (left < right && nums[right] == nums[right + 1]) right--;
				}
			}
		}
		return ans;
	}

	//Approach2 
	public List<List<Integer>> threeSum2(int[] nums) {
		int numsLen = nums.length;
		List<List<Integer>> list = new ArrayList<>();
		if(numsLen<3) return list;
		Arrays.sort(nums); //排序

		int sum12, rightIdx;
		for (int i = 0; i < numsLen-2; i++) {
			if(nums[i]>0) break;
			rightIdx = numsLen-1;
			for (int j = i+1; j < numsLen-1; j++) {
				sum12 = nums[i]+nums[j];
				if(sum12>0) break;
				for (int k = rightIdx; k>j; k--) {
					if(nums[k]==-sum12) {
						list.add(Arrays.asList(nums[i], nums[j], -sum12));
						rightIdx = k-1;
						break;
					} else if (nums[k]<-sum12) {
						rightIdx = (k>numsLen-1)?numsLen-1:k;
						break;
					}
				}
				while (j<numsLen-1 && nums[j]==nums[j+1]) j++;
			}
			while (i<numsLen-2 && nums[i]==nums[i+1]) i++;
		}
		return list;
	}
	
	
	//For test
	public static int[] stringToIntegerArray(String input) {
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
    
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0)  return "[]";
    
        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
    
    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }
    
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            List<List<Integer>> ret = new ThreeSum_15().threeSum(nums);
            String out = int2dListToString(ret);
            System.out.println(out);
        }
    }
}
