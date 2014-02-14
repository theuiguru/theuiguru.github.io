/*Team 2 RegisterInterface class (Tope Adelegan, David Bonilla, Chris Thomas)
 * registerInterface.java (client class)
 * Created by David Bonilla
*/
import java.util.*;
public class RegisterInterface
{
	public static Account register()
	{
		Scanner scan = new Scanner( System.in);

        System.out.println("Please Enter Username: ");
		String uname = scan.next();
		Account a = JUser.search(uname);
		if(a == null)
		{
			System.out.println("Please Enter Your First Name: ");
			String firstName = scan.next();

			System.out.println("Please Enter Your Last Name: ");
			String lastName = scan.next();

			System.out.println("Please Enter Your Desired Password: ");
			String password = scan.next();

			System.out.println("Please Enter Your Street: ");
			String street = scan.next();

			System.out.println("Please Enter Your City: ");
			String city = scan.next();

			System.out.println("Please Enter Your State: ");
			String state = scan.next();

			System.out.println("Please Enter Your Zip Code: ");
			String zipcode = scan.next();

			System.out.println("Please Enter Your Credit Card Number: ");
			String creditCardNumber = scan.next();

			System.out.println("Please Enter Your Credit Card Exp Date: ");
			String creditCardExpDate = scan.next();

			System.out.println("Please Enter Your Phone Number: ");
			String phone = scan.next();

			String newAddress, newCreditCard;
			Address b = new Address(street, city, state, zipcode);
			CreditCard c = new CreditCard(creditCardNumber, creditCardExpDate);
			a = new UserAccount(firstName, lastName, uname, password, b, c, phone);
			if(JUser.insert(a))
			{
				System.out.println("Account Created!");
				return a;
			}
			else
			{
				System.out.println("Internal error could not create account.");
				return null;
			}
		}
		else
		{
			System.out.println("Account Exists!");
			return null;
		}
	}

}