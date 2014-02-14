/*Team 2 address class (Tope Adelegan, David Bonilla, Chris Thomas)
 * creditCard.java
 * Created by Tope Adelegan
*/
import java.util.*;
import java.util.Date;

public class CreditCard
{
	private String expDate;
	private String creditCardNo;

	public CreditCard(String creditcardnumber,String aExpDate)
	{
		creditCardNo = creditcardnumber;
		expDate = aExpDate;

	}

	private String getExpDate()
	{
		return expDate;
	}

	private void setExpDate(String newExpDate)
	{
		expDate = newExpDate;
	}

	private String getCreditCardNumber()
	{
		return creditCardNo;
	}

	private void setCreditCardNo (String newCreditCardNo)
	{
		creditCardNo = newCreditCardNo;
	}
}