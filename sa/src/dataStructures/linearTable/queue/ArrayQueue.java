package dataStructures.linearTable.queue;

/**
 * 顺序队列
 * @author Administrator
 * @date 2018年12月9日 上午9:42:13
 * @Description TODO
 */
public class ArrayQueue {
	//对列中的数据
	private int[] data;
	//队列头指针
	private int head = 0;
	//队列的尾指针
	private int tail = 0;
	//队列中元素的个数
	private int n = 0;
	//队列的容量
	private int capacity;
	
	public ArrayQueue(int capacity) {
		super();
		this.capacity = capacity;
		this.data = new int[capacity];
	}
	
	/**
	 * 入队
	 * @param value
	 */
	public void enQueue(int value) {
		if (isFull()) {
			System.out.println("Qeueu is full.");
			return;
		}
		
		data[tail] = value;
		n++;
		tail += 1;
	}
	
	/**
	 * 出队
	 * @return
	 */
	public int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			throw new RuntimeException("Queue is empty.");
		}
		
		int value = data[head];
		head++;
		n--;
		return value;
	}
	
	/**
	 * 判断队列是否为空
	 * @return
	 */
	private boolean isEmpty() {
		if (head == tail) return true;
		return false;
	}
	
	/**
	 * 判断队列是否为空
	 * @return
	 */
	private boolean isFull() {
		if (tail == capacity) {
			if (head == 0) {
				return true;
			} else {
				moveData();
			}
		} 
		return false;
	}
	
	/**
	 * 当head!=0 && tail==n时进行数据搬移
	 */
	private void moveData() {
		for (int i = head; i < tail; i++) {
			data[i-head] = data[i];
		}
		
		tail -= head;
		head = 0;
	}


	public void printAll() {
		for (int i = head; i < tail; i++) {
			System.out.print(data[i] + ",");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int data[] = {1,3,5,7,4};
		ArrayQueue arrayQueue = new ArrayQueue(5);
		for (int value : data) {
			arrayQueue.enQueue(value);
		}
		arrayQueue.printAll();
		arrayQueue.deQueue();
		arrayQueue.printAll();
		arrayQueue.deQueue();
		arrayQueue.printAll();
		arrayQueue.enQueue(1);
		arrayQueue.printAll();
		arrayQueue.deQueue();
		arrayQueue.printAll();
		arrayQueue.enQueue(0);
		arrayQueue.enQueue(76);
		arrayQueue.printAll();
		arrayQueue.enQueue(2);
	}

}
