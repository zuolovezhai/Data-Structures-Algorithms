package dataStructures.linearTable.linkedlist;

import java.util.LinkedList;
import java.util.Random;

/**
 * 使用单链表实现LRU缓存
 * @author Administrator
 * @date 2018年12月4日 下午5:55:01
 * @Description TODO
 */
public class LRUByLinkedList {
	private static final int CAPACITY = 10;
	public LinkedList<Integer> lruCache = new LinkedList<Integer>();
	
	public Integer get(Integer keyword) {
		for (Integer value : lruCache) {
			if (value == keyword) {
				return value;
			}
		}
		
		//从数据源获取,此处用随机数代替
		Random random = new Random();
		Integer value = random.nextInt();
		lruCache.add(value);
		return value;
	}
	
	public void set(Integer value) {
		if (lruCache.contains(value)) {
			lruCache.remove(value);
			lruCache.addFirst(value);
			return;
		}
		if (lruCache.size() >= CAPACITY) {
			System.out.println("remove element: " + lruCache.removeLast());
			lruCache.addFirst(value);
		} else {
			lruCache.addFirst(value);
		}
	}
	
	public void print (LinkedList<Integer> list) {
		StringBuilder sb = new StringBuilder();
		for (Integer value : list) {
			sb.append(value).append(",");
		}
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		LRUByLinkedList lruByLinkedList = new LRUByLinkedList();
		for (int i = 0; i < 10; i++) {
			lruByLinkedList.set(i);
		}
		lruByLinkedList.print(lruByLinkedList.lruCache);
		
		lruByLinkedList.set(12);
		lruByLinkedList.print(lruByLinkedList.lruCache);
		
		lruByLinkedList.set(19);
		lruByLinkedList.print(lruByLinkedList.lruCache);
		
		lruByLinkedList.set(2);
		lruByLinkedList.print(lruByLinkedList.lruCache);
	}
}
