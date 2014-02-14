import java.util.*;
public class MyDeque {
	private int maxSize;
	private int[] queArr;
	private int front;
	private int rear;
	private int nItems;

	public MyDeque(int s) {
		maxSize = s;
		queArr = new int[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public int insertFront(int j) {
		if (front==0)
			front=maxSize;
		queArr[--front]=j;
		nItems++;
		return j;
	}

	public int insertRear(int j) {
		if (rear==maxSize-1)
			rear=-1;
		queArr[++rear]=j;
		nItems=0;
		return j;
	}

	public int removeFront() {
		int temp = queArr[front++];
		if(front==maxSize)
			front=0;
		nItems--;
		return temp;
	}

	public int removeRear() {
		int temp = queArr[rear--];
		if(rear==-1)
			rear=maxSize-1;
		nItems--;
		return temp;
	}

	public int peekFront() {
		return queArr[front];
	}

	public int peekRear() {
		return queArr[rear];
	}

	public boolean isEmpty() {
		return (nItems==0);
	}

	public boolean isFull() {
		return (nItems==maxSize);
	}

	public String toSring() {
		int i = front;
		String s = "[";
		while(i!=rear+1)
		{
		if(i == maxSize)
		i = 0;
		s = s + queArr[i++]+",";
		}
		s = s.substring(0,s.length()-1);
		return s  +="]";
	}
}