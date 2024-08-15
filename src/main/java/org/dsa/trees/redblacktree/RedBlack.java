package org.dsa.trees.redblacktree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class RedBlack {
	enum Color{
		RED,
		BLACK
	}
	static class Node{
		int data;
		Color color;
		Node left;
		Node right;
		Node parent;
		boolean isNullLeaf;
	}
	static Node root;
	private Node createBlackNode(int data) {
        Node node = new Node();
        node.data = data;
        node.color = Color.BLACK;
        node.left = createNullLeafNode(node);
        node.right = createNullLeafNode(node);
        return node;
    }
    private Node createRedNode(Node parent, int data) {
        Node node = new Node();
        node.data = data;
        node.color = Color.RED;
        node.parent = parent;
        node.left = createNullLeafNode(node);
        node.right = createNullLeafNode(node);
        return node;
    }
    private Node createNullLeafNode(Node parent) {
        Node leaf = new Node();
        leaf.color = Color.BLACK;
        leaf.isNullLeaf = true;
        leaf.parent = parent;
        return leaf;
    }
	private boolean isLeftChild(Node node) {
		Node parent = node.parent;
		if(parent.left == node) {
			return true;
		}
		else {
			return false;
		}
	}
	private Optional<Node> getSibling(Node node) {
		if(node.parent != null) {
			Node parent = node.parent;
			if(isLeftChild(node)) {
				return Optional.ofNullable(parent.right.isNullLeaf ? null: parent.right);
			}
			else {
				return Optional.ofNullable(parent.left.isNullLeaf ? null : parent.left);
			}
		}
		else {
			return Optional.ofNullable(null);
		}
	}
	private void rightRotate(Node node, boolean changeColor) {
        Node parent = node.parent;
        node.parent = parent.parent;
        if(parent.parent != null) {
            if(parent.parent.right == parent) {
                parent.parent.right = node;
            } else {
                parent.parent.left = node;
            }
        }
        Node right = node.right;
        node.right = parent;
        parent.parent = node;
        parent.left = right;
        if(right != null) {
            right.parent = parent;
        }
        if(changeColor) {
            node.color = Color.BLACK;
            parent.color = Color.RED;
        }
    }
	
    private void leftRotate(Node node, boolean changeColor) {
        Node parent = node.parent;
        node.parent = parent.parent;
        if(parent.parent != null) {
            if(parent.parent.right == parent) {
                parent.parent.right = node;
            } else {
                parent.parent.left = node;
            }
        }
        Node left = node.left;
        node.left = parent;
        parent.parent = node;
        parent.right = left;
        if(left != null) {
            left.parent = parent;
        }
        if(changeColor) {
            node.color = Color.BLACK;
            parent.color = Color.RED;
        }
    }
    public void levelOrderTraversal() {
    	Queue<Node> queue = new LinkedList<Node>();
    	var rootNode = root;
    	if(rootNode != null) {
    		queue.add(rootNode);
    		while(!queue.isEmpty()) {
    			var currentNode = queue.remove();
    			System.out.println(currentNode.data+""+currentNode.color);
    			if(!currentNode.left.isNullLeaf) {
    				queue.add(currentNode.left);
    			}
    			if(!currentNode.right.isNullLeaf) {
    				queue.add(currentNode.right);
    			}
    		}
    	}
    }
	public Node insertNode(Node node, int data) {
		if(node == null) {
			return createBlackNode(data);
		}
		else if(node.isNullLeaf) {
			return createRedNode(node.parent, data);
		}
		else {
			boolean isLeft;
			if(data < node.data) {
				isLeft = true;
				Node left = insertNode(node.left, data);
	            if(left == node.parent) {
	                return left;
	            }
	            node.left = left;
			}
			else {
				isLeft = false;
				Node right = insertNode(node.right, data);
				if(right == node.parent) {
					return right;
				}
				node.right = right;
			}
			if(isLeft) {
				if(node.color == Color.RED && node.left.color == Color.RED) {
					Optional<Node> parentSibling = getSibling(node);
					if(!parentSibling.isPresent() || parentSibling.get().color == Color.BLACK) {
						if(isLeftChild(node)) {
							rightRotate(node, true);
						}
						else {
							rightRotate(node.left, false);
							node = node.parent;
							leftRotate(node, true);
						}
					}
					else {
						node.color = Color.BLACK;
						parentSibling.get().color = Color.BLACK;
						if(node.parent.parent != null) {
							node.parent.color = Color.RED;
						}
					}
				}
			}
			else {
	            if(node.color == Color.RED && node.right.color == Color.RED) {
	                Optional<Node> parentSibling = getSibling(node);
	                if(!parentSibling.isPresent() || parentSibling.get().color == Color.BLACK) {
	                    if(!isLeftChild(node)) {
	                        leftRotate(node, true);
	                    } else {
	                        leftRotate(node.right, false);
	                        node = node.parent;
	                        rightRotate(node, true);
	                    }
	                } else {
	                    node.color = Color.BLACK;
	                    parentSibling.get().color = Color.BLACK;
	                    if(node.parent.parent != null) {
	                        node.parent.color = Color.RED;
	                    }
	                }
	            }
			}
			return node;
		}
	}
	public static void main(String[] args) {
		RedBlack redBlack = new RedBlack();
		root = redBlack.insertNode(root, 10);
		redBlack.insertNode(root, 9);
		redBlack.insertNode(root, 7);
		//redBlack.insertNode(root, 5);
		redBlack.levelOrderTraversal();
	}

}
