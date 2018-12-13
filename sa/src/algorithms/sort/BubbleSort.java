package algorithms.sort;

/**
 * 冒泡排序
 * 最坏时间复杂度 O(n*n) 原始数据逆序
 * 最好时间复杂度 O(n) 原始数据顺序
 * 原地排序算法
 * 稳定的排序算法
 * @author Administrator
 * @date 2018年12月13日 下午2:11:42
 * @Description TODO
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] data = new int[]{1,2,3,4,5,7,6,5,4,3,2};
		bubbleSort(data);
		printAll(data);
	}
	
	public static void bubbleSort(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			boolean flag = false;
			for (int j = 0; j < data.length - i - 1; j++) {
				if (data[j] > data[j+1]) {
					int tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
					flag = true;
				}
			}
			
			//如果没有数据交换，提前退出
			if (!flag) {
				break;
			}
		}
	}
	
	public static void printAll(int[] data) {
		for (int value : data) {
			System.out.print(value + ",");
		}
		System.out.println();
	}

}
