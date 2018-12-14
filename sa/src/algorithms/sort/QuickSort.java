package algorithms.sort;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] data = new int[]{1,2,3,4,5,7,6,5,4,3,2,23,12};
        quickSort(data, 0, data.length - 1);
        printAll(data);
    }

    public static void quickSort(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }

        int midIndex = partition(data, left, right);
        quickSort(data, left, midIndex-1);
        quickSort(data, midIndex+1, right);
    }

    public static int partition(int[] data, int left, int right) {
        int pivot = data[right];

        int i = left;
        int j = left;

        for (j = left; j < right; j++) {
            if (data[j] < pivot) {
                int tmp = data[j];
                data[j] = data[i];
                data[i] = tmp;
                i++;
            }
        }

        data[right] = data[i];
        data[i] = pivot;
        return i;
    }

    public static void printAll(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
    }
}
