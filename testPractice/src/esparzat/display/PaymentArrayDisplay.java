package esparzat.display;

import java.math.BigDecimal;
import java.util.List;

import esparzat.data.Payment;

public class PaymentArrayDisplay {

	public static void printPayments(List<Payment> payments) {

		System.out
				.println("+---------------------------------------------------------+");
		int i = 0;
		for (Payment payment : payments) {
			String paymentMethod = payment.getPaymentMethod();
			BigDecimal amount = payment.getAmount();
			System.out.println((i + 1) + "   Payment Method " + paymentMethod
					+ "          Payment Amount " + amount);
			i++;
		}
		System.out
				.println("+---------------------------------------------------------+");

	}
}