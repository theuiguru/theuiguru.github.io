/* Team 2 (Tope Adelegan, David Bonilla, Chris Thomas)
 * userAccount.java is extended from Account.java
 * loginUser(); use case functions will share the same as the following search function.
 * Created by Chris Thomas
*/
import java.util.*;
import java.util.Date;

public class UserAccount extends Account //extends from accounts and logs in user
{
	private String phone;
	private Address address;
	private CreditCard creditCard;

	//Public Constructor
	public UserAccount(String firstName, String lastName, String email, String password, Address address, CreditCard creditcard, String phone)
	{
		super(firstName, lastName, email, password);
		this.phone = phone;
		this.address = address;
		this.creditCard = creditcard;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String newPhone)
	{
		phone = newPhone;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address newAddress)
	{
		address = newAddress;
	}

	/*Registers user into user database. Before payment, a user is required to log in.
	A new user is required to register by providing personal and new login information.
	The user account information will be displayed for an old customer once he/she logged in.
	A user must have a unique login username and must create name and password by following the rule given by the client.*/
	public boolean registerUser()
	{
		return true;
	}

	//editUser(); Allows user to update personal information, and change their password.
	public boolean editUser()
	{
		return true;
	}

	//searchUser(); Allows administrators to query user accounts. Also, to browse and view all user accounts.
	public boolean searchUser()
	{
		return true;
	}

	//removeUser(); To remove a user account for a user, who has been inactive for a time period (defined by client).
	public boolean removeUser()
	{
		return true;
	}
}