package array;

/** 
 * @author Apollo4634 
 * @creation 2018/12/29 23:12
 * 
 * No.11 Container With Most Water
 * 
 * 解题思路：
 * 一个容器或者说一个区间包含左右两个端点，
 * 只要确定了左右端点就能得到一个容量，因此可以正在按以下思路思考：
 * 先将左端点left设为0，右端点right设为height.length-1，
 * 只要找到一种规则，当满足该规则时端点能向中间收缩即可。
 * 
 * 暂时没有想出具体方法，但有几点可以作为参考：
 * 第一，如果要将left更新为left+i，那么新端点处的height值要更大；
 * 第二，在上一点基础上，可以尝试将面积增大作为端点收缩的参考
 * 
 * 程序施工中... 2019-01-01
 */

public class ContainerWithMostWater2 {

	//Solution - 施工中 - 此方法的解题思路有问题
	public int maxArea(int[] height) {
		int hLen = height.length;
		if(hLen==2) return Math.min(height[0], height[1]);
		int left = 0;
		int right = hLen - 1;

		int i = 1;
		int j = 1;
		int maxAreaValue = 0;
		int areaL = 0;
		int areaL_tmp = 0;
		int areaR = 0;
		int areaR_tmp = 0;
		while (right-left>0) {
			areaL = (right-left)*Math.min(height[left],height[right]);
			areaR = areaL;
			if(areaL>maxAreaValue) maxAreaValue = areaL;

			while(left+i<right-j) {
				//左端
				if(height[left]>=height[left+i]) {
					i++;
				} else {
					areaL_tmp = (right-left-i)*Math.min(height[left+i], height[right]);
					if(areaL_tmp>areaL) {
						left = left+i;
						i = 1;
						areaL = areaL_tmp;
						if(areaL>maxAreaValue) maxAreaValue = areaL;
					} else {
						i++;
					}
				}

				//右端
				if(height[right]>=height[right-j]) {
					j++;
				} else {
					areaR_tmp = (right-left-j)*Math.min(height[left],height[right-j]);
					if(areaR_tmp>areaR) {
						right = right-j;
						j = 1;
						areaR = areaR_tmp;
						if(areaR>maxAreaValue) maxAreaValue = areaR;
					} else {
						j++;
					}
				}
			}
			if(left+i>=right-j) break;
		}
		return maxAreaValue;
	}


	//Solution2 - 施工中
	public int maxArea2(int[] height) {
		int hLen = height.length;
		if(hLen==2) return Math.min(height[0], height[1]);
		int left = 0;
		int right = hLen - 1;

		int i = 1;
		int j = 1;
		int maxAreaValue = 0;
		int areaL = 0;
		int areaL_tmp = 0;
		int areaR = 0;
		int areaR_tmp = 0;
		while (right-left>0) {
			areaL = (right-left)*Math.min(height[left],height[right]);
			areaR = areaL;
			if(areaL>maxAreaValue) maxAreaValue = areaL;

			System.out.println("left "+left+"  i "+i+"  right "+right+"  j "+j+
					"  maxAreaValue "+maxAreaValue);
			
			while(left+i<right-j) {
				//左端
				if(height[left]>=height[left+i]) {
					i++;
				} else {
					areaL_tmp = (right-left-i)*Math.min(height[left+i], height[right]);
					if(areaL_tmp>maxAreaValue) {
						left = left+i;
						i = 1;
						maxAreaValue = areaL_tmp;
						//if(areaL>maxAreaValue) maxAreaValue = areaL;
						break;
					} else {
						i++;
					}
				}

				//右端
				if(height[right]>=height[right-j]) {
					j++;
				} else {
					areaR_tmp = (right-left-j)*Math.min(height[left],height[right-j]);
					if(areaR_tmp>maxAreaValue) {
						right = right-j;
						j = 1;
						maxAreaValue = areaR_tmp;
						//if(areaR>maxAreaValue) maxAreaValue = areaR;
						break;
					} else {
						j++;
					}
				}
			}
			System.out.println("left "+left+"  i "+i+"  right "+right+"  j "+j+
					"  maxAreaValue "+maxAreaValue);
			
			if(left+i>=right-j) break;
		}
		return maxAreaValue;
	}


	public static void main(String[] args) {
		//int[] height = {1,8,6,2,5,4,8,3,7}; //49
		int[] height = {2,3,4,5,18,17,6}; //17

		long t1 = System.nanoTime();
		int maxValue = new ContainerWithMostWater2().maxArea2(height);
		long t2 = System.nanoTime();

		System.out.println("output: "+maxValue);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
