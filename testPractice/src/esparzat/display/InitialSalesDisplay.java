package esparzat.display;

import java.util.Scanner;

/**
 * This class shows the initial sales display options and asks do you want to
 * add, remove, or exit. Based on their selection it takes them to classes
 * that will provide that option.
 */

public class InitialSalesDisplay
{
	private static Scanner sc = new Scanner(System.in);

	/**
	 * This method has code for the initial questions asked in the sales
	 * display. It will route to the next method to complete that action
	 * based on their choice.
	 */

	public static void initialDisplay()
	{
		System.out.print("Would you like to do: Add Sale (Add), Remove Sale (Remove), Finish Sale (Finish), " +
				                 "Management Functions (Management) or Exit?: ");

		String salesDisplayChoice = sc.next();

		switch (salesDisplayChoice.toUpperCase())
		{
			case "ADD":
				System.out.println("You selected Add");
				InvoiceApp.addDisplay();
				break;

			case "REMOVE":
				System.out.println("You selected Remove");
				InvoiceApp.removeDisplay();
				break;

			case "FINISH":
				System.out.println("You selected Finish");
				FinishDisplay.paymentOptions();
				break;

			case "MANAGEMENT":
				System.out.println("You selected management options");
				ManagersDisplay.initialMgrsDisplay();

			case "EXIT":
				System.out.println("You selected Exit.");
				System.out.println("Goodbye.");
				System.exit(0);
				break;

			default:
				System.out.println("Please enter a valid option.");
				initialDisplay();
				break;
		}

//Use if you are using Java 6 since it doesn't allow switch statements for strings.

/*
		if (salesDisplayChoice.equalsIgnoreCase("Add"))
		{
			System.out.println("You selected Add");
			InvoiceApp.addDisplay();
			//invoice.addProduct(product, quantity)
		}
		else if (salesDisplayChoice.equalsIgnoreCase("Remove"))
		{
			System.out.println("You selected Remove");
			InvoiceApp.removeDisplay();
		}
		else if (salesDisplayChoice.equalsIgnoreCase("Finish"))
		{
			System.out.println("You selected Finish");
			FinishDisplay.paymentOptions();
		}
		else if (salesDisplayChoice.equalsIgnoreCase("Exit"))
		{
			System.out.println("You selected Exit.");
			System.out.println("Goodbye.");
			System.exit(0);
		}
		else
		{
			System.out.println("Please enter a valid option.");
			initialDisplay();
		}
*/

	}

}