package esparzat.display;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import esparzat.data.ExtractProductsandInventory;
import esparzat.data.Product;

/**
 * This is the class that creates the invoice array list. It validates that the
 * UPC entered is in the ExtractProductsandInventory class and then prompts for
 * the amount desired. Ultimately it should also take the quantity based on what
 * is available. This class was originally created in the Murach Java book in
 * chapter 12. I modified it as I saw fit.
 */

public class InvoiceApp {

	public static Map<Product, Integer> invoice = new HashMap<>();
	private static int invoiceSize = 0;
	private static String lastUpc = null;

	// int quantity = 1;
	// public int quantityPurchased = 0;

	/**
	 * This method is used to add products to the invoice arrayList. It checks
	 * to see if the UPC exists in the ExtractProductsandInventory and if does
	 * adds it to the arrayList.
	 */

	public static void addDisplay() {

		boolean isValid = false;

		while (!isValid) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter a UPC code: ");
			String upc = sc.nextLine();

			if (upc == null || upc.isEmpty()) {
				if (lastUpc == null) {
					System.out.println("Error: No UPC provided.");

				} else {
					upc = lastUpc;
					System.out.println("Your UPC has defaulted to your last "
							+ "used UPC " + lastUpc);
				}
			}

			for (Product p : ExtractProductsandInventory.prod) {
				if (p.getUpc().equals(upc)) {
					lastUpc = upc;
					askForQuantity();

					Integer quantity;
					String s = sc.nextLine();
					if (s != null && InvoiceApp.isInteger(s)) {
						quantity = Integer.valueOf(s);
					} else {
						quantity = 1;
					}

					Integer invoiceQuantity = invoice.get(p);
					if (invoiceQuantity != null) {

						quantity += invoice.get(p);

						invoice.put(p, quantity);
					}
					invoice.put(p, quantity);
					InvoiceDisplay.printInvoice(invoice);
					InitialSalesDisplay.initialDisplay();
				}

			}
			System.out
					.println("Error! The UPC code was not found in add display.");
			addDisplay();
		}

	}

	/**
	 * This method is used to remove products from the invoice arrayList. It
	 * checks to see if the UPC exists in the ExtractProductsandInventory and if
	 * does removes it from the arrayList.
	 */

	public static void removeDisplay() {

		boolean isValid = false;

		while (!isValid) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter a UPC code: ");
			String upc = sc.nextLine();

			if (upc == null || upc.isEmpty()) {
				if (lastUpc == null) {
					System.out.println("Error: No UPC provided.");

				} else {
					upc = lastUpc;
					System.out.println("Your UPC has defaulted to your last "
							+ "used UPC " + lastUpc);
				}
			}

			for (Product p : ExtractProductsandInventory.prod) {
				if (p.getUpc().equals(upc)) {
					lastUpc = upc;
					askForQuantity();
					Integer quantity;
					String s = sc.nextLine();
					if (s != null && InvoiceApp.isInteger(s)) {
						quantity = Integer.valueOf(s);
					} else {
						quantity = 1;
					}

					Integer invoiceQuantity = invoice.get(p);
					while (invoiceQuantity != null) {
						if (quantity < invoiceQuantity) {
							invoiceQuantity -= quantity;
							invoice.put(p, invoiceQuantity);

						}

						else if (quantity == invoiceQuantity) {
							invoice.remove(p);
							invoiceSize = 0;

						} else {
							invoice.put(p, 0);
							invoice.remove(p);
						}
						InvoiceDisplay.printInvoice(invoice);
						InitialSalesDisplay.initialDisplay();
					}
					System.out.println("The invoice is currently empty.");
					InitialSalesDisplay.initialDisplay();
				}

			}
			System.out
					.println("Error! The UPC code was not found in remove display.");
			removeDisplay();
		}

	}

	/**
	 * This method as the user how many of a product a customer will be
	 * purchasing.
	 */

	public static void askForQuantity() {
		System.out.print("Enter the quantity for purchase: ");
	}

	/**
	 * This is the getter for the invoice total based on all the items added or
	 * removed from the invoice.
	 * 
	 * @return invoiceTotal This is the total price of all products on the
	 *         invoice.
	 */

	public BigDecimal getInvoiceTotal() {

		BigDecimal invoiceTotal = new BigDecimal(0);
		for (Product lineItem : invoice.keySet()) {
			invoiceTotal.add(lineItem.getPrice());
		}
		return invoiceTotal;
	}

	/**
	 * This formats the invoice total to currency format for readability.
	 * 
	 * @return getInvoiceTotal in a readable currency format.
	 */

	public String getFormattedTotal() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(this.getInvoiceTotal());
	}

	/**
	 * This method checks to see if a string entered is a integer. Found this
	 * method on stackoverflow so I could use it for
	 * 
	 * @param s
	 *            String s is the user input for the quantity.
	 * @return This returns a boolean.
	 */

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

}
