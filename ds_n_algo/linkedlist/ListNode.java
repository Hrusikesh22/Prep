package ds_n_algo.linkedlist;

public class ListNode {

	public int data;
	public ListNode next;
	
	public ListNode(int data) {
		this.data = data;
	}

	public ListNode(int data, ListNode next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public String toString() {
		return "ListNode [data=" + data + ", next=" + next + "]";
	}
}
