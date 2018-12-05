package dataStructures.linearTable.array;

public class Array {

	//实际数据存储
	private int data[];
	//定义数组的长度	
	private int n;
	//数组中实际元素的个数
	private int count;
	
	public Array(int capacity) {
		this.n = capacity;
		this.data = new int[capacity];
		this.count = 0;
	}
	
	/**
	 * 查找执行索引的元素
	 * @param index
	 * @return
	 */
	public int find(int index) {
		if (index <0 || index >= count) return -1;
		return data[index];
	}
	
	/**
	 * 在指定的位置插入指定的元素
	 * @param index
	 * @param value
	 * @return
	 */
	public boolean insert(int index, int value) {
		if (index < 0 || index >= n) {
			System.out.println("invalid index: " + index);
			return false;
		}
		
		if (count == n) {
			System.out.println("Array is full.");
			return false;
		}
		
		for (int i = count; i > index; i--) {
			data[i] = data[i-1];
		}
		
		data[index] = value;
		count++;
		return true;
	}
	
	/**
	 * 删除指定索引的元素
	 * @param index
	 * @return
	 */
	public boolean delete(int index) {
		if (index < 0 || index >= count) {
			System.out.println("invalid index: " + index);
			return false;
		}
		
		for (int i = index+1; i < count; i++) {
			data[i-1] = data[i];
		}
		
		data[count-1] = 0;
		count--;
		return true;
	}
	
	public void printAll() {
		for (int value : data) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Array array = new Array(5);
		array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.printAll();
        array.delete(2);
        array.printAll();
			
	}

}
