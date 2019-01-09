package dataStructures.tree.traverseTree;

/**
 * 求一个数列的所有排列组合
 */
public class PrintPermutations {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        printPermutations(a, 4, 4);
    }

    /**
     * k表示子数据的个数
     * @param data
     * @param n
     * @param k
     */
    public static void printPermutations(int[] data, int n, int k) {
        if (data == null) return;

        if (k == 1) {
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i] + ",");
            }
            System.out.println();
        }
        for (int i = 0; i < k; i++) {
            int tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;

            printPermutations(data, n, k-1);

            tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;
        }
    }
}
