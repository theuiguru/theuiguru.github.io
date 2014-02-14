import java.util.*;
public class MyStack {
	private int maxSize;
	private int top;
	private MyDeque stackArr;

	public MyStack(int s) {
		stackArr = new MyDeque(s);
	}

	public int push(int j) {
		return stackArr.insertFront(j);
	}

	public int pop() {
		return stackArr.removeFront();
	}

	public int peek() {
		return stackArr.peekFront();
	}

	public boolean isEmpty() {
		return stackArr.isEmpty();
	}

	public boolean isFull() {
		return stackArr.isFull();
	}
}