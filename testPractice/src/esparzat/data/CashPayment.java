package esparzat.data;

import java.math.BigDecimal;

/**
 * This class is used for Cash payments. It references the Payment class.
 */

public class CashPayment extends Payment
{
	public CashPayment(BigDecimal amount, String paymentMethod)
	{
		super(amount, paymentMethod);
	}
}