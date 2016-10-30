package design;

import java.util.Stack;

class MyQueue {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	public MyQueue() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (stack2.isEmpty()) {
        	while (!stack1.isEmpty()) {
        		stack2.push(stack1.pop());
        	}
        }
        
        stack2.pop();
    }

    // Get the front element.
    public int peek() {
        if (stack2.isEmpty()) { 
        	while (!stack1.isEmpty()) {
        		stack2.push(stack1.pop());
        	}
        }
        
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

public class ImplementQueueUsingStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println(queue.peek() == 1);
		queue.pop();
		System.out.println(queue.peek() == 2);
		queue.push(4);
		System.out.println(queue.peek() == 2);
	}

}
