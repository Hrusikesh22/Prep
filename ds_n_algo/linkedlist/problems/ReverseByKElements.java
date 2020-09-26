package ds_n_algo.linkedlist.problems;

import java.util.List;

import org.omg.CORBA.Current;

import ds_n_algo.linkedlist.ListNode;

/**
 * I/P: 1->2->3->4->5->6->7->8->9--N
 * O/P: 2->1->4->3->6->5->8->7->9--N 	(If k=2)
 * O/P: 3->2->1->6->5->4->9->8->7--N 	(If k=3)
 * O/P: 5->4->3->2->1->9->8->7->6--N 	(If k=5)
 * @since 21/09/2020
 */
public class ReverseByKElements {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1), node2 = new ListNode(2), node3 = new ListNode(3);
		ListNode node4 = new ListNode(4), node5 = new ListNode(5), node6 = new ListNode(6);
		ListNode node7 = new ListNode(7), node8 = new ListNode(8), node9 = new ListNode(9);
		ListNode head = node1;
		node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5;
		node5.next = node6; node6.next = node7; node7.next = node8; node8.next = node9;
		
		head = reverse(head, 3); 
		
		ListUtils.printLinkedList(head);
	}
	
	public static ListNode reverse(ListNode head, int k) {
		ListNode current = head; 
		ListNode next = null; 
		ListNode prev = null; 

		int count = 0; 

		/* Reverse first k nodes of linked list */
		while (count < k && current != null)  
		{ 
			next = current.next; 
			current.next = prev; 
			prev = current; 
			current = next; 
			count++; 
		} 

		/* next is now a pointer to (k+1)th node  
	          Recursively call for the list starting from current. 
	          And make rest of the list as next of first node */
		if (next != null)  
			head.next = reverse(next, k); 

		// prev is now head of input list 
		return prev; 
	}
	
	/*
	 * Below is iterative approach. Incomplete (as corner cases not handled)
	 * But idea is something like this. Doable, but not intuitive. Hence recursive is better.
	 */
	public static void reverseInGroupByK(ListNode head, int k) {
		
		ListNode startNode = head; 
		ListNode prevNode = head;
		
		boolean isFirstCycle = true;
		
		while(startNode != null) {
			ListNode curr = prevNode.next;
			for(int i =1; (i<k && curr != null); i++) {//Starting from 1th node
				ListNode tempNode = curr.next;
				prevNode.next = null;
				curr.next = prevNode;
				prevNode = curr;
				curr = tempNode;
			}
			startNode.next = getNextGroupStart(curr, k);
			startNode = prevNode = curr;
			
			if(isFirstCycle) {
				head = startNode; isFirstCycle = false;
			}
		}
	}
	
	private static ListNode getNextGroupStart(ListNode startNode, int k) {
		if(startNode == null || startNode.next == null)
			return startNode;
		
		while(k>1 && startNode.next != null) {
			startNode = startNode.next;
			k--;
		}
		return startNode; 
	}

}
