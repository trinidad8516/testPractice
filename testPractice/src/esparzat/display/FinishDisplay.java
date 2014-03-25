package esparzat.display;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import esparzat.data.CashPayment;
import esparzat.data.CheckPayment;
import esparzat.data.CreditPayment;
import esparzat.data.Payment;

import static esparzat.display.PaymentArrayDisplay.printPayments;

/**
 * This class has the display for finishing the processing on a invoice
 * transaction and allowing a customer to pay for their products purchased.
 * 
 * @author Z. Hoffman + modifications by T. Potts
 */

public class FinishDisplay {
	private static List<Payment> payments = new ArrayList<>();

	private static BigDecimal remainingTotal = BigDecimal.valueOf(0);
	private static Scanner sc = new Scanner(System.in);

	/**
	 * This method asks the user which payment method they want to use and then
	 * routes them to the method to complete the process for that payment
	 * method.
	 */
	public static void paymentOptions() {
		System.out
				.print("Would you like to do with a payment? Add/Remove/Exit: ");
		String addOrRemovePayment = sc.nextLine();
		boolean successful = false;

		while (!successful) {
			switch (addOrRemovePayment.toUpperCase()) {
			case "ADD":
				System.out.println("You selected to add a payment.");
				successful = true;
				break;
			case "REMOVE":
				System.out.println("You selected to remove a payment.");
				removePayments();
				successful = true;
				break;
			case "EXIT":
				System.out.println("You selected to exit the payment menu.");
				InitialSalesDisplay.initialDisplay();
				break;
			default:
				System.out.print("Please select a valid option.");
				addOrRemovePayment = sc.nextLine();
				successful = false;
			}
		}

		System.out.print("Select a payment option: Cash, Credit, or Check: ");
		String paymentDisplayChoice = sc.nextLine();

		switch (paymentDisplayChoice.toUpperCase()) {
		case "CASH":
			System.out.println("You selected Cash");
			cashSelected();
			break;
		case "CREDIT":
			System.out.println("You selected Credit");
			creditSelected();
			break;
		case "CHECK":
			System.out.println("You selected Check");
			checkSelected();
			break;
		default:
			System.out.println("Please enter valid payment option.");
			paymentOptions();
			break;
		}

		// Use if you are using Java 6 since it doesn't allow switch statements
		// for strings.
		/*
		 * if (paymentDisplayChoice.equalsIgnoreCase("Cash")) {
		 * System.out.println("You selected Cash"); cashSelected(); }
		 * 
		 * else if (paymentDisplayChoice.equalsIgnoreCase("Credit")) {
		 * System.out.println("You selected Credit");
		 * 
		 * }
		 * 
		 * else if (paymentDisplayChoice.equalsIgnoreCase("Check")) {
		 * System.out.println("You selected Check");
		 * 
		 * } else { System.out.println("Please enter valid payment option.");
		 * paymentOptions(); }
		 */

	}

	/**
	 * This method is just a easy way to ask for the payment amount for each of
	 * the payment methods.
	 */
	public static void askForAmount() {
		System.out.print("Payment Amount: ");
	}

	/**
	 * This method is just a easy way to ask for the credit card number.
	 */
	public static void askForCreditCardNumber() {
		System.out.print("Credit Card Number: ");
	}

	/**
	 * This method is just a easy way to ask for the credit card expiration
	 * date.
	 */
	public static void askForExpirationDate() {
		System.out.print("Expiration Date: ");
	}

	/**
	 * This method is a easy way to ask for the account number for the check
	 * payment method.
	 */
	public static void askForAccountNumber() {
		System.out.print("Account Number: ");
	}

	/**
	 * This method is a easy way to ask for the routing number for the check
	 * payment method.
	 */
	public static void askForRoutingNumber() {
		System.out.print("Routing Number: ");
	}

	/**
	 * This method is a easy way to ask for the check number for the check
	 * payment method.
	 */
	public static void askForCheckNumber() {
		System.out.print("Check Number: ");
	}

	/**
	 * This method is a easy way to say the transaction is complete.
	 */
	public static void transactionComplete() {
		System.out.println("Transaction complete");
	}

	/**
	 * This method ask for the information to complete a cash payment. It asks
	 * for the amount and allows the user to call this method again and add
	 * another cash payment. It also adds a payment to the payment ArrayList, so
	 * the user can remove payments in the future.
	 */
	public static void cashSelected() {
		askForAmount();
		String s = sc.nextLine();
		BigDecimal cashAmt;
		cashAmt = BigDecimal.valueOf(Double.parseDouble(s));

		if (payments == null || payments.isEmpty()) {

			if (s == null || s.isEmpty()) {
				System.out.println("Error: Please enter a valid cash amount.");
				cashSelected();
			}
			if (cashAmt.compareTo(InvoiceDisplay.getTotal()) < 0) {
				payments.add(new CashPayment(cashAmt, "CASH"));
				calculateIncompleteTotal(cashAmt);
			}
		} else {
			if (s == null || s.isEmpty()) {
				System.out.println("Error: Please enter a valid cash amount.");
				cashSelected();
			}

			else if (cashAmt.compareTo(remainingTotal) <= 0) {
				payments.add(new CashPayment(cashAmt, "CASH"));
				calculateTotalAndFinish(cashAmt);
			}

		}
	}

