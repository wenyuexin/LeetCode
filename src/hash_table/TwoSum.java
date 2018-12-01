package hash_table;

//import java.util.Arrays;

/** 
 * @author Apollo4634 
 * @creation 2018/11/21
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] indices = {-1,-1};
		//Arrays.sort(nums,0,nums.length);
        for(int i=0; i<nums.length; i++) {
        	for(int j=i+1; j<nums.length; j++) {
        		if(nums[i]+nums[j]==target) {
        			return new int[] {i,j};
        		}
        	}
        }
        return indices;
    }
	
	public static void main(String[] args) {
		int target = 0;
		
		int[] nums = {-3,4,3,90};
		for(int n: nums) {
			System.out.print(n+" ");
		}
		System.out.println();
		
		int[] indices = new TwoSum().twoSum(nums, target); 
		
		for(int n: indices) {
			System.out.print(n+" ");
		}
		System.out.println();
	}
}
