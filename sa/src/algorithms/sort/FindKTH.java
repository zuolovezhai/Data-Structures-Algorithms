package algorithms.sort;

/**
 * 以O(n)的时间复杂度查找无序数列中中第K大的树
 * 分治思想
 */
public class FindKTH {
    public static void main(String[] args) {
        int[] data = new int[]{1,2,3,34,4,5,7,6,5,4,3,2,23,12};
        System.out.println(find(data, 0, data.length - 1, 4));
    }

    public static int find(int[] data, int left, int right, int k) {
        int midIndex = partition(data, left, right);
        if (midIndex+1 == k) {
            return data[midIndex];
        } else if (midIndex+1 < k) {
            return find(data, midIndex+1, right, k);
        } else {
            return find(data, left, midIndex-1, k);
        }
    }

    public static int partition(int[] data, int left, int right) {
        int pivot = data[right];

        int i = left;
        int j = left;
        for (j = left; j < right; j++) {
            if (data[j] > pivot) {
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
}
