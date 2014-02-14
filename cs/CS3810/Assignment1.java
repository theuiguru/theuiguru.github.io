/*
 * CS3810 Data Structures and Algorithms
 * Assignment 1  Date: 9/9/10
 * Author: Chris Thomas
 * Function Description: The user entering in a list of integers, from the range of 0 to 50, and counts the number of occurrences of each entered.
 */
import java.util.*;
public class Assignment1 {
	public static void main(String[] args) {
		int intArr[] = new int[51];
		Scanner keyboard = new Scanner(System.in);
		int x;
		for (int z=0; z<=50; z++)
		{
			intArr[z] = 0;
		}

		System.out.println("Please enter integers from 0 to 50 or -1 to exit: ");
		x = keyboard.nextInt();

		do {
			if (x >= 0 && x <= 50)
			{
				intArr[x]++;
			}
			System.out.println("Please enter integers from 0 to 50 or -1 to exit: ");
			x = keyboard.nextInt();
		} while (x!=-1);

		for(int y=0; y<=50; y++)
		{
			if (intArr[y] > 0)
				System.out.println("You typed " + y+ " "+intArr[y]+" times.");
		}
	}
}