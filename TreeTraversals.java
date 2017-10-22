package com.arnav.ds;

import com.arnav.ds.BinarySearchTree.Node;

public class TreeTraversals {
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
}
