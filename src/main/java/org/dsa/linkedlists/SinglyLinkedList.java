package org.dsa.linkedlists;

class SNode<T>{
	T data;
	SNode next;
	SNode(T data){
		this.data = data;
	}
}
public class SinglyLinkedList<T> {
	SNode head;
	SinglyLinkedList(){
		this.head = null;
	}
	private void insert(T data) {
		if(this.head == null) {
			this.head = new SNode(data);
		}
		else {
			var temp = this.head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = new SNode(data);
		}
	}
	private void insertFirst(T data) {
		var temp = new SNode(data);
		if(this.head == null) {
			this.head = temp;
		}
		else {
			temp.next = this.head;
			this.head = temp;
		}
	}
	private void print() {
		var temp = this.head;
		while(temp!= null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	private int length() {
		var temp = this.head;
		int len=0;
		while(temp != null) {
			len++;
			temp = temp.next;
		}
		return len;
	}
	private void insertAtIndex(int index,T data) {
		var newNode = new SNode<T>(data);
		if(this.head == null) {
			this.head = newNode;
		}
		else if(index > length()) {
			var temp = this.head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		else if(index == 0) {
			var dummy = this.head;
			this.head = newNode;
			newNode.next = dummy;
		}
		else {
			var start = this.head;
			for(int i=0;i<index-1;i++) {
				start = start.next;
			}
			var end = start.next;
			start.next = newNode;
			newNode.next = end;
		}
	}
	private void delete() {
		var temp = this.head;
		if(temp == null) {
			throw new RuntimeException("Deletion from empty datastructure");
		}
		else if(temp.next == null) {
			this.head = null;
		}
		else {
			while(temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;
		}
	}
	private void deleteFirst() {
		var temp = this.head;
		if(temp == null) {
			throw new RuntimeException("Deletion from empty datastructure");
		}
		else if(temp.next == null) {
			this.head = null;
		}
		else {
			this.head = temp.next;
			temp.next = null; // unlinking the deleted node from the linked list
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
			if(temp.next == null) {
				this.head = null;
			}
			else {
			  this.head = temp.next;
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
		var temp = this.head;
		var index = 0;
		while(temp != null) {
			if(temp.data == data) {
				return index;
			}
			index++;
			temp=temp.next;
		}
		return -1;
	}
	private void reverse() {
		SNode curr = this.head;
		SNode prev = null;
		SNode nextCurr = null;
		while(curr != null) {
			nextCurr = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextCurr;
		}
		this.head = prev;
	}
	public static void main(String[] args) {
		SinglyLinkedList<Object> sll = new SinglyLinkedList<Object>();
		sll.insert(new String("Akhil"));
		sll.insert(new Float(210));
		sll.print();
	}
}
