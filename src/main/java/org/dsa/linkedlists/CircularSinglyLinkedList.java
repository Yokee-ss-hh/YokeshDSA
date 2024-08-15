package org.dsa.linkedlists;

class CSNode<T>{
	T data;
	CSNode<T> next;
	CSNode(T data){
		this.data = data;
	}
}
public class CircularSinglyLinkedList<T>{
	CSNode<T> head;
	CircularSinglyLinkedList() {
		this.head = null;
	}
	private int length() {
		var temp = this.head;
		int len=0;
		while(temp != null) {
			len++;
			if(temp.next != this.head) {
			   temp = temp.next;
			}
			else {
				break;
			}
		}
		return len;
	}
	private void insert(T data) {
		var newNode = new CSNode<T>(data);
		if(this.head == null) {
			this.head = newNode;
			newNode.next = newNode;
		}
		else {
			var temp = this.head;
			while(temp.next != this.head) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.next = this.head;
		}
	}
	private void insertFirst(T data) {
		var newNode = new CSNode<T>(data);
		if(this.head == null) {
			this.head = newNode;
			this.head.next = newNode;
		}
		else {
			newNode.next = this.head;
			var temp = this.head;
			while(temp.next != this.head) {
				temp = temp.next;
			}
			temp.next = newNode;
			this.head = newNode;
		}
	}
	private void insertAtIndex(int index,T data) {
		var newNode = new CSNode(data);
		var temp = this.head;
		if(this.head == null) {
			this.head = newNode;
			newNode.next = newNode;
		}
		else if(index > length()) {
			while(temp.next != this.head) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.next = this.head;
		}
		else if(index == 0) {
			while(temp.next != this.head) {
				temp = temp.next;
			}
			newNode.next = this.head;
			temp.next = newNode; 
			this.head = newNode;
		}
		else {
			for(int i=0;i<index-1;i++) {
				temp = temp.next;
			}
			var nextNode = temp.next;
			temp.next = newNode;
			newNode.next = nextNode;
		}
	}
	private void print() {
		var temp = this.head;
		if(temp == null) {
			return;
		}
		while(true) {
			System.out.println(temp.data);
			temp = temp.next;
			if(temp == this.head) {
				break;
			}
		}
	}
	private void delete() {
		var temp = this.head;
		if(temp == null) {
			throw new RuntimeException("Deletion from empty datastructure");
		}
		else if(temp.next == this.head) {
			this.head = null;
		}
		else {
			while(temp.next.next != this.head) {
				temp = temp.next;
			}
			temp.next = this.head;
		}
	}
	private void deleteFirst() {
		var temp = this.head;
		if(temp == null) {
			throw new RuntimeException("Deletion from empty datastructure");
		}
		else if(temp.next == this.head) {
			this.head = null;
		}
		else {
			var nextNode = this.head.next;
			while(temp.next != this.head) {
				temp = temp.next;
			}
			temp.next = nextNode;
			this.head = nextNode;
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
			}
			else {
				var newHead = temp.next;
				while(temp.next != this.head) {
					temp = temp.next;
				}
				this.head = newHead;
				temp.next = newHead;
			}
		}
		else {
			for(int i=0;i<index-1;i++) {
				temp = temp.next;
			}
			var nextNode = temp.next.next;
			temp.next = nextNode;
		}
	}
	private int search(T data) {
		var index = 0;
		var temp = this.head;
		while(temp != null) {
			if(temp.data == data) {
				return index;
			}
			index++;
			temp = temp.next;
			if(temp == this.head) {
				return -1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		CircularSinglyLinkedList<Integer> csl = new CircularSinglyLinkedList<Integer>();
		csl.insert(10);
		csl.insertFirst(5);
		csl.insertAtIndex(2, 20);
		csl.print();
		System.out.println(csl.search(200));
	}
}
