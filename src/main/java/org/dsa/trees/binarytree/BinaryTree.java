package org.dsa.trees.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T>{
    static class Node<T>{
    	T data;
    	Node<T> left;
    	Node<T> right;
    	Node(T data){
    		this.data = data;
    	}
    }
    static Node root;
    private void levelOrderTraversalUsingHeight() {
    	int h = height(root);
    	for(int i=0;i<h;i++) {
    		printCurrentLevel(root, i);
    	}
    }
    private void printCurrentLevel(Node node, int level) {
    	if(node == null) {
    		return;
    	}
    	if(level==0) {
    		System.out.println(node.data);
    	}
    	else{
            printCurrentLevel(node.left, level - 1);
            printCurrentLevel(node.right, level - 1);
    	}
    }
    private void levelOrderTraversalUsingQueue() {
    	Queue<Node> queue = new LinkedList<Node>();
    	var rootNode = root;
    	if(rootNode != null) {
    		queue.add(rootNode);
    		while(!queue.isEmpty()) {
    			var currentNode = queue.remove();
    			System.out.println(currentNode.data);
    			if(currentNode.left != null) {
    				queue.add(currentNode.left);
    			}
    			if(currentNode.right != null) {
    				queue.add(currentNode.right);
    			}
    		}
    	}
    }
    private void levelOrderTraversalLevelByLevelUsingQueue() {
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

    private void insertLevelOrderlyUsingQueue(T data) {
    	var node = new Node<T>(data);
    	var temp = root;
    	Queue<Node<T>> queue = new LinkedList<Node<T>>();
    	if(temp == null) {
    		root = node;
    	}
    	else {
    		queue.add(temp);
    		while(!queue.isEmpty()) {
    			var currentNode = queue.remove();
    			if(currentNode.left == null) {
    				currentNode.left = node;
    				break;
    			}
    			else{
    				queue.add(currentNode.left);
    			}
    			if(currentNode.right == null) {
    				currentNode.right = node;
    				break;
    			}
    			else {
    				queue.add(currentNode.right);
    			}
    		}
    	}
    }
    private int height(Node node) {
    	int height;
    	if(node == null) {
    		// return -1; violates the calculation of number of nodes in b-tree = 2^h-1 as it considers the edges. In this approach, if only 1 node is present in b-tree, then height is 0
    		return 0; // will not violate the calculation of number of nodes in b-tree = 2^h-1 as it considers the nodes. In this approach, if only 1 node is present in b-tree, then height is 1
    	}
    	int leftHeight = height(node.left);
    	int rightHeight = height(node.right);
    	height = Math.max(leftHeight, rightHeight)+1;
    	return height;
    }
    private void preOrderTraversalRecursive(Node<T> node) {
    	if(node == null) {
    		return;
    	}
    	else {
    		System.out.println(node.data);
    		preOrderTraversalRecursive(node.left);
    		preOrderTraversalRecursive(node.right);
    	}
    }
    private void inOrderTraversalRecursive(Node<T> node) {
    	if(node == null) {
    		return;
    	}
    	else {
    		inOrderTraversalRecursive(node.left);
    		System.out.println(node.data);
    		inOrderTraversalRecursive(node.right);
    	}
    }
    private void postOrderTraversalRecursive(Node<T> node) {
    	if(node == null) {
    		return;
    	}
    	else {
    		postOrderTraversalRecursive(node.left);
    		postOrderTraversalRecursive(node.right);
    		System.out.println(node.data);
    	}
    }
    private void preOrderTraversalIterativeMethod1() {
    	Node temp = root;
    	List<Node> stack = new Stack<Node>();
    	if(root == null) {
    		return;
    	}
    	else {
    		while(!stack.isEmpty() || temp != null) {
    			if(temp != null) {
    				System.out.println(temp.data);
    				stack.add(temp);
    				temp = temp.left;
    			}
    			else {
    				var prevNode = stack.remove(stack.size()-1);
    				temp = prevNode.right;
    			}
    		}
    	}
    }
    private void preOrderTraversalIterativeMethod2() {
    	var temp = root;
    	List<Node> stack = new Stack<Node>();
    	stack.add(temp);
    	if(root == null) {
    		return;
    	}
    	while(!stack.isEmpty()) {
    		var currNode = stack.remove(stack.size()-1);
    		System.out.println(currNode.data);
    		if(currNode.right != null) {
    			stack.add(currNode.right);
    		}
    		if(currNode.left != null) {
    			stack.add(currNode.left);
    		}
    	}
    }
    private void inOrderTraversalIterative() {
    	var temp = root;
    	List<Node> stack = new Stack<Node>();
    	if(temp == null) {
    		return;
    	}
    	while(!stack.isEmpty() || temp!=null) {
    		if(temp != null) {
    			stack.add(temp);
    			temp = temp.left;
    		}
    		else {
    			var currNode = stack.remove(stack.size()-1);
    			System.out.println(currNode.data);
    			temp = currNode.right;
    		}
    	}
    }
    private void postOrderTraversalIterativeUsingTwoStacks() {
    	if(root == null) {
    		return;
    	}
    	Node temp = root;
    	List<Node> stack1 = new Stack<Node>();
    	List<Node> stack2 = new Stack<Node>();
    	stack1.add(temp);
    	while(!stack1.isEmpty()) {
    		var currNode = stack1.remove(stack1.size()-1);
    		if(currNode.left !=null) {
    			stack1.add(currNode.left);
    		}
    		if(currNode.right != null) {
    			stack1.add(currNode.right);
    		}
    		stack2.add(currNode);
    	}
    	while(!stack2.isEmpty()) {
    		System.out.println(stack2.remove(stack2.size()-1).data);
    	}
    }
    private void postOrderTraversalIterativeUsingOneStack() {
    	Node<T> current = root;
    	Stack<Node> stack = new Stack<Node>();
    	while(!stack.isEmpty() || current != null) {
    		if(current != null) {
    			stack.add(current);
    			current = current.left;
    		}
    		else {
    			Node temp = stack.peek().right;
    			if(temp == null) {
    				temp = stack.pop();
    				System.out.println(temp.data);
    				while(!stack.isEmpty() && temp == stack.peek().right) {
    					temp = stack.pop();
    					System.out.println(temp.data);
    				}
    			}
    			else {
    				current = temp;
    			}
    		}
    	}
    }
    
	public static void main(String[] args) {
	     BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
	     binaryTree.root = new Node(10);
	     binaryTree.root.left = new Node(20);
	     binaryTree.root.left.left = new Node(30);
	     binaryTree.postOrderTraversalIterativeUsingOneStack();
	}
}
