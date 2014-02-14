/* Team 2 (Tope Adelegan, David Bonilla, Chris Thomas)
 * AccountManagement.java is extended from Account.java
 * loginStaff(); use case functions will share the same as the following search function.
 * Created by Chris Thomas
*/
import java.util.*;
import java.util.Date;

public class AccountManagement //extends Account
{
	private String email;

	//registerStaff(); To create new staff accounts, the administrators log in with their ID and password in order to create new accounts for their staff.
	public String registerStaff()
	{
		UserAccount user;
		//user = JUser.insert();
		return user;
	}

	//searchStaff(); To glance through all staff accounts, administrators or staff logs into the system and type in specified accounts to view and browse.
	public String searchStaff()
	{
		UserAccount user;
		//user = JUser.search();
		return user;
	}

	//removeStaff(); In order to remove a staff account, the administrators log into the system and can have access to delete specified staff accounts.
	public String removeStaff()
	{
		UserAccount user;
		//user = JUser.delete();
		return user;
	}
}