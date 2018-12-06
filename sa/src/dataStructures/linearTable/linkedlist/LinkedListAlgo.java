package dataStructures.linearTable.linkedlist;

import dataStructures.linearTable.linkedlist.SinglyLinkedList.Node;

/**
 * 1、单链表反转
 * 2、链表中环的检测
 * 3、两个有序的链表的合并
 * 4、删除链表中倒数第n个节点
 * 5、求链表的中间节点
 * 
 * @author Administrator
 * @date 2018年12月6日 下午3:03:52
 * @Description TODO
 */
public class LinkedListAlgo {
	
	public static Node reverse(Node list) {
		if (list == null) return null;
		if (list.next == null) return list;
		Node head = null;
		Node cur = list;
		Node next = null;
		
		while (cur != null) {
			next = cur.next;
			cur.next = head;
			head = cur;
			cur = next;
		}
		
		return head;
	}
	
	public static boolean checkCircle(Node list) {
		if (list == null) return false;
		
		Node fast = list;
		Node slow = list;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
	
	public static Node mergeSortedList(Node list1, Node list2) {
		if (list1 == null ) return list2;
		if (list2 == null) return list1;
		
		Node head = null;
		
		Node cur1 = list1;
		Node cur2 = list2;
		
		if (cur1.data <= cur2.data) {
			head = cur1;
			cur1 = cur1.next;
		} else {
			head = cur2;
			cur2 = cur2.next;
		}
		
		Node r = head;
		
		//链表1向链表2插入
		while (cur1 != null && cur2 != null) {
			if (cur1.data >= cur2.data) {
				r.next = cur2;
				cur2 = cur2.next;
			} else {
				r.next = cur1;
				cur1 = cur1.next;
			}
			
			r = r.next;
		}
		
		if (cur1 == null) {
			r.next = cur2;
		}
		
		if (cur2 == null) {
			r.next = cur1;
		}
		return head;
	}
	
	/**
	 * 删除链表中倒数地k个元素
	 * @param list
	 * @param k
	 * @return
	 */
	public static Node deleteLastKth(Node list, int k) {
		Node fast = list;
		while (fast != null && --k > 0) {
			fast = fast.next;
		}
		
		if (fast == null) return list;
		
		Node slow = list;
		Node pre = null;
		
		while (fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next;
		}
		
		if (pre == null) {
			list = list.next;
		} else {
			pre.next = slow.next;
		}
		return list;
	}
	
	public static Node findMiddleNode(Node list) {
		if (list == null) return null;
		Node slow = list;
		Node fast = list;
		
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public static void printAll(Node head) {
		if (head == null) return;
		Node p = head;
		while (p != null) {
			System.out.print(p.data + ",");
			p = p.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		SinglyLinkedList link = new SinglyLinkedList();
		int data[] = {1};

        for(int i =0; i < data.length; i++){
        	link.insertToTail(data[i]);
        }
        
        
        Node head = findMiddleNode(link.head);
        System.out.println(head.data);
        
	}

}
