package algorithms.search;

/**
 * 二分查找
 */
public class BSearch {
    public static void main(String[] args) {
        /*int[] data = {1,3,6,8,9,17,25,4378};
        int key = 17;
        System.out.println(search_recursive(data, 0, data.length-1, key));
        System.out.println(search(data,key));*/
        System.out.println(square(5));
    }

    public static int search_recursive(int[] data, int left, int right, int key) {
        int mid = left + ((right - left) >> 1);
        if (key == data[mid]) return mid;
        if (left > right) return -1;

        if (data[mid] > key) {
            return search_recursive(data, left, mid-1, key);
        } else {
            return search_recursive(data, mid+1, right, key);
        }
    }

    public static int search(int[] data, int key) {
        int left = 0;
        int right = data.length-1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (data[mid] == key) {
                return mid;
            } else if (data[mid] > key) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 求一个数的平方根
     * @param value
     * @return
     */
    public static double square(int value) {
        double left = 0;
        double right = value;
        double a = 0;
        for (int i = 0; i < 6; i++) {
            a = (right + left) / 2.0;
            if (a * a > value) {
                right = a;
            } else if (a * a < value) {
                left = a;
            } else {
                return a;
            }
        }

        return a;
    }
}


