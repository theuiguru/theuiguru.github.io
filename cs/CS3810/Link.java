/**
 * CS3810 Data Structures and Algorithms
 * Assignment 4
 * Author: Chris Thomas
 * Description: This program is for displaying the student's name and id account.
 */
public class Link {
	public Student student;
	public Link next;
	public Link previous;
    public Link(Student s) {
    	student = s;
    }
}