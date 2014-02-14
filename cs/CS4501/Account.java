/* Team 2 (Tope Adelegan, David Bonilla, Chris Thomas)
 * Account.java is the superclass of both userAccount and AccountManagement
 * Created by Chris Thomas
*/
import java.util.*;
import java.util.Date;

public class Account
{
	private String firstName, lastName, email, password;

	public Account(String aFirstName, String aLastName, String aEmail, String aPassword)
	{
		this.firstName = aFirstName;
		this.lastName = aLastName;
		this.email = aEmail;
		this.password = aPassword;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String newFirstName)
	{
		firstName = newFirstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String newLastName)
	{
		lastName = newLastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String newEmail)
	{
		email = newEmail;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String newPassword)
	{
		password = newPassword;
	}
}