package org.dsa.trees.avltree;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	static Node root;
	private int getHeight(Node node) {
		int height;
		if(node == null) {
			return 0;
		}
		else {
			height = 1+Math.max(getHeight(node.left),getHeight(node.right));
			return height;
		}
	}
	private int getBalanceFactor(Node node) {
		if(node == null) {
			return -1;
		}
		
		else {
			return getHeight(node.left)-getHeight(node.right);
		}
	}
	private Node rotateLeft(Node node) {
        var t1 = node.right;
        var t2 = t1.left;
        t1.left = node;
        node.right = t2;
        return t1;
	}
	private Node rotateRight(Node node) {
        var t1 = node.left;
        var t2 = t1.right; 
        t1.right = node;
        node.left = t2;
        return t1;
	}
	private Node insert(Node node,int data) {
		if(node == null) {
			var newNode = new Node(data);
			return newNode;
		}
		else {
			if(data < node.data) {
				node.left = insert(node.left, data);
			}
			else {
				node.right = insert(node.right, data);
			}
		}
		var balanceFactor = getBalanceFactor(node);
		if(balanceFactor > 1 && data < node.left.data) {
			return rotateRight(node);
		}
		if(balanceFactor > 1 && data > node.left.data) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		if(balanceFactor < -1 && data > node.right.data) {
			return rotateLeft(node);
		}
		if(balanceFactor < -1 && data < node.right.data) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		return node;
	}
	private Node getMinimum(Node node) {
		var temp = node.right;
		while(temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}
	private Node delete(Node node, int data) {
		if(node == null) {
			return null;
		}
		else if(data < node.data) {
			node.left = delete(node.left, data);
		}
		else if(data > node.data) {
			node.right = delete(node.right, data);
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
				node.right = delete(node.right, minNode.data);
			}
		}
		var balanceFactor = getBalanceFactor(node);
		if(balanceFactor > 1 && data < node.left.data) {
			return rotateRight(node);
		}
		if(balanceFactor > 1 && data > node.left.data) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		if(balanceFactor < -1 && data > node.right.data) {
			return rotateLeft(node);
		}
		if(balanceFactor < -1 && data < node.right.data) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		return node;
	}
	private void levelOrderTraversal() {
    	Queue<Node> queue = new LinkedList<Node>();
    	var rootNode = root;
    	if(rootNode != null) {
    		queue.add(rootNode);
    		while(!queue.isEmpty()) {
    			var nodesCount = queue.size();
    			while(nodesCount > 0) {
    			var currentNode = queue.remove();
    			System.out.println(currentNode.data);
    			if(currentNode.left != null) {
    				queue.add(currentNode.left);
    			}
    			if(currentNode.right != null) {
    				queue.add(currentNode.right);
    			}
    			nodesCount--;
    			}
    			System.out.println("\n");
    		}
    	}
	}
	public static void main(String[] args) {
		AVL avl = new AVL();
		// First time insertion is mandatory to assign to root as the tree is empty initially
		root = avl.insert(root, 10);
		// Assigning to root from the second insertion is not mandatory in BST's but mandatory in AVL trees as after rotations, the root may change every time.
		root = avl.insert(root, 8);
		root = avl.insert(root, 6);
		avl.levelOrderTraversal();
	}

}
