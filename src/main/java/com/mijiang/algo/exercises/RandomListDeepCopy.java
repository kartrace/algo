package com.mijiang.algo.exercises;


public class RandomListDeepCopy {
	
	public static void main(String[] args){
		
	}

	
	public RandomListNode copyRandomList(RandomListNode head) {
		 
		if (head == null)
			return null;
	 
		RandomListNode p = head;
	 
		// copy every node and insert to list
		while (p != null) {
			RandomListNode copy = new RandomListNode(p.label);
			copy.next = p.next;
			p.next = copy;
			p = copy.next;
		}
	 
		// copy random pointer for each new node
		p = head;
		while (p != null) {
			if (p.random != null)
				p.next.random = p.random.next;
			p = p.next.next;
		}
	 
		// break list to two
		p = head;
		RandomListNode newHead = head.next;
		while (p != null) {
			RandomListNode temp = p.next;
			p.next = temp.next;
			if (temp.next != null)
				temp.next = temp.next.next;
			p = p.next;
		}
	 
		return newHead;
	}
	
	

}

class RandomListNode{
	int label;
	RandomListNode next;
	RandomListNode random;
	
	RandomListNode(int val){this.label = val;} 
}
