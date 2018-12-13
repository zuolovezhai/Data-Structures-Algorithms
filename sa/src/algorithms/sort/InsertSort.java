package algorithms.sort;

/**
 * 插入排序
 * 时间复杂度 O(n*n)
 * 原地排序算法
 * 稳定的排序算法
 * @author Administrator
 * @date 2018年12月13日 下午2:49:50
 * @Description TODO
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] data = new int[]{1,2,3,4,5,7,6,5,4,3,2};
		insertSort(data);
		printAll(data);
	}
	
	public static void printAll(int[] data) {
		for (int value : data) {
			System.out.print(value + ",");
		}
		System.out.println();
	}
	
	public static void insertSort(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			int value = data[i+1];
			for (int j = i+1; j > 0; j--) {
				if (value < data[j-1]) {
					data[j] = data[j-1];
				} else {
					data[j] = value;
					break;
				}
			}
			
		}
	}

}
