package dataStructures.tree.heap;

/**
 * 利用堆求数据流中的中位数
 */
public class StreamMedian {

    public static void main(String[] args) {
        //测试小顶堆
        /*StreamMedian.MinHeap minHeap = new StreamMedian().new MinHeap(10);
        int[] data_test = {0,2,4,6,8,6,4,67,23,55,1};
        for (int i = 1; i < data_test.length; i++) {
            minHeap.insert(data_test[i]);
        }
        printAll(minHeap.data, minHeap.count);
        System.out.println(minHeap.getAndRemove());
        printAll(minHeap.data, minHeap.count);*/

        //测试大顶堆
        /*System.out.println("============================");
        StreamMedian.MaxHeap maxHeap = new StreamMedian().new MaxHeap(10);
        for (int i = 1; i < data_test.length; i++) {
            maxHeap.insert(data_test[i]);
        }
        printAll(maxHeap.data, maxHeap.count);
        System.out.println(maxHeap.getAndRemove());
        printAll(maxHeap.data, maxHeap.count);*/

        // 如果数据大于小顶堆顶堆堆顶元素，那么放入大顶堆，否则放入小顶堆
        // 如果数据小于大顶堆堆顶元素，那么放入大顶堆，否则放入小顶堆
        StreamMedian.MinHeap minHeap = new StreamMedian().new MinHeap(10);
        StreamMedian.MaxHeap maxHeap = new StreamMedian().new MaxHeap(10);
        int[] data = {0,2,4,6,23,55,1};
        for (int i = 1; i < data.length; i++) {
            if (data[i] <= maxHeap.data[1]) {
                maxHeap.insert(data[i]);
            } else {
                minHeap.insert(data[i]);
            }

            //调整两个堆，使数据平衡
            while ((minHeap.count - maxHeap.count) > 0) {
                maxHeap.insert(minHeap.getAndRemove());
            }

            while ((maxHeap.count - minHeap.count) > 1) {
                minHeap.insert(maxHeap.getAndRemove());
            }
        }

        if ((maxHeap.count+minHeap.count)%2==0) {
            System.out.println("中位数是 : " + (maxHeap.data[1]+minHeap.data[1])/2.0);
        } else {
            System.out.println("中位数是 : " + maxHeap.data[1]);
        }

    }


    /**
     * 大顶堆
     */
    public class MaxHeap {
        private int[] data;
        private int capacity;
        private int count;

        public MaxHeap(int capacity) {
            this.capacity = capacity;
            this.data = new int[capacity+1];
            this.count = 0;
        }

        /**
         * 插入元素
         * @param value
         */
        public void insert(int value) {
            ++count;
            data[count] = value;
            int i = count;
            while (i/2 >= 1 && data[i] > data[i/2]) {
                swap(data, i, i/2);
                i >>= 1;
            }
        }

        public int getAndRemove() {
            int value = data[1];
            remove();
            return value;
        }

        /**
         * 移除元素
         */
        public void remove() {
            if (count <= 0) return;
            data[1] = data[count];
            count--;
            int i = 1;
            while (true) {
                int maxPos = i;
                if (i*2<=count && data[i*2]>data[i]) maxPos=i*2;
                if (i*2+1<=count && data[i*2+1]>data[maxPos]) maxPos=i*2+1;
                if (maxPos == i) break;
                swap(data, i, maxPos);
                i = maxPos;
            }
        }
    }

    /**
     * 小顶堆
     */
    public class MinHeap {
        private int[] data;
        private int capacity;
        private int count;

        public MinHeap(int capacity) {
            this.capacity = capacity;
            this.data = new int[capacity+1];
            this.count = 0;
        }

        /**
         * 插入元素
         */
        public void insert(int value) {
            count++;
            data[count] = value;
            int i = count;
            while (i/2 > 0 && data[i/2] > data[i]) {
                swap(data, i, i/2);
                i >>= 1;
            }
        }

        public int getAndRemove() {
            int removed = data[1];
            remove();
            return removed;
        }

        /**
         * 移除元素
         */
        public void remove() {
            data[1] = data[count];
            count--;
            int i = 1;
            while (true) {
                int minPos = i;
                if (i*2 <= count && data[i*2] < data[i]) minPos = i*2;
                if (i*2+1 <= count && data[i*2+1] < data[minPos]) minPos = i*2+1;
                if (minPos == i) break;
                swap(data, i, minPos);
                i = minPos;
            }
        }
    }

    public void swap(int[] data, int index1, int index2) {
        int tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }

    public static void printAll(int[] data, int count) {
        for (int i = 1; i <= count; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.println();
    }
}
