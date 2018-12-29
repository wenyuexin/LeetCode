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
	public int maxArea(int[] height) {
		int hLen = height.length;
		int left = 0;
		int right = hLen - 1;

		int i = 0;
		int j = 0;
		int maxAreaValue = 0;
		int area = (right-left)*Math.min(height[right],height[left]);
		while (right-left>0) {
			int maxHeight = Math.max(height[right],height[left]);

			i=0; j=0;
			while(left+i<right-j) {
				if(height[left+i]<maxHeight) {
					i++;
				} else {
					area = (right-left-i)*Math.min(height[left+i],height[right]);
					if(area>maxAreaValue) {
						maxAreaValue = area;
						left = left+i;
						maxHeight = height[left+i];
						break;
					}
				}

				if(height[right-j]<maxHeight) {
					j++;
				} else {
					area = (right-left-j)*Math.min(height[left],height[right-j]);
					if(area>maxAreaValue) {
						maxAreaValue = area;
						right = right-j;
						maxHeight = height[right-j];
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
