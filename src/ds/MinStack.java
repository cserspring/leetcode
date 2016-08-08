package ds;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> _minStack;
	private Stack<Integer> _stack;
	
    /** initialize your data structure here. */
    public MinStack() {
    	_minStack = new Stack<Integer>();
        _stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        _stack.push(x);
        if (_minStack.isEmpty()) {
        	_minStack.push(x);
        } else {
        	int y = _minStack.peek();
        	if (x <= y)
        		_minStack.push(x);
        }
    }
    
    public void pop() {    	
    	int x = _stack.peek();
        _stack.pop();
        if (x == _minStack.peek())
        	_minStack.pop();
    }
    
    public int top() {
        return _stack.peek();        
    }
    
    public int getMin() {
    	return _minStack.peek();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
