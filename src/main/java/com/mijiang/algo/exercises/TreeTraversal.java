package com.mijiang.algo.exercises;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {
	
	public static void main(String[] args){
		Tree t = new Tree();
		t.put(10);
		t.put(5);
		t.put(19);
		t.put(6);
		t.put(1);
		t.put(18);
		
		for (int e: t.preOrderTraversal())
			System.out.print(e + " ");
	}
	
	

}

class Tree{
	
	private Node root;
	
	class Node{
		int value;
		Node left;
		Node right;
		Node(int value){
			this.value = value;
		}
	}
	
	public void put(int val){
		root = put(root, val);
	}
	
	private Node put(Node node, int val){
		if (node ==  null) return new Node(val);
		int nVal = node.value;
		if (val > nVal)
			node.right = put(node.right, val);
		else if (val < nVal)
			node.left = put(node.left, val);
		return node;
	}
	
	public List<Integer> preOrderTraversal(){
		List<Integer> result = new ArrayList<Integer>();
		preOrderTraversal(root, result);
		return result;
	}
	
	private void preOrderTraversal(Node n, List<Integer> result){
		if (n == null) return;
		result.add(n.value);
		preOrderTraversal(n.left, result);
		preOrderTraversal(n.right, result);
	}
}
