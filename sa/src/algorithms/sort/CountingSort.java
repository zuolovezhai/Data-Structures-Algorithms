package algorithms.sort;

/**
 * 计数排序
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 * 稳定的排序算法
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] data = {2,5,3,0,2,3,0,3};
        countSort(data);
    }

    public static void countSort(int[] data) {
        //生成奇数数组
        int[] c = new int[6];
        int[] r = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            c[data[i]] += 1;
        }

        printAll(c);

        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i-1];
        }

        printAll(c);

        for (int i = data.length-1; i >= 0; i--) {
            int value = c[data[i]];
            r[value-1] = data[i];
            c[data[i]] -= 1;
        }

        printAll(r);
    }

    public static void printAll(int[] data) {
        for (int value : data) {
            System.out.print(value + ".");
        }
        System.out.println();
    }
}