	/**
	 * This method asks for the information to complete a check payment. It asks
	 * for the routing number, account number, check number, and amount. It also
	 * adds a payment to the payments ArrayList so payments can be removed in
	 * the future.
	 */
	public static void checkSelected() {
		askForRoutingNumber();
		String t = sc.nextLine();
		Long routingNum;

		try {
			routingNum = Long.parseLong(t);
			System.out.println("Routing Number: " + routingNum);
		} catch (NumberFormatException nfe) {
			System.out.println("Error: Please enter a valid routing number.");
			checkSelected();
		}

		askForAccountNumber();
		String u = sc.nextLine();
		Long accountNum;

		try {
			accountNum = Long.parseLong(u);
			System.out.println("Account Number: " + accountNum);
		} catch (NumberFormatException nfe) {
			System.out.println("Error: Please enter a valid routing number.");
			checkSelected();
		}

		askForCheckNumber();
		String v = sc.nextLine();
		Integer checkNum;

		try {
			checkNum = Integer.parseInt(v);
			System.out.println("Check Number: " + checkNum);
		} catch (NumberFormatException nfe) {
			System.out.print("Error: Please enter a valid check number.");
			checkSelected();
		}

		askForAmount();
		String s = sc.nextLine();
		BigDecimal checkAmt;
		checkAmt = BigDecimal.valueOf(Double.parseDouble(s));
		if (payments == null || payments.isEmpty()) {
			if (s == null || s.isEmpty()) {
				System.out
						.println("Error: Please enter a valid check payment amount.");
				checkSelected();
			}
			if (checkAmt.compareTo(InvoiceDisplay.getTotal()) < 0) {
				calculateIncompleteTotal(checkAmt);
			}
		} else {
			if (s == null || s.isEmpty()) {
				System.out.println("Error: Please enter a valid cash amount.");
				checkSelected();
			}

			else if (checkAmt.compareTo(remainingTotal) <= 0) {
				payments.add(new CheckPayment(checkAmt, "CHECK"));
				calculateTotalAndFinish(checkAmt);
			}
		}
	}

	private static void calculateIncompleteTotal(BigDecimal paymentAmount) {
		if (paymentAmount.compareTo(InvoiceDisplay.getTotal()) < 0) {
			remainingTotal = InvoiceDisplay.getTotal().subtract(paymentAmount);
			// System.out.println(remainingTotal);
			printPayments(payments);
			if (remainingTotal.compareTo(BigDecimal.ZERO) > 0) {
				System.out.println("The remaining amount due: "
						+ remainingTotal);
				System.out.println();
				paymentOptions();
			} else {
				transactionComplete();
				System.exit(0);
			}
		}
	}

	/**
	 * This method asks for the information to complete a credit card payment.
	 * It asks for the credit card number, expiration date, and amount. It also
	 * adds a payment to the payments ArrayList so a payment can be removed
	 * later.
	 */
	public static void creditSelected() {
		askForCreditCardNumber();
		String t = sc.nextLine();
		Long creditCardNum;

		try {
			creditCardNum = Long.parseLong(t);
			System.out.println("Credit Card Number: " + creditCardNum);
		} catch (NumberFormatException nfe) {
			System.out
					.println("Error: Please enter a valid credit card number.");
			creditSelected();
		}

		askForExpirationDate();
		String u = sc.nextLine();
		Integer expirationDate;

		try {
			expirationDate = Integer.parseInt(u);
			System.out.println("Expiration Date: " + expirationDate);
		} catch (NumberFormatException nfe) {
			System.out.println("Error: Please enter a valid expiration date.");
			creditSelected();
		}

		askForAmount();
		String s = sc.nextLine();
		BigDecimal creditCardAmt;
		creditCardAmt = BigDecimal.valueOf(Double.parseDouble(s));
		if (payments == null || payments.isEmpty()) {
			if (s == null || s.isEmpty()) {
				System.out
						.println("Error: Please enter a valid credit payment amount.");
				creditSelected();
			}
			if (creditCardAmt.compareTo(InvoiceDisplay.getTotal()) < 0) {
				calculateIncompleteTotal(creditCardAmt);
			}
		} else {
			if (s == null || s.isEmpty()) {
				System.out.println("Error: Please enter a valid cash amount.");
				creditSelected();
			}

			else if (creditCardAmt.compareTo(remainingTotal) <= 0) {
				payments.add(new CreditPayment(creditCardAmt, "CREDIT"));
				calculateTotalAndFinish(creditCardAmt);

			}
		}
	}

	/**
	 * This method is written for all the code that was being duplicated for all
	 * the payment types to do the comparisons on the remaining total and how
	 * much has been paid already.
	 * 
	 * @param creditCardAmt
	 */
	private static void calculateTotalAndFinish(BigDecimal creditCardAmt) {
		remainingTotal = remainingTotal.subtract(creditCardAmt);
		System.out.println(remainingTotal);
		printPayments(payments);
		if (remainingTotal.compareTo(BigDecimal.ZERO) > 0) {
			System.out.println("The remaining amount due: " + remainingTotal);
			paymentOptions();

		} else {
			transactionComplete();
			System.exit(0);
		}
	}

	/**
	 * This method is written to remove the payment from the payment arraylist
	 * based on the user input.
	 */
	private static void removePayments() {
		printPayments(payments);

		System.out.print("Select a payment number to remove: ");
		Number paymentNum = Integer.parseInt(sc.nextLine()) - 1;

		payments.remove(payments.get(paymentNum.intValue()));

		printPayments(payments);
		paymentOptions();
	}
}