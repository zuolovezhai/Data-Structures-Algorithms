package dataStructures.linearTable.stack;

/**
 * 链式栈
 * @author Administrator
 * @date 2018年12月6日 下午8:15:57
 * @Description TODO
 */
public class LinkStack<T> {
	//指向栈顶元素
	private Node top;
	//元素个数
	private int size;
	
	public Node getTop() {
		return top;
	}

	public void setTop(Node top) {
		this.top = top;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * 出栈
	 * @return
	 */
	public T pop() {
		if (top == null) {
			System.out.println("Stack is empty.");
			throw new RuntimeException("Stack is empty.");
		}
		
		T value = top.data;
		top = top.next;
		size--;
		return value;
		
	}
	
	public void push(T value) {
		Node newNode = new Node(value, null);
		push(newNode);
	}
	
	public void push(Node node) {
		if (top == null) {
			top = node;
		} else {
			node.next = top;
			top = node;
		}
		size++;
	}
	
	/**
	 * 清空栈中的元素
	 */
	public void clear() {
		this.top = null;
		this.size = 0;
	}
	
	public void printAll() {
		Node p = top;
		while (p != null) {
			System.out.print(p.data + ",");
			p = p.next;
		}
		System.out.println();
	}
	
	public class Node{
		private T data;
		private Node next;
		
		public Node(T data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
	}
	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6,7,7,8,8,12,45,23,23,6,5};
		LinkStack<Integer> linkStack = new LinkStack<Integer>();
		for (int i = 0; i < data.length; i++) {
			linkStack.push(data[i]);
		}
		linkStack.printAll();
		System.out.println(linkStack.pop());
		System.out.println(linkStack.pop());
		System.out.println(linkStack.pop());
		System.out.println(linkStack.pop());
		linkStack.printAll();
	}

}
