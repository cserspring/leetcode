package design;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
	private Queue<Integer> queue1;
	private Queue<Integer> queue2;
	private int last;
	public MyStack() {
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}
	
    // Push element x onto stack.
    public void push(int x) {
        queue1.add(x);
        last = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!queue1.isEmpty()) {
        	while (queue1.size() > 1) {
        		last = queue1.poll();
        		queue2.add(last);
        	}
        	queue1.poll();
        } else {
        	while (queue2.size() > 1) {
        		last = queue2.poll();
        		queue1.add(last);
        	}
        	queue2.poll();
        }
    }

    // Get the top element.
    public int top() {
        return last;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

public class ImplementStackUsingQueues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.pop();
		myStack.push(4);
		myStack.push(5);
		myStack.pop();
		System.out.println(myStack.top());
	}

}
