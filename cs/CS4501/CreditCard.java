/*Team 2 address class (Tope Adelegan, David Bonilla, Chris Thomas)
 * creditCard.java
 * Created by Tope Adelegan
*/
import java.util.*;
import java.util.Date;

public class CreditCard
{
	private CreditCard expDate;
	private CreditCard creditCardNo;

	public CreditCard(String creditcardnumber,String aExpDate)
	{
		creditCardNo = creditcardnumber;
		expDate = aExpDate;

	}

	private CreditCard getExpDate()
	{
		return expDate;
	}

	private void setExpDate(String newExpDate)
	{
		expDate = newExpDate;
	}

	private CreditCard getCreditCardNumber()
	{
		return creditCardNo;
	}

	private void setCreditCardNo (String newCreditCardNo)
	{
		creditCardNo = newCreditCardNo;
	}
}