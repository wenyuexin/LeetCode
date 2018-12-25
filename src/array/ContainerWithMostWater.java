package array;


/** 
 * @author Apollo4634 
 * @creation 2018/12/25 00:12
 * 
 * No.11 Container With Most Water
 * 
 * 解题思路：
 * 假设容器左右两端的下标分别为i和j，那么容器的容量area为
 * area = (j-i)*min(height[i], height[j])
 * 因此，只要遍历可能出现的(i,j)组合即可
 */

public class ContainerWithMostWater {

	//Solution1
	public int maxArea(int[] height) {
		int max = 0;
		int area = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i+1; j < height.length; j++) {
				area = (j-i)*Math.min(height[i],height[j]);
				if(area>max) max = area;
			}
		}
		return max;
	}
	
	//Solution2
	public int maxArea2(int[] height) {
		int hLen = height.length; //数组长度
		int area = (hLen-1)*Math.min(height[0], height[hLen-1]);
		if(hLen==2) return area;
			
		int max = 0; //最大容量
		int width = 0;
		for (int i = 0; i < hLen-2; i++) {
			if(height[i]==0) continue;
			width = area/height[i]-1;
			for (int j = hLen-1; j > i+width; j--) {
				area = (j-i)*Math.min(height[i],height[j]);
				if(area>max) {
					max = area;
					width = area/height[i]-1;
				}
			}
		}
		return max;
	}
		
	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		
		long t1 = System.nanoTime();
		int maxValue = new ContainerWithMostWater().maxArea2(height);
		long t2 = System.nanoTime();
		
		System.out.println("output: "+maxValue);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
		
	}
}
