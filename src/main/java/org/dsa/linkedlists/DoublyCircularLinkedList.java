package org.dsa.linkedlists;

class DCNode<T>{
	T data;
	DCNode next;
	DCNode previous;
	public DCNode(T data) {
		this.data = data;
	}
}
public class DoublyCircularLinkedList<T>{
	DCNode head;
	DCNode tail;
	public DoublyCircularLinkedList() {
		this.head = null;
		this.tail = null;
	}
	private void print() {
		var temp = this.head;
		while(temp != null) {
			System.out.println(temp.data);
			if(temp.next == this.head) {
				break;
			}
			temp = temp.next;
		}
	}
	private void printReverse() {
		var temp = this.tail;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.previous;
		}
	}
	private void insert(T data) {
		var temp = this.head;
		var newNode = new DCNode(data);
		if(temp == null) {
			this.head = newNode;
			this.tail = newNode;
			this.tail.next = this.head;
		}
		else {
			this.tail.next = newNode;
			newNode.previous = this.tail;
			this.tail = newNode;
			this.tail.next = this.head;
		}
	}
	private void insertFirst(T data) {
		var temp = this.head;
		var newNode = new DCNode(data);
		if(temp == null) {
			this.head = newNode;
			this.tail = newNode;
			this.tail.next = newNode;
		}
		else {
			this.head.previous = newNode;
			newNode.next = this.head;
			var lastNode = this.head;
			while(lastNode.next != this.head) {
				lastNode = lastNode.next;
			}
			lastNode.next = newNode;
			this.head = newNode;
		}
	}
	private void insertAtIndex(int index,T data) {
		var newNode = new DCNode(data);
		var temp = this.head;
		if(temp == null) {
			this.head = newNode;
			this.tail = newNode;
			this.tail.next = newNode;
		}
		else if(index > length()) {
			while(temp.next != this.head) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.previous = temp;
			this.tail = newNode;
			newNode.next = this.head;
		}
		else if(index == 0) {
			while(temp.next != this.head) {
				temp = temp.next;
			}
			newNode.next = this.head;
			this.head.previous = newNode;
			this.head = newNode;
			temp.next = newNode;
		}
		else {
			for(int i=0;i<index-1;i++) {
				temp = temp.next;
			}
			var nextNode = temp.next;
			temp.next = newNode;
			newNode.previous = temp;
			if(nextNode == this.head) {
				newNode.next = nextNode;
				this.tail = newNode;
			}
			else {
				newNode.next = nextNode;
				nextNode.previous = newNode;
			}
		}
		
	}
	private int length() {
		var temp = this.head;
		int len = 0;
		while(temp != null) {
			len++;
			if(temp.next == this.head) {
				break;
			}
			else {
				temp = temp.next;
			}
		}
		return len;
	}
	private void delete() {
		var temp = this.tail;
		if(temp == null) {
			throw new RuntimeException("Deletion from empty datastructure");
		}
		else if(temp == this.head) {
			this.head = null;
			this.tail = null;
		}
		else {
			var newTail = temp.previous;
			temp.previous = null;
			newTail.next = null;
			this.tail = newTail;
		}
	}
	private void deleteFirst() {
		var temp = this.head;
		if(temp == null) {
			throw new RuntimeException("Deletion from empty datastructure");
		}
		else if(temp == this.tail) {
			this.head = null;
			this.tail = null;
		}
		else {
			var lastNode = this.head;
			var newHead = temp.next;
			while(lastNode.next != this.head) {
				lastNode = lastNode.next;
			}
			temp.next = null;
			newHead.previous = null;
			this.head = newHead;
			lastNode.next = newHead;
		}
	}
	private void deleteAtIndex(int index) {
		var temp = this.head;
		if(temp == null) {
			throw new RuntimeException("Deletion from empty datastructure");
		}
		else if(index >= length()) {
			throw new RuntimeException("Index out of range");
		}
		else if(index == 0) {
			if(temp.next == this.head) {
				this.head = null;
				this.tail = null;
			}
			else {
				var newHead = temp.next;
				while(temp.next != this.head) {
					temp = temp.next;
				}
				newHead.previous = null;
				this.head = newHead;
				temp.next = newHead;
			}
		}
		else {
			for(int i=0;i<index-1;i++) {
				temp = temp.next;
			}
			var dummy = temp.next.next;
			var toBeDeleted = temp.next;
			if(dummy == this.head) {
				temp.next = this.head;
				toBeDeleted.previous = null;
				toBeDeleted.next = null;
				this.tail = temp;
			}
			else {
				temp.next = dummy;
				dummy.previous = temp;
				toBeDeleted.previous = null;
				toBeDeleted.next = null;
			}
		}
	}
	private int search(T data) {
		int index = 0;
		var temp = this.head;
		while(temp != null) {
			if(temp.data == data) {
				return index;
			}
			index++;
			temp = temp.next;
			if(temp == this.head) {
				break;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		DoublyCircularLinkedList<Integer> dcll = new DoublyCircularLinkedList<Integer>();
		dcll.insertAtIndex(0, 10);
		dcll.insertAtIndex(1, 20);
		dcll.insertAtIndex(2, 30);
		dcll.insert(40);
		dcll.insertFirst(0);
		System.out.println(dcll.search(40));
	}

}
