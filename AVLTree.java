package com.arnav.ds;

public class AVLTree {

	public class Node{
		int data;
		int height;
		int size;
		Node left;
		Node right;

		Node(int element) {
			this.data = element;
		}
	}

	void inOrder(Node root){
		if(root == null){
			return;	
		}		
		inOrder(root.left);
		System.out.print(root.data+"\t");
		inOrder(root.right);
	}
	void preOrder(Node root){
		if(root == null){
			return;	
		}
		System.out.print(root.data+"\t");
		preOrder(root.left);
		preOrder(root.right);
	}
	void postOrder(Node root){
		if(root == null){
			return;	
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+"\t");
	}

	private Node leftRotate(Node root){
		Node newRoot = root.right;
		root.right = root.right.left;
		newRoot.left = root;
		root.height = setHeight(root);
		newRoot.height = setHeight(newRoot);
		return newRoot;
	}

	private Node rightRotate(Node root){
		Node newRoot = root.left;
		root.left = root.left.right;
		newRoot.right = root;
		root.height = setHeight(root);
		newRoot.height = setHeight(newRoot);
		return newRoot;
	}

	private int setHeight(Node root){
		if(root == null){
			return 0;
		}
		return 1 + Math.max((root.left != null ? root.left.height : 0), (root.right != null ? root.right.height : 0));
	}

	private int height(Node root){
		if(root == null){
			return 0;
		}else {
			return root.height;
		}
	}

	private int setSize(Node root){
		if(root == null){
			return 0;
		}
		return 1 + Math.max((root.left != null ? root.left.size : 0), (root.right != null ? root.right.size : 0));
	}

	public Node insert(Node root, int data){
		if(root == null){
			return new Node(data);
		}
		if(root.data <= data){
			root.right = insert(root.right,data);
		}
		else{
			root.left = insert(root.left,data);
		}
		int balance = balance(root.left, root.right);
		if(balance > 1){
			if(height(root.left.left) >= height(root.left.right)){
				root = rightRotate(root);
			}else{
				root.left = leftRotate(root.left);
				root = rightRotate(root);
			}
		}else if(balance < -1){
			if(height(root.right.right) >= height(root.right.left)){
				root = leftRotate(root);
			}else{
				root.right = rightRotate(root.right);
				root = leftRotate(root);
			}
		}
		else{
			root.height = setHeight(root);
			//            root.size = setSize(root);
		}
		return root;
	}

	private int balance(Node rootLeft, Node rootRight){
		return height(rootLeft) - height(rootRight);
	}

	public static void main(String args[]){
		AVLTree avlTree = new AVLTree();
		Node root = null;
		root = avlTree.insert(root, -10);
		root = avlTree.insert(root, 2);
		root = avlTree.insert(root, 13);
		root = avlTree.insert(root, -13);
		root = avlTree.insert(root, -15);
		root = avlTree.insert(root, 17);
		root = avlTree.insert(root, 15);
		root = avlTree.insert(root, 20);

		TreeTraversals tt = new TreeTraversals();
		avlTree.inOrder(root);
		System.out.println();
		avlTree.preOrder(root);
		System.out.println();
		avlTree.postOrder(root);
	}
}