package ds_n_algo.stack;

import java.util.Stack;

/**
 * T.C : O(n^2)
 * S.C : O(n) For Recursion
 * @since 29/09/2020
 *
 */

public class ReverseStackUsingStackOperations {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println("I/P : "+ stack);
		reverseStack(stack);
		System.out.println("O/P : "+ stack);
	}
	
	static void reverseStack(Stack<Integer> stack) {
		
		int top = stack.pop();

		if(!stack.isEmpty()) {
			reverseStack(stack);
		}
		
		insertAtBottom(stack, top);
	}
	
	static void insertAtBottom(Stack<Integer> stack, int item) {

		/*Integer temp = null;
		if(!stack.isEmpty())
			temp = stack.pop();
		
		if(stack.isEmpty())
			stack.push(item);
		else {
			insertAtBottom(stack, item);
		}
		
		if(temp !=null)
			stack.push(temp);*/
		
		if(stack.isEmpty()) {
			stack.push(item);
			return;
		}
		
		int top = stack.pop();
		insertAtBottom(stack, item);
		stack.push(top);
		
	}
}
