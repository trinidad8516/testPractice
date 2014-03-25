package esparzat.data;

import java.math.BigDecimal;

/**
 * This class is used for credit card payments. It references the Payment class.
 */

public class CreditPayment extends Payment
{
	private String cardNum;
	private String expirationDate;

	public CreditPayment(BigDecimal amount, String paymentMethod, String cardNum, String expirationDate)
	{
		super(amount, paymentMethod);
		this.cardNum = cardNum;
		this.expirationDate = expirationDate;
	}

	/**
	 * This is the getter for the variable of cardNum which will be the
	 * credit card number.
	 *
	 * @return cardNum returns card number.
	 */
	public String getCardNum()
	{
		return cardNum;
	}

	/**
	 * This is the setter for the variable of cardNum,
	 * which will be the credit card number
	 *
	 * @param cardNum is the credit card number.
	 */
	public void setCardNum(String cardNum)
	{
		this.cardNum = cardNum;
	}

	/**
	 * This is the getter for the variable of credit card expiration date,
	 * which will be used when implementing payments.
	 *
	 * @return expirationDate returns the credit card expiration date.
	 */
	public String getExpirationDate()
	{
		return expirationDate;
	}

	/**
	 * This the setter for the variable of credit card expiration date,
	 * which will be used when implementing payments.
	 *
	 * @param expirationDate is the credit card expiration date.
	 */
	public void setExpirationDate(String expirationDate)
	{
		this.expirationDate = expirationDate;
	}

	public CreditPayment(BigDecimal amount, String paymentMethod)
	{
		super(amount, paymentMethod);
	}
}