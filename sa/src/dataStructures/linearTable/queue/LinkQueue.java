package dataStructures.linearTable.queue;

/**
 * 链式队列
 * @author Administrator
 * @date 2018年12月9日 上午9:47:10
 * @Description TODO
 */
public class LinkQueue {
	//头指针
	private Node head = null;
	//尾指针
	private Node tail = null;

	/**
	 * 入队
	 * @param value
	 */
	public void enQueue(int value) {
		Node node = new Node(value, null);
		enQueue(node);
	}
	
	public void enQueue(Node node) {
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}
	
	/**
	 * 出队
	 * @return
	 */
	public int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			throw new RuntimeException("Queue is empty");
		}
		int value = head.data;
		head = head.next;
		return value;
	}
	
	/**
	 * 判断队列是否为空
	 * @return
	 */
	private boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void printAll() {
		Node p = head;
		while (p != null) {
			System.out.print(p.data + ",");
			p = p.next;
		}
		System.out.println();
	}
	
	/**
	 * 队列中的节点
	 * @author Administrator
	 * @date 2018年12月9日 上午9:47:39
	 * @Description TODO
	 */
	private static class Node {
		//数据
		private int data;
		//指向下一个节点的指针
		private Node next;
		
		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

		public int getData() {
			return data;
		}
	}
	
	public static void main(String[] args) {
		int data[] = {1,3,5,7,4};
		LinkQueue linkQueue = new LinkQueue();
		linkQueue.deQueue();
		for (int value : data) {
			linkQueue.enQueue(value);
		}
		linkQueue.printAll();
		linkQueue.deQueue();
		linkQueue.printAll();
		linkQueue.deQueue();
		linkQueue.printAll();
		linkQueue.enQueue(1);
		linkQueue.printAll();
		linkQueue.deQueue();
		linkQueue.printAll();
		linkQueue.enQueue(0);
		linkQueue.enQueue(76);
		linkQueue.printAll();
		linkQueue.enQueue(2);
	}
}
