package org.dsa.linkedlists;

class DNode<T>{
	T data;
	DNode next;
	DNode previous;
	DNode(T data){
		this.data = data;
	}
}
public class DoublyLinkedList<T>{
	DNode head;
	DNode tail;
	DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	private int length() {
		var temp = this.head;
		var len=0;
		while(temp != null) {
			len++;
			temp = temp.next;
		}
		return len;
	}
	private void insert(T data) {
		var temp = new DNode(data);
		if(this.head == null) {
			this.head = temp;
			this.tail = temp;
		}
		else {
			this.tail.next = temp;
			temp.previous = this.tail;
			this.tail = temp;
		}
	}
	private void insertFirst(T data) {
		var temp = new DNode(data);
		if(this.head == null) {
			this.head = temp;
			this.tail = temp;
		}
		else {
			temp.next = this.head;
			this.head.previous = temp;
			this.head = temp;
		}
	}
	private void insertAtIndex(int index, T data) {
		var temp = new DNode(data);
		if(this.head == null) {
			this.head = temp;
			this.tail = temp;
		}
		else if(index > length()) {
			var tailNode = this.tail;
			tailNode.next = temp;
			temp.previous = tailNode;
			this.tail = temp;
		}
		else if(index == 0) {
			temp.next = this.head;
			this.head.previous = temp;
			this.head = temp;
		}
		else {
			var dummy = this.head;
			for(int i=0;i<index-1;i++) {
				dummy = dummy.next;
			}
			var nextDummy = dummy.next;
			dummy.next = temp;
			temp.previous = dummy;
			if(nextDummy != null) {
			temp.next = nextDummy;
			nextDummy.previous = temp;
			}
			else {
			 this.tail = temp;
			}
		}
	}
	private void print() {
		var temp = this.head;
		while(temp != null) {
			System.out.println(temp.data);
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
	private void delete() {
		var temp = this.tail;
		if(this.head == null && this.tail == null) {
			throw new RuntimeException("Deletion from empty datastructure");
		}
		else if(this.head.next == null){ // means head and tail are pointing to same node i.e, LL has only 1 node
			this.head = null;
			this.tail = null;
		}
		else {
			var tailBefore = temp.previous;
			tailBefore.next = null;
			temp.previous = null;
			this.tail = tailBefore;
		}
	}
	private void deleteFirst() {
		if(this.head == null && this.tail == null) {
			throw new RuntimeException("Deletion from empty datastructure");
		}
		else if(this.head.next == null) {
			this.head = null;
			this.tail = null;
		}
		else {
			var temp = this.head;
			var nextHead = this.head.next;
			temp.next = null;
			nextHead.previous = null;
			this.head = nextHead;
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
			var nextHead = this.head.next;
			if(nextHead != null) {
				temp.next = null;
				nextHead.previous = null;
				this.head = nextHead;
			}
			else {
				this.head = null;
				this.tail = null;
			}
		}
		else {
			for(int i=0;i<index-1;i++) {
				temp = temp.next;
			}
			var nextNextTemp = temp.next.next;
			if(nextNextTemp != null) {
				temp.next = nextNextTemp;
				nextNextTemp.previous = temp;
			}
			else {
				var nextTemp = temp.next;
				temp.next = null;
				nextTemp.previous = null;
				this.tail = temp;
			}
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
			temp = temp.next;
		}
		return -1;
	}
	private void reverse() {
		DNode currentNode=head;
		this.tail = currentNode;
		DNode finalHead = null;
		while(currentNode!=null){
		    DNode temp = currentNode.next;
		    currentNode.next=currentNode.previous;
		    currentNode.previous=temp;
		    finalHead = currentNode;
		    currentNode=currentNode.previous;
		}
		this.head = finalHead;
	}
	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.insertFirst(20);
		dll.insert(30);
		dll.insertFirst(10);
		dll.reverse();
		dll.print();
	}

}
