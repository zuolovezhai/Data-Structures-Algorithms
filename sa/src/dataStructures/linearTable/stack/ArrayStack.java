package dataStructures.linearTable.stack;


/**
 * 顺序栈，支持动态扩容
 * @author Administrator
 * @date 2018年12月6日 下午8:16:10
 * @Description TODO
 */
public class ArrayStack {

	/**
	 * 存放栈中的数据
	 */
	private int[] data;
	//默认容量
	private static final int DEFAULT_CPAPCITY = 10;
	//实际容量
	private int capacity;
	//栈中元素的个数
	private int count = -1;
	public ArrayStack(int capacity) {
		super();
		if (capacity > 0) {
			this.capacity = capacity;
			data = new int[capacity];
		} else {
			throw new RuntimeException("Invalid init capacity");
		}
	}
	
	public ArrayStack() {
		this(DEFAULT_CPAPCITY);
	}

	/**
	 * 出栈
	 * @return
	 */
	public int pop() {
		if (count < 0) {
			System.out.println("Stack is empty.");
			return -1;
		} 
		int value = data[count];
		count--;
		return value;
	}
	
	/**
	 * 入站
	 * @param value
	 */
	public void push(int value) {
		if (count >= (capacity-1)) {
			System.out.println("Stack is full.");
			expandCapacity();
		} 
		
		data[++count] = value;
	}
	
	private void expandCapacity() {
		int newCapacity = capacity * 2;
		int[] newData = new int[newCapacity];
		for (int i = 0; i < capacity; i++) {
			newData[i] = data[i];
		}
		capacity = newCapacity;
		data = newData;
	}
	
	public void printAll() {
		for (int i = 0; i <= count; i++) {
			System.out.print(data[i] + ",");
		} 
		System.out.println();
	}

	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6,7,7,8,8,12,45,23,23,6,5};
		ArrayStack arrayStack = new ArrayStack(5);
		for (int i = 0; i < data.length; i++) {
			arrayStack.push(data[i]);
		}
		arrayStack.printAll();
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		arrayStack.printAll();
	}

}
