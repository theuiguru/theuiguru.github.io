/* Using MyStack class, to print a sorted stack. */
import java.util.*;
public class MyStackApp {
	public static void main(String[] args) {
		System.out.print("Enter a number to determine the size of the stack: ");
		Scanner keyboard = new Scanner(System.in);
		MyStack stack = new MyStack(keyboard.nextInt());
		String action, quit;
		quit = "Quit";
		System.out.println("Enter a number: \n'1' to push \n'2' to pop \n'3' to peek \nOr Quit the program when finished.");
		do {
			System.out.println("Enter a number to perform an operation: ");
			action = keyboard.next();
			char option = action.charAt(0);
			switch(option) {
				case '1':
					if(!stack.isFull()) {
						System.out.println("Enter a value to push in stack: ");
						stack.push(keyboard.nextInt());
					}
					else
						System.out.println("The stack is full at the moment.");
					break;
				case '2':
					if(!stack.isEmpty()) {
						System.out.println("You have popped out the value " + stack.pop() + "from top of stack.");
					}
					else
						System.out.println("The stack is now empty.");
					break;
				case '3':
					if(!stack.isEmpty()) {
						System.out.println("The top of the stack is " + stack.peek());
					}
					else
						System.out.println("There are none elements at this time to display.");
					break;
				default:
					System.out.println("Here is your displayed stack in order:\n" + stack);
					break;
			}
		} while(!(quit.equalsIgnoreCase(action)));
	}
}