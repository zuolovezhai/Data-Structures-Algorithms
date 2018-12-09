package dataStructures.linearTable.queue;

public class CircularQueue {
	//队列中的元素
	private int[] data;
	//头指针
	private int head = 0;
	//尾指针
	private int tail = 0;
	//队列中元素的个数
	private int n = 0;
	//队列容量
	private int capacity = 0;
	
	
	
	public CircularQueue(int capacity) {
		super();
		data = new int[capacity+1];
		this.capacity = capacity+1;
	}
	
	/**
	 * 入队
	 * @param value
	 */
	public void enQueue(int value) {
		if (isFull()) {
			System.out.println("Queue is full.");
			return;
		}
		data[tail] =value;
		tail = (tail +1) % capacity;
		n++;
	}
	
	/**
	 * 出队
	 * @return
	 */
	public int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			throw new RuntimeException("Queue is empty.");
		}
		
		int value = data[head];
		head = (head + 1) % capacity;
		n--;
		return value;
	}
	
	private boolean isFull() {
		if ((tail + 1) % capacity == head) return true;
		return false;
	}
	
	private boolean isEmpty() {
		if (head == tail) return true;
		return false;
	}

	private void printAll() {
		if (tail < head) {
			for (int i = head; i < capacity; i++) {
				System.out.print(data[i] + ",");
			}
			
			for (int i = 0; i < tail; i++) {
				System.out.print(data[i] + ",");
			}
		} else {
			for (int i = head; i < tail; i++) {
				System.out.print(data[i] + ",");
			}
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		int data[] = {1,3,5,7,4};
		CircularQueue circularQueue = new CircularQueue(5);
		//circularQueue.deQueue();
		for (int value : data) {
			circularQueue.enQueue(value);
		}
		circularQueue.printAll();
		circularQueue.deQueue();
		circularQueue.printAll();
		circularQueue.deQueue();
		circularQueue.printAll();
		circularQueue.enQueue(1);
		circularQueue.printAll();
		circularQueue.deQueue();
		circularQueue.printAll();
		circularQueue.enQueue(0);
		circularQueue.enQueue(76);
		circularQueue.printAll();
		circularQueue.enQueue(2);
	}

}
