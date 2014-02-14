/**
 * CS3810 Data Structures and Algorithms
 * Assignment 4
 * Author: Chris Thomas
 * Description: This program is designed to contain two links and data elements which are objects of Student.java.
 */
 public class CircularList {
	private Link cursor;
	private int size;
	public CircularList() {
		cursor = null;
		size = 0;
	}
	public boolean isEmpty() {
		return cursor == null;
	}
	public void add(Student s) {
		Link newLink = new Link(s);
		newLink.previous = cursor;
		if(isEmpty()) {
			cursor = newLink;
			cursor.previous = newLink;
		}
		else if(size == 1) {
			newLink.next = cursor;
			cursor.previous = newLink;
		}
		else {
			Link next = cursor.next;
			newLink.next = next;
			next.previous=newLink;
		}
		cursor.next = newLink;
		cursor = newLink;
		size++;
	}
	public Student remove(int key) {
		if(isEmpty()) return null;
		Link point = cursor;
		if(size == 1) {
			cursor = null;
			size=0;
			return point.student;
		} do {
			if(point.student.id == key) {
				Link previous = point.previous;
				Link next = point.next;
				previous.next = point.next;
				next.previous = previous;
				if(point == cursor)
					cursor = point.previous;
					size--;
					return point.student;
			}
			point = point.next;
		} while(point != cursor);
		return null;
	}
	public Student search(int key) {
		if(isEmpty()) return null;
		Link point = cursor;
		do {
			if(point.student.id == key) {
				return point.student;
			}
			point = point.next;
		} while(point != cursor);
		return null;
	}
	public String toString() {
		if(isEmpty()) {
			return "List is Empty";
		}
		String s = "";
		Link point = cursor.next;
		for(int i=0; i<size; i++) {
			s = s + point.student.id + " " + point.student.name +"\n";
			point = point.next;
		} return s;
	}
}