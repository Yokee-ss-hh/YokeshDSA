package org.dsa.trees.binarysearchtree;

public class BinarySearchTree{
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	static Node root;
	private Node insertRecursively(Node node, int data) {
		if(node == null) {
			node = new Node(data);
			return node;
		}
		else {
			if(data < node.data) {
				node.left = insertRecursively(node.left, data);
			}
			else {
				node.right = insertRecursively(node.right, data);
			}
			return node;
		}
	}
	private void insertIteratively(int data) {
		var newNode = new Node(data);
		if(root == null) {
			root = newNode;
			return;
		}
		else {
			var node = root;
			Node prev = null;
			while(node != null) {
				if(data < node.data) {
					prev = node;
					node = node.left;
				}
				else {
					prev = node;
					node = node.right;
				}
			}
			if(data < prev.data) {
				prev.left = newNode;
			}
			else {
				prev.right = newNode;
			}
		}
	}
	
	private boolean search(Node node,int data) {
		boolean flag = false;
		if(node == null) {
			flag = false;
			return flag;
		}
		if(node.data == data) {
			flag = true;
			return flag;
		}
		else {
			if(data < node.data) {
				flag = search(node.left, data);
			}
			else {
				flag = search(node.right,data);
			}
		}
		return flag;
	}
	
	private Node getMinimum(Node node) {
		var temp = node;
		while(temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}
	private Node deleteRecursively(Node node,int data) {
		if(node == null) {
			return null;
		}
		else if(data < node.data) {
			node.left = deleteRecursively(node.left, data);
		}
		else if(data > node.data) {
			node.right = deleteRecursively(node.right, data);
		}
		else {
			if(node.left == null && node.right == null) {
				return null;
			}
			else if(node.left == null) {
				return node.right;
			}
			else if(node.right == null) {
				return node.left;
			}
			else {
				var minNode = getMinimum(node.right);
				node.data =  minNode.data;
				node.right = deleteRecursively(node.right, minNode.data);
			}
		}
		return node;
	}
	private void iterate(Node node) {
		if(node == null) {
			return;
		}
		else {
			System.out.println(node.data);
			iterate(node.left);
			iterate(node.right);
		}
	}
	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		// First time insertion is mandatory to assign to root as the tree is empty initially
		root = binarySearchTree.insertRecursively(root, 10);
		// Assigning to root from the second insertion is not mandatory in BST's because, the root is not changing after any number of insertions after initial insertion.
		binarySearchTree.insertRecursively(root, 8);		
		binarySearchTree.insertRecursively(root, 7);		
		binarySearchTree.insertRecursively(root, 6);
		binarySearchTree.iterate(root);
	}
}
