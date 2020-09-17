package ds_n_algo.linkedlist.problems;

import ds_n_algo.linkedlist.ListNode;

public class ListUtils {
	
	/**
	 *  LIST TRAVERSAL SOLUTION
	 */
	public static void printLinkedList(ListNode head) {

		String listAsStr = "";
		
		ListNode tempNode = head;
		while(tempNode != null) {
			listAsStr += tempNode.data+"->";
			tempNode = tempNode.next;
		}
		System.out.println(listAsStr);
	}
	
	public static void printInReverseOrder(ListNode head) {
		
		if(head == null) 
			return;
		
		printInReverseOrder(head.next);
		
		System.out.print(head.data + "->");
	}
}
