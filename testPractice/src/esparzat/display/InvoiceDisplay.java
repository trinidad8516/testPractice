package esparzat.display;

import java.math.BigDecimal;
import java.util.Map;

import esparzat.data.Payment;
import esparzat.data.Product;

/**
 * This class is the display of the invoice in a readable format. Inspired by
 * the display we did in class.
 */

public class InvoiceDisplay {

	static BigDecimal total;

	/**
	 * This method displays all the items that were entered while using the
	 * InvoiceApp class.
	 * 
	 * @param invoice
	 *            This is the invoice that already has the arrayList of items.
	 */
	public static void printInvoice(Map<Product, Integer> invoice) {

		System.out
				.println("+--------------------------------------------------------"
						+ "-+");
		System.out.println("Item Desc." + "            |" + "Qty" + "    x  "
				+ " " + "" + "Price" + "    |" + "Subtotal");
		System.out
				.println("+---------------------------------------------------------+");
		/*
		 * for (int i = 0; i < invoice.length; i++) {
		 * System.out.println(invoice[i]); }
		 */
		BigDecimal subTotalSum = new BigDecimal(0);

		for (Map.Entry<Product, Integer> entry : invoice.entrySet()) {
			Product product = entry.getKey();
			Integer quantity = entry.getValue();
			String description = product.getDescription();
			BigDecimal price = product.getPrice();
			BigDecimal subtotal = price.multiply(new BigDecimal(quantity));
			System.out.println(description + "    |" + quantity + "          "
					+ "$" + price + "        " + "$" + subtotal);

			subTotalSum = subTotalSum.add(subtotal);

		}
		System.out
				.println("+---------------------------------------------------------+");
		System.out.println("                              " + "Total(Pretax)"
				+ ":" + " " + "$" + subTotalSum);

		BigDecimal taxRateFormatted = Payment.TAX_RATE.setScale(2,
				BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100));
		System.out.println("                                   " + "Tax Rate: "
				+ taxRateFormatted + "%");

		total = subTotalSum.multiply(BigDecimal.valueOf(1.06));
		System.out.println("                                      " + "Total:"
				+ " $" + total);

		System.out
				.println("+---------------------------------------------------------+");
		System.out.println();
	}

	public static BigDecimal getTotal() {
		return total;
	}

	public static void setTotal(BigDecimal total) {
		InvoiceDisplay.total = total;
	}
}