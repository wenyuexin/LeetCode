package array;

/** 
 * @author Apollo4634 
 * @creation 2018/12/29 23:12
 * 
 * No.11 Container With Most Water
 * 
 * 解题思路：
 * 
 * 
 */

public class ContainerWithMostWater2 {

	//Solution - 施工中
	//private int calcArea(int[] height, int idx1, int idx2) {}
	
	public int maxArea(int[] height) {
		int hLen = height.length;
		int left = 0;
		int right = hLen - 1;

		int i = 0;
		boolean leftIsLarger = true;
		int maxAreaValue = 0;
		int minHeight = 0;
		int area = 0;
		while (right-left>0) {
			leftIsLarger = (height[left]>=height[right]);
			minHeight = (leftIsLarger?height[right]:height[left]);
			area = (right-left)*minHeight;
			if(area>maxAreaValue) maxAreaValue = area;

			i=0;
			while(left+i<=right-i) {
				if(height[left+i]<=minHeight && height[right-i]<=minHeight) {
					i++; continue;
				} else if(height[left+i]>minHeight && height[right-i]>minHeight) {
					if(leftIsLarger) {
						int area1 = i*Math.min(height[left],height[left+i]);
						int area2 = (right-left-i)*Math.min(height[left],height[right-i]);
						
						if (area1>area2) {
							
						}
					}

				} else {
					//施工中...
					if(height[left+i]>minHeight) {

					}

					if(height[right-i]>minHeight) {

					}

					area = (right-left-i)*Math.min(height[left+i],height[right]);
					if(area>maxAreaValue) {
						maxAreaValue = area;
						left = left+i;
						minHeight = height[left+i];
						break;
					}

					area = (right-left-i)*Math.min(height[left],height[right-i]);
					if(area>maxAreaValue) {
						maxAreaValue = area;
						right = right-i;
						minHeight = height[right-i];
						break;
					}
				}
			}
		}
		return maxAreaValue;
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
