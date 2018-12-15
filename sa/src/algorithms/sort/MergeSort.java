package algorithms.sort;

/**
 *归并排序:稳定、非原地排序,O(n)的空间复杂度
 * 时间复杂度O(nlogn)
 * 空间复杂度O(n)
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] data = new int[]{1,2,3,4,5,7,6,5,4,3,2,23,12};
        merge_sort_c(data, 0, data.length - 1);
        printAll(data);
    }

    /**
     * 递归调用函数
     */
    public static void merge_sort_c(int[] data, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        merge_sort_c(data, left, mid);
        merge_sort_c(data, mid+1, right);
        merge_sentinel(data, left, mid, right);
    }

    public static void merge(int[] data, int left, int mid, int right) {
        int[] tmp = new int[right-left+1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (data[i] > data[j]) {
                tmp[k++] = data[j++];
            }  else {
                tmp[k++] = data[i++];
            }
        }

        int start = i;
        int end = mid;

        if (j <= right) {
            start = j;
            end = right;
        }

        while (start <= end) {
            tmp[k++] = data[start++];
        }

        for (i = 0; i < right - left + 1; i++) {
            data[left+i] = tmp[i];
        }

    }

    /**
     * 使用哨兵
     * @param data
     * @param left
     * @param mid
     * @param right
     */
    public static void merge_sentinel(int[] data, int left, int mid, int right) {
        int[] leftArr = new int[mid-left+2];
        int[] rightArr = new int[right-mid+1];


        for (int i = 0; i < leftArr.length - 1; i++) {
            leftArr[i] = data[left+i];
        }
        leftArr[leftArr.length-1] = Integer.MAX_VALUE;//哨兵

        for (int i = 0; i < rightArr.length - 1; i++) {
            rightArr[i] = data[mid+1+i];
        }
        rightArr[rightArr.length-1] = Integer.MAX_VALUE;//哨兵

        int m = 0;
        int n = 0;

        for (int i = 0; i < right-left + 1; i++) {
            if (leftArr[m] <= rightArr[n]) {
                data[left+i] = leftArr[m++];
            } else {
                data[left+i] = rightArr[n++];
            }
        }

    }

    public static void printAll(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
    }
}
