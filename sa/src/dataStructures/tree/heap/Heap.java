package dataStructures.tree.heap;

/**
 * 堆
 */
public class Heap {
    //数组，从下标一开始存储元素
    private int[] data = null;
    //堆的最大容量
    private int capacity;
    //堆中存储元素的个数
    private int count;

    public Heap(int capacity) {
        this.data = new int[capacity+1];
        this.capacity = capacity;
        this.count = 0;
    }

    /**
     * 从下往上建堆
     * @param value
     */
    public  void insert(int value) {
        if (count >= capacity) return;
        ++count;
        data[count] = value;
        int i = count;
        while (i/2 >= 1 && value > data[i/2]) {
            swap(data, i/2, i);
            i >>= 1;
        }
    }

    public void swap(int[] data, int left, int right) {
        int tmp = data[left];
        data[left] = data[right];
        data[right] = tmp;
    }

    public static void printAll(int[] data, int count) {
        for (int i = 1; i <= count; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.println();
    }

    /**
     * 从上往下建堆
     */
    public void removeMax() {
        if (count <= 0) return;
        data[1] = data[count];
        --count;
        int i = 1;
        while (i*2 <= count && data[getMaxChildNode(i)] > data[i]) {
            swap(data, i, getMaxChildNode(i));
            i <<= 1;
        }
    }

    /**
     * 获取子节点中值大的那一个
     * @param i
     * @return
     */
    public int getMaxChildNode(int i) {
        if (i*2 > count) return i;
        if (i*2 == count) return count;
        else return data[i*2]>=data[i*2+1]?i*2:i*2+1;
    }


    /**
     * 建堆
     * @param data
     * @param n
     */
    public void buildHeap(int[] data, int n) {
        for (int i = n/2; i >= 1; i--) {
            heapify(data, i, n);
        }
    }

    /**
     * 堆化
     * @param data
     * @param i
     */
    public void heapify(int[] data, int i, int n) {
        while (true) {
            int maxPos = i;
            if (i*2 <= n && data[i*2] > data[i]) maxPos=i*2;
            if (i*2+1 <= n && data[i*2+1] > data[maxPos]) maxPos=i*2+1;
            if (i == maxPos) break;
            swap(data, i, maxPos);
            i = maxPos;
        }
    }

    public void sort(int[] data, int n) {
        if (n == 1) return;
        buildHeap(data, n);
        int tmp = data[1];
        data[1] = data[n];
        data[n] = tmp;
        sort(data, --n);
    }

    public static void main(String[] args) {
        Heap heap = new Heap(15);
        int[] data_test1 = {0,2,4,6,8,6,4,67,23,55,1};
        int[] data_test2 = {2,4,6,8,6,4,67,23,55,1};
        heap.sort(data_test1, data_test1.length-1);
        printAll(data_test1, data_test1.length-1);
        /*heap.buildHeap(data_test1, data_test1.length-1);
        printAll(data_test1, data_test1.length-1);

        for (int i = 0; i < data_test2.length; i++) {
            heap.insert(data_test2[i]);
        }
        printAll(heap.data, heap.count);
        heap.removeMax();
        printAll(heap.data, heap.count);*/
    }
}
