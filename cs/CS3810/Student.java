/**
 * CS3810 Data Structures and Algorithms
 * Assignment 4
 * Author: Chris Thomas
 * Description: This program is for displaying the student's name and id account.
 */
 public class Student {
 	String name = "";
 	int id = 0;
 	public Student() {
 		name = "";
 		id = 0;
	}
	public Student(String _name, int _id) {
		name = _name;
		id = _id;
	}
	public String toString() {
		return "Name: " + name + "ID: " + id;
	}
	public boolean equals(Student node) {
		boolean result = false;
		if(this.name.equals(node.name))
			if(this.id == node.id)
				result = true;
		return result;
	}
}