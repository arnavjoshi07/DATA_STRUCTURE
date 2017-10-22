package com.arnav.ds;

import java.util.ArrayList;
import java.util.List;

/**
 * this class can take string numbers like one/two/three till ten, also negative values negOne,negTwo through negTen and all natural numbers
 * @author Arnav
 *
 */

public class BinarySearchTree {

	public List elements = new ArrayList();
	public static class Node {
		String data;
		int height;
		int size;
		Node left;
		Node right;

		Node(String element) {
			this.data = element;
		}
	}
	public void inOrder(BinarySearchTree.Node root){
		if(root == null){
			return;	
		}		
		inOrder(root.left);
		System.out.print(root.data+"\t");
		elements.add(root.data);
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
	public Node insert(Node root, String data){
		if(root == null){
			return new Node(data);
		}
		int numberData;

		if(Numbers.getNumber(data)!=null){
			numberData = Numbers.getNumber(data).val;			
		}else{
			numberData = Integer.valueOf(data);
		}

		int rootData;
		if(Numbers.getNumber(root.data)!=null){
			rootData = Numbers.getNumber(root.data).val;			
		}else{
			rootData = Integer.valueOf(root.data);
		}
		if(rootData <= numberData){
			root.right = insert(root.right,data);
		}
		else if(rootData > numberData){
			root.left = insert(root.left,data);
		}
		return root;
	}
	public static void main(String[]a){
		BinarySearchTree bst = new BinarySearchTree();
		Node root = null;
		root = bst.insert(root, "-10");
		root = bst.insert(root, "2");
		root = bst.insert(root, "three");
		root = bst.insert(root, "-13");
		root = bst.insert(root, "-15");
		root = bst.insert(root, "17");
		root = bst.insert(root, "15");
		root = bst.insert(root, "20");

//		TreeTraversals treetrav = new TreeTraversals();
//		treetrav.inOrder(root);
		bst.inOrder(root);
		System.out.println();
		bst.preOrder(root);
		System.out.println();
		bst.postOrder(root);
	}

}
