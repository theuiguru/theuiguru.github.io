/* Using MyDeque class, to print a sorted deque. */
import java.util.*;
public class MyDequeApp {
	public static void main(String[] args) {
		System.out.print("Enter a number to determine the size of the deque: ");
		Scanner keyboard = new Scanner(System.in);
		MyDeque deque = new MyDeque(keyboard.nextInt());
		String action, quit;
		quit = "Quit";
		System.out.println("Enter a following number to operate: \n'1' to insert to front \n'2' to insert to rear \n'3' to remove from front \n'4' to remove from rear \n'5' to peek front \n'6' to peek rear \nOr Quit the program when finished and display deque.");
		do {
			System.out.println("Enter a number to perform an operation: ");
			action = keyboard.next();
			char option = action.charAt(0);
			switch(option) {
				case '1':
					if(!deque.isFull()) {
						System.out.println("Enter a value to insert to front:");
						deque.insertFront(keyboard.nextInt());
					}
					else
						System.out.println("The deque is now full.");
					break;
				case '2':
					if(!deque.isFull()) {
						System.out.println("Enter a value to insert to rear:");
						deque.insertRear(keyboard.nextInt());
					}
					else
						System.out.println("The deque is now full.");
					break;
				case '3':
					if(!deque.isEmpty()) {
						System.out.println("You have removed the following from the front:" + deque.removeFront());
					}
					else
						System.out.println("The deque is now empty.");
					break;
				case '4':
					if(!deque.isEmpty()) {
						System.out.println("You have removed the following from the rear:" + deque.removeRear());
					}
					else
						System.out.println("The deque is now empty.");
					break;
				case '5':
					if(!deque.isEmpty()) {
						System.out.println("The top of the stack is" + deque.peekFront());
					}
					else
						System.out.println("There are none elements to display.");
					break;
				case '6':
					if(!deque.isEmpty()) {
						System.out.println("The top of the stack is" + deque.peekRear());
					}
					else
						System.out.println("There are none elements to display.");
					break;
				default:
					System.out.println("Here is your displayed deque in order:\n" + deque);
					break;
			}
		} while(!(quit.equalsIgnoreCase(action)));
	}
}