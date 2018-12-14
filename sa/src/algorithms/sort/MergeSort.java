package algorithms.sort;

/**
 * 
 * @author Administrator
 * @date 2018年12月13日 下午3:23:12
 * @Description TODO
 */
public class MergeSort {

	public static void main(String[] args) {

	}
	
	public static void merge(int[] data) {
		int length = data.length;
		mergeSort(0, length - 1);
	}
	
	public static void mergeSort(int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = (left + right) / 2;
		mergeSort(left, mid);
		mergeSort(mid+1, right);
	}

}
