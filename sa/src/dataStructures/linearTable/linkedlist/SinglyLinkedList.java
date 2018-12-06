package dataStructures.linearTable.linkedlist;

/**
 * 单链表
 * @author Administrator
 * @date 2018年12月5日 下午4:06:39
 * @Description TODO
 */
public class SinglyLinkedList {
	
	private Node head = null;
	
	/**
	 * 按照value查找
	 * @param value
	 * @return
	 */
	public Node findByValue(int value) {
		Node p = head;
		while (p != null && p.data != value) {
			p = p.next;
		}
		
		return p;
	}
	
	/**
	 * 按照索引查找
	 * @param index
	 * @return
	 */
	public Node findByIndex(int index) {
		Node p = head;
		int pos = 0;
		while (p != null && pos != index) {
			p = p.next;
			pos++;
		}
		return p;
	}
	
	/**
	 * 表头部插入
	 * @param value
	 */
	public void insertToHead(int value) {
		Node node = new Node(value, null);
		insertToHead(node);
	}
	
	public void insertToHead(Node node) {
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}
	
	public void insertToTail(int value) {
		Node node = new Node(value, null);
		insertToTail(node);
	}
	

	public void insertToTail(Node node) {
		Node p = head;
		if (p == null) {
			head = node;
		} else {
			while (p.next != null) {
				p = p.next;
			}
			p.next = node;
		}
	}
	
	
	/**
	 * 在p元素后面插入
	 * @param p
	 * @param value
	 */
	public void insertAfter(Node p, int value) {
		Node node = new Node(value, null);
		insertAfter(p, node);
	}


	public void insertAfter(Node p, Node node) {
		if (p == null) return;
		node.next = p.next;
		p.next = node;
	}
	
	/**
	 * 在p元素前面插入
	 * @param p
	 * @param value
	 */
	public void insertBefore(Node p, int value) {
		Node node = new Node(value, null);
		insertBefore(p, node);
	}


	private void insertBefore(Node p, Node node) {
		if (p == null) return;
		if (p == head) {
			insertToHead(node);
			return;
		}
		Node q = head;
		while (q != null && q.next != p) {
			q = q.next;
		}
		
		if (q == null) {
			return;
		}
		
		node.next = q;
		q.next = node;
	}
	
	public void deleteByNode(Node node) {
		if (node == null || head == null) return;
		if (node == head) {
			head = null;
			return;
		} 
		Node p = head;
		while (p != null && p.next != node) {
			p = p.next;
		}
		
		if (p == null) {
			return;
		}
		
		p.next = node.next;
		node.next = null;
	}
	
	public void deleteByValue(int value) {
		if (head == null) return;
		Node p = head;
		Node q = null;
		while (p != null && p.data != value) {
			q = p;
			p = p.next;
		}
		
		if (p == null) return;
		if (q == null) {
			head = head.next;
		} else {
			q.next = p.next;
		}
	}
	
	
	public boolean TFResult(Node left, Node right) {
		while (left != null && right != null) {
			if (left.data == right.data) {
				left = left.next;
				right = right.next;
				continue;
			} else {
				System.out.println("不是回文字符串");
				return false;
			}
		}
		
		if (left == null && right == null) {
			System.out.println("是回文字符串");
			return true;
		} else {
			System.out.println("不是回文字符串");
			return false;
		}
		
	}
	
	/**
	 * 判断回文字符串
	 * @return
	 */
	public boolean palindrome() {
		if (head == null) return false;
		Node p = head;
		Node q = head;
		if (p.next == null) {
			System.out.println("只有一个元素.");
			return true;
		}
		while (q.next != null && q.next.next != null) {
			p = p.next;
			q = q.next.next;
		}
		
		Node right = null;
		Node left = null;
		if (q.next == null) {//奇数
			right = p.next;
			left = inverseLinkList(p).next;
		} else {//偶数
			right = p.next;
			left = inverseLinkList(p);
		}
		
		return TFResult(left, right);
	}
	
	/**
	 * 不带头节点的指针反转
	 * @param p
	 * @return
	 */
	public Node inverseLinkList_head(Node p) {
		Node head = new Node(9999, null);
		head.next = p;
		Node cur = p.next;
		Node next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = head.next;
			head.next = cur;
			cur = next;
		}
		return head;
	}
	
	
	
	/**
	 * 无头节点的链表反转
	 * @param p
	 * @return
	 */
	public Node inverseLinkList(Node p) {
		if (head == null || p == null) return null;
		Node pre = null;
		Node r = head;
		System.out.println("当前节点: " + r.data);
		Node next = null;
		while (r != p) {
			next = r.next;
			r.next = pre;
			pre = r;
			r = next;
		}
		
		r.next = pre;
		return r;
		
	}

	public void printAll() {
		Node p = head;
		while (p != null) {
			System.out.print(p.data + ",");
			p = p.next;
		}
	}
	

	/**
	 * 链表中的节点
	 * @author Administrator
	 * @date 2018年12月5日 下午4:09:04
	 * @Description TODO
	 */
	public static class Node {
		private int data;
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
		SinglyLinkedList link = new SinglyLinkedList(); 
        System.out.println("hello");
        //int data[] = {1};
        //int data[] = {1,2};
        //int data[] = {1,2,3,1};
        //int data[] = {1,2,5};
        //int data[] = {1,2,2,1};
        //int data[] = {1,2,5,2,1};
        int data[] = {1,2,5,3,1};

        for(int i =0; i < data.length; i++){
            link.insertToHead(data[i]);
            //link.insertToTail(data[i]);
        }
        link.printAll();
        //Node p = link.inverseLinkList_head(link.head);
        //System.out.println(p.data);
        if (link.palindrome()){
            System.out.println("回文");
        }else{
            System.out.println("不是回文");
        }
	}

}
