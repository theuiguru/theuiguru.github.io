/*Team 2 LoginInterface class (Tope Adelegan, David Bonilla, Chris Thomas)
 * loginInterface.java (client class)
 * Created by Tope Adelegan
*/
import java.util.*;

public class LoginInterface
{
	public static Account login()
	{
	  	Scanner scan = new Scanner( System.in);
	  	String username;
		System.out.println("Enter Username");
		username = scan.next();
		Account a = JUser.search(username);
		if(a == null)
		{
			System.out.println("Invalid Login");
			return null;
		}
		else
		{
			System.out.println("Enter password: ");
			String password = scan.next();
			if( !password.equals(a.getPassword()) )
			{
				System.out.println("Invalid Login");
				return null;
			}
			return a;
		}
	}
}