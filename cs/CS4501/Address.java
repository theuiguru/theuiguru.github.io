/*Team 2 address class (Tope Adelegan, David Bonilla, Chris Thomas)
 * Address.java
 * Created by David Bonilla
*/
//David Bonilla
import java.util.*;
import java.util.Date;

public class Address
{
	private String street;
	private String city;
	private String state;
	private String zipCode;

	public Address(String Street, String City, String State, String ZipCode)
	{
		street = Street;
		city = City;
		state = State;
		zipCode= ZipCode;
	}

	private String getStreet()
	{
		return street;
	}

	private void setStreet(String newStreet)
	{
		street = newStreet;
	}

	private String getCity()
	{
		return city;
	}

	private void setCity(String newCity)
	{
		city = newCity;
	}

	private String getState()
	{
		return state;
	}

	private void setState(String newState)
	{
		state = newState;
	}

	private String getZipCode()
	{
		return zipCode;
	}

	private void setZipCode(String newZipCode)
	{
		zipCode = newZipCode;
	}
}