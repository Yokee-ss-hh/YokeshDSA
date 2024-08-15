package org.dsa.trees.heap;

import java.util.Arrays;

public class MaxHeap {
	Integer[] heap;
	int maxSize;
	int size;
	MaxHeap(int maxSize){
		this.heap = new Integer[maxSize];
		Arrays.fill(heap, null);
		this.maxSize = maxSize;
		this.size = 0;
	}
	private int parent(int i) {
		return (i-1)/2;
	}
	private int leftChild(int i) {
		return (2*i)+1;
	}
	private int rightChild(int i) {
		return (2*i)+2;
	}
	private void HeapifyUp(int pos) {
		while(pos > 0 && this.heap[pos] > this.heap[parent(pos)]) {
			var temp = this.heap[pos];
			this.heap[pos] = this.heap[parent(pos)];
			this.heap[parent(pos)] = temp;
			pos = parent(pos);
		}
	}
	private void insert(int data) throws Exception{
		if(this.size == this.maxSize) {
			throw new Exception("Heap is full");
		}
		else {
			this.heap[this.size] = data;
			HeapifyUp(this.size);
			this.size++;
		}
	}
	private int getMax() {
		return this.heap[0];
	}
	private int extractMax() throws Exception{
		if(this.size == 0) {
			throw new Exception("Heap is empty");
		}
		else {
			var toReturn = this.heap[0];
			this.heap[0] = this.heap[this.size-1];
			this.size--;
			HeapifyDown(0);
			return toReturn;
		}
	}
	private void HeapifyDown(int pos) {
		var leftPos = leftChild(pos);
		var rightPos = rightChild(pos);
		var largest = pos;
		if(leftPos < this.size && this.heap[leftPos] > this.heap[pos]) {
			largest = leftPos;
		}
		if(rightPos < this.size && this.heap[rightPos] > this.heap[largest]) {
			largest = rightPos;
		}
		if(largest != pos) {
			var temp = this.heap[largest];
			this.heap[largest] = this.heap[pos];
			this.heap[pos] = temp;
			HeapifyDown(largest);
		}
	}
	private int search(int data) {
		// search for the data in the heap and return it's index
		for(int i=0;i<this.size;i++) {
			if(this.heap[i] == data) {
				return i;
			}
		}
		return -1;
	}
	private void increaseKey(int index, int value) {
		this.heap[index] = value;
		HeapifyUp(index);
	}
	private void printHeap() {
		for(int i=0;i<this.size;i++) {
			if(this.heap[i] != null) {
				System.out.println(this.heap[i].intValue());
			}
		}
	}
	private void delete(int data) throws Exception{
		if(this.search(data) != -1) {
			increaseKey(this.search(data), Integer.MAX_VALUE);
			extractMax();
		}
	}
	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap(5);
		try {
			maxHeap.insert(8);
			maxHeap.insert(4);
			maxHeap.insert(20);
			maxHeap.increaseKey(1, 90);
			maxHeap.printHeap();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
