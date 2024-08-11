package array.solution;


/**
 * 解题思路：
 * 假设容器左右两端的下标分别为i和j，那么容器的容量area为
 * area = (j-i)*min(height[i], height[j])
 * 因此，只要遍历可能出现的(i,j)组合即可
 * 
 * Solution:
 * 限制了i和j的关系，要求j>i
 * 
 * Solution2:
 * 在方法1的基础上进一步收缩遍历范围，对于固定的i，
 * 可知容器的宽度至少要大于等于width = max/height[i] -1
 * 因此j的取值范围是i+width至height.length-1，
 * 如果(i+width)>(height.length-1)则直接跳过当前的i而直接i++
 * 
 * @author Apollo4634 
 * @create 2018/12/25
 * @problem 11
 * @see array.reference.ContainerWithMostWater_11
 */

public class ContainerWithMostWater_11 {

	//Solution - 暴力搜索
	public int maxArea(int[] height) {
		int max = 0;
		int area;
		for (int i = 0; i < height.length; i++) {
			for (int j = i+1; j < height.length; j++) {
				area = (j-i)*Math.min(height[i],height[j]);
				if(area>max) max = area;
			}
		}
		return max;
	}
	
	//Solution2 - Recommended
	public int maxArea2(int[] height) {
		int arrLen = height.length; //数组长度
		int area = (arrLen-1)*Math.min(height[0], height[arrLen-1]);
		if(arrLen==2) return area;
			
		int max = area; //最大容量
		int width;
		for (int i = 0; i < arrLen-2; i++) {
			if(height[i]==0) continue;
			width = max/height[i]-1;
			for (int j = arrLen-1; j > i+width; j--) {
				area = (j-i)*Math.min(height[i],height[j]);
				if(area>max) {
					max = area;
					width = max/height[i]-1;
				}
			}
		}
		return max;
	}
		
	
	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		
		long t1 = System.nanoTime();
		ContainerWithMostWater_11 obj =
				new ContainerWithMostWater_11();
		int maxValue = obj.maxArea2(height);
		long t2 = System.nanoTime();
		
		System.out.println("Output: "+maxValue);
		System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
	}
}
