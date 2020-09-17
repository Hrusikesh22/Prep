package ds_n_algo.linkedlist.problems;

import ds_n_algo.linkedlist.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		/*head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);*/

		//ListUtils.printInReverseOrder(head);
		
		System.out.print("Before :: ");
		ListUtils.printLinkedList(head);

		//head = reverseListIterative(head);
		reverseListRecurssively(head, null);
		//head = reverseList(head);

		System.out.print("After :: ");
		ListUtils.printLinkedList(newHead);
	}

	public static ListNode reverseListIterative(ListNode head) {

		ListNode prevNode = null;

		while(head != null) {
			ListNode currNext = head.next;
			head.next = prevNode;
			prevNode = head;
			head = currNext;
		}  
		
		head = prevNode; //IMP: At the end head=null and prevNode is the new head.
		return head;
	}
	
	static ListNode newHead = null;
	public static void reverseListRecurssively(ListNode head, ListNode prevNode) {
		
		if(head == null) 
			return;
		
		if(head.next != null) {
			reverseListRecurssively(head.next, head);
		} else {
			newHead = head;//Last one is the new head; 
		}
		
		if(prevNode != null) prevNode.next = null;
		
		head.next = prevNode;
	}


	//copy-paste recursive approach
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
	    ListNode p = reverseList(head.next);
	    head.next.next = head;
	    head.next = null;
	    return p;
	}
}
