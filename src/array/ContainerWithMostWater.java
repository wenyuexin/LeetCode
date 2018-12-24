package array;


/** 
 * @author Apollo4634 
 * @creation 2018/12/25 00:12
 */

public class ContainerWithMostWater {

	//Solution1
	public int maxArea(int[] height) {
		int max = 0;
		int area = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i; j < height.length; j++) {
				area = (j-i)*Math.min(height[i],height[j]);
				if(area>max) max = area;
			}
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		
		long t1 = System.nanoTime();
		int maxValue = new ContainerWithMostWater().maxArea(height);
		long t2 = System.nanoTime();
		
		System.out.println("output: "+maxValue);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
		
	}
}
