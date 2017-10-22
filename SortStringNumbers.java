package com.arnav.ds;

import com.arnav.ds.BinarySearchTree;
import com.arnav.ds.Numbers;

public class SortStringNumbers {
	public static void main(String[] aS){
		String marks = "-16,12,10,one,-10,negFive,three,4,oner,-4,sev";
		String inputList[] = marks.split(",");
		BinarySearchTree bst = new BinarySearchTree();
		BinarySearchTree.Node root = null;
		StringBuffer nonNumbers = new StringBuffer();
		for(String str:inputList){

			Integer numberData;
			if(Numbers.getNumber(str)!=null){
				numberData = Numbers.getNumber(str).val;			
			}else{
				try{
					numberData = Integer.valueOf(str);
				}catch(Exception e){
					numberData = null;
				}
			}

			if(numberData!=null ){
				root = bst.insert(root, str);
			}else{
				nonNumbers.append(",Invalid:"+str+"\t");
			}
		}
		nonNumbers = new StringBuffer(nonNumbers.substring(1, nonNumbers.length()));
		bst.inOrder(root);
		System.out.println(nonNumbers);
		System.out.println(bst.elements);
	}
}

