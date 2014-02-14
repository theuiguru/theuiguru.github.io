/**
 * CS3810 Data Structures and Algorithms
 * Assignment 4
 * Author: Chris Thomas
 * Description: This class is designed as the main program.
 */
 import java.util.*;
 public class DataManagement {
 	public static CircularList students = new CircularList();
	public static Scanner keyboard = new Scanner(System.in);
	public static String display() {
		System.out.println("Choose from the following menu:");
		System.out.println("1. Add a Student");
		System.out.println("2. Remove a Student");
		System.out.println("3. Search a Student");
		System.out.println("4. Display Students");
		System.out.println("5. Quit the Program");
		System.out.print("\nEnter your choice: ");
		String option = keyboard.nextLine();
		return option;
	}
	public static void optionChoice(String option) {
	    if(option.equalsIgnoreCase("1")) {
	    	Student s = addStudent();
	    	students.add(s);
	    }
	    else if(option.equalsIgnoreCase("2")) {
	    	int id = addStudentID();
	    	Student s = students.remove(id);
	    	if(s != null) {
	    		System.out.println("Following Student has been removed from the list: ");
	    		displayStudent(s);
	    	}
	    	else
	    		System.out.println("There is no such student.");
	    }
        else if(option.equalsIgnoreCase("3")) {
	    	int id = addStudentID();
	    	Student s = students.remove(id);
	    	if(s != null) {
	    		System.out.println("Here is the current list of the following students:");
	    		displayStudent(s);
	    	}
	    	else
	    		System.out.println("There is no such student.");
	    }
        else if(option.equalsIgnoreCase("4")) {
	    System.out.println("Here are the following students in the list:");
	    System.out.println(students.toString());
	    }
        else if(option.equalsIgnoreCase("5"))
	    {
	    	System.out.println("You have now quit the program. Thank You!");
	    }
	    else System.out.println("Invalid Option");
	}
	public static Student addStudent() {
		Student s = new Student();
		System.out.print("Enter Student Name: ");
		s.name = keyboard.nextLine();
		s.id = addStudentID();
	    return s;
	}
	public static int addStudentID() {
		int id=0;
		do {
			System.out.print("Enter Student ID: ");
			try {
				id = Integer.parseInt(keyboard.nextLine());
			} catch(NumberFormatException ex) {
					System.out.println("Invalid Student ID");
					id = 0;
			}
		} while(id == 0);
		return id;
	}
	public static void displayStudent(Student s) {
		System.out.println("Student name: " + s.name);
		System.out.println("Student id: " + s.id);
	}
	public static void main(String[] args) {
		String option;
		do {
			option = display();
			optionChoice(option);
		} while(!option.equalsIgnoreCase("5"));
	}
}