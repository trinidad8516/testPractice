package esparzat.data;

import java.math.BigDecimal;

/**
 * This class is used for check payments. It references the Payment class.
 */

public class CheckPayment extends Payment
{
	private String routingNum;
	private String accountNum;
	private String checkNum;

	public CheckPayment(BigDecimal amount, String paymentMethod, String routingNum, String accountNum, String checkNum)
	{
		super(amount, paymentMethod);
		this.routingNum = routingNum;
		this.accountNum = accountNum;
		this.checkNum = checkNum;
	}

	public String getRoutingNum()
	{
		return routingNum;
	}

	public void setRoutingNum(String routingNum)
	{
		this.routingNum = routingNum;
	}

	public String getAccountNum()
	{
		return accountNum;
	}

	public void setAccountNum(String accountNum)
	{
		this.accountNum = accountNum;
	}

	public String getCheckNum()
	{
		return checkNum;
	}

	public void setCheckNum(String checkNum)
	{
		this.checkNum = checkNum;
	}

	public CheckPayment(BigDecimal amount, String paymentMethod)
	{
		super(amount, paymentMethod);
	}
}