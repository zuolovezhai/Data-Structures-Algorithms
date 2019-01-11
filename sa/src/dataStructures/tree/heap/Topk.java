package dataStructures.tree.heap;

/**
 * 利用堆解决top k问题
 */
public class Topk {
    public static void main(String[] args) {
        int[] data_test = {0,2,4,6,8,6,4,23,55,1};
        Topk.Heap heap = new Topk().new Heap(4);
        for (int i = 1; i < data_test.length; i++) {
            heap.insert(data_test[i]);
        }
        heap.printAll(heap.data, heap.count);
    }

    public class Heap {
        private int[] data;
        private int capacity;
        private int count;

        public Heap(int capacity) {
            this.capacity = capacity;
            this.data = new int[capacity+1];
            this.count = 0;
        }

        public void insert(int value) {
            if (count < capacity) {
                count++;
                data[count] = value;
                int i = count;
                while (i/2 > 0 && data[i/2] > data[i]) {
                    swap(data, i, i/2);
                    i >>= 1;
                }
            } else {
                if (value <= data[1]) return;
                data[1] = value;
                printAll(data, count);
                heapify();
                printAll(data, count);
            }
        }

        private void heapify() {
            int i = 1;
            while (true) {
                int minPos = i;
                if (i * 2 <= count && data[i*2] < data[i]) minPos = i*2;
                if (i * 2 + 1 <= count && data[i*2+1] < data[minPos]) minPos = i*2+1;
                if (minPos == i) break;
                swap(data, i, minPos);
                i = minPos;
            }
        }

        private void swap(int[] data, int index1, int index2) {
            int tmp = data[index1];
            data[index1] = data[index2];
            data[index2] = tmp;
        }

        public void printAll(int[] data, int count) {
            for (int i = 1; i <= count; i++) {
                System.out.print(data[i] + ",");
            }
            System.out.println();
        }
    }
}
