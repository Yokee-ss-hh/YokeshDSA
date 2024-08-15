package org.dsa.trees.heap;

import java.util.Arrays;

public class MinHeap {
	Integer[] heap;
	int maxSize;
	int size;
	MinHeap(int maxSize){
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
	private void insert(int data) throws Exception {
		if(this.size == this.maxSize) {
			throw new Exception("Heap size exceeded !");
		}
		else {
			this.heap[size] = data;
			HeapifyUp(this.size);
			this.size++;
		}
	}
	private void HeapifyUp(int pos) {
		while(pos > 0 && this.heap[pos] < this.heap[parent(pos)]) {
			var temp = this.heap[pos];
			this.heap[pos] = this.heap[parent(pos)];
			this.heap[parent(pos)] = temp;
			pos = parent(pos);
		}
	}
	private void HeapifyDown(int pos) {
		var leftPos = leftChild(pos);
		var rightPos = rightChild(pos);
		var smallest = pos;
		if(leftPos < this.size && this.heap[leftPos] < this.heap[pos]) {
			smallest = leftPos;
		}
		if(rightPos < this.size && this.heap[rightPos] < this.heap[smallest]) {
			smallest = rightPos;
		}
		if(smallest != pos) {
			var temp = this.heap[smallest];
			this.heap[smallest] = this.heap[pos];
			this.heap[pos] = temp;
			HeapifyDown(smallest);
		}
	}
	private int getMin() throws Exception{
		if(this.size == 0) { 
			throw new Exception("Heap is empty");
		}
		else {
			return this.heap[0];			
		}
	}
	private int extractMin() throws Exception{
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
	private void printHeap() {
		for(int i=0;i<this.size;i++) {
			if(this.heap[i] != null) {
				System.out.println(this.heap[i].intValue());
			}
		}
	}
	// Given an index and a value, we need to update the value at the index with the given value. 
	// We assume that the given value is less than the existing value at that index.
	private void decreaseKey(int index, int value) {
		// Update existing value at index with value
		this.heap[index] = value;
		// Now, The Complete binary tree property is not violated, but the MinHeap property may get violated.
		// As the value we are inserting is less than the previously existing value, the min-heap property is not violated in subtrees of this rooted tree. 
		// It may get violated in its ancestors, so as we do in insert operation, check the value of a current node with its parent node, if it violates the min-heap property
		HeapifyUp(index); // Fix the ancestors of the index using HeapifyUp()
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
	private void delete(int data) throws Exception{
		// Delete a element if exists, else return -1, use search() method to find the index
		// Replace the index with Integer.MIN_VALUE. i.e, Call decreaseKey(index,Integer.MIN_VALUE)
		// As Integer.MIN_VALUE is the at most minimum, It will reach the root of the tree in decreaseKey() method
		// Now, Call extractMin() which will delete the root node which is our desired. 
		if(this.search(data) != -1) {
			this.decreaseKey(this.search(data), Integer.MIN_VALUE);
			this.extractMin();
		}
	}
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(6);
		try {
			minHeap.insert(5);	
			minHeap.insert(3);
			minHeap.insert(1);
			minHeap.insert(7);
			minHeap.insert(6);
			minHeap.insert(9);
			minHeap.printHeap();
			System.out.println("---------");
			minHeap.delete(7);
			minHeap.printHeap();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
