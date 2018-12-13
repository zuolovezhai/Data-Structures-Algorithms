package algorithms.sort;

/**
 * 选择排序
 * @author Administrator
 * @date 2018年12月13日 下午2:53:37
 * @Description TODO
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] data = new int[]{1,2,3,4,5,7,6,5,4,3,2};
		selectSort(data);
		printAll(data);
	}
	
	public static void printAll(int[] data) {
		for (int value : data) {
			System.out.print(value + ",");
		}
		System.out.println();
	}
	
	public static void selectSort(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			int minIndex = i;
			for (int j = i+1; j < data.length; j++) {
				if (data[i] > data[j]) {
					minIndex = j;
				}
			}
			
			int tmp = data[i];
			data[i] = data[minIndex];
			data[minIndex] = tmp;
		}
	}

}
