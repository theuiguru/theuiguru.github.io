/**
 * CS3810 Data Structures and Algorithms
 * Assignment 5
 * Author: Chris Thomas
 * Description: This class is designed as application class to implement a hash table to store clients' information.
 */
import java.util.Scanner;
import java.io.*;
import java.io.RandomAccessFile;
public class ExternalHashing {
	public static void main(String[] args) {
		RandomAccessFile f = null;
		String id = "";
		String name = "";
		int option = 0;
		int tableSize = 0;
		int blockSize = 0;
		int key = 0;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What size will the hash table be? ");
		tableSize = keyboard.nextInt();
		System.out.print("How many blocks (Records) in each element will there be? ");
		blockSize = keyboard.nextInt();

		IndexHashTable newTable = new IndexHashTable(tableSize, blockSize);
		while(option != 4) {
			try {
				f = new RandomAccessFile("newfile.txt", "rw");
				f.setLength(tableSize * blockSize * 40);
			}
			catch (IOException e) {
				System.out.println("Error\n" + e);
			}
			System.out.println("");
			System.out.println("Please select from the following menu:");
			System.out.println("1. Add");
			System.out.println("2. Remove");
			System.out.println("3. Search");
			System.out.println("4. Quit");
			System.out.println("");
			option = keyboard.nextInt();

			if(option == 1) {
				keyboard.nextLine();
				System.out.println("");
				System.out.print("Please enter the name of the client: ");
				name = keyboard.nextLine();
				System.out.print("Please enter the client's ID: ");
				id = keyboard.nextLine();
				Record rec = new Record(name, id);

				switch(newTable.insert(f, rec))
  				{
					case 0:
						System.out.println("The insertion of client " + rec + " \nwas successful.");
						break;
					case 1:
						System.out.println("\nThe client with the ID " + rec.getId() + " already exists please enter a different ID#.");
						break;
					case -1:
						System.out.println("The file has run out of space.");
						break;
				}
			}

			else if(option == 2) {
				keyboard.nextLine();
				System.out.println("");
				System.out.print("Please enter the client's ID you wish to remove: ");
				id = keyboard.nextLine();
				Record temp = new Record();
				temp = newTable.search(f, id);

				switch(newTable.delete(f, id))
  				{
					case 0:
						System.out.println("\nYour selection: " + temp + " \nhas been deleted.");
						break;
					case -1:
						System.out.println("\nI'm sorry, but that student ID does not exist.");
						break;
				}
			}

			else if(option == 3) {
				keyboard.nextLine();
				System.out.println("");
				System.out.print("Please enter the client's ID you wish to search for: ");
				id = keyboard.nextLine();
				if(newTable.search(f, id) == null) {
					System.out.println("\nSorry but that student ID does not exist.");
				}
				else {
					System.out.println("\nThe client you are looking for is: " + newTable.search(f, id));
				}
			}

			else if(option == 4) {
				System.out.println("");
				System.out.println("You have now quit the program. Thank You!");
			}

			else if(option < 1 || option > 4) {
				System.out.println("");
				System.out.println("That is an invalid option, please enter a number between 1 and 4");
			}
		}
		System.out.println("");
	}
}