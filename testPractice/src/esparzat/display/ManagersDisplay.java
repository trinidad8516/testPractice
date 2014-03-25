package esparzat.display;

import java.util.Scanner;

import esparzat.data.Employee;

/**
 * This class has the display options for the managers menu and lets the user
 * input their choice.
 */

public class ManagersDisplay {

	private static Scanner sc = new Scanner(System.in);

	/**
	 * This method has the manager's menu and prompts them to enter in which
	 * option they would like.
	 */
	public static void initialMgrsDisplay() {
		System.out.println("You've entered the Manager's verification.");
		LoginDisplay.username();
		Employee employee = LoginDisplay.getLoggedInEmployee();

		if (employee.getAccessLevel().equalsIgnoreCase("Manager")) {
			System.out
					.print("Would you like Employee Management (Employee), Inventory Management (Inventory), "
							+ "Exit?: ");
			String managersChoice = sc.nextLine();
			switch (managersChoice.toUpperCase()) {
			case "EMPLOYEE":
				System.out.println("You selected Employee Management");
				ManagersDisplay.employeeMenu();
				break;
			case "INVENTORY":
				System.out.println("You selected Remove Employee");
				ManagersDisplay.inventoryMenu();
				break;
			case "EXIT":
				System.out.println();
				InitialSalesDisplay.initialDisplay();
				break;
			default:
				System.out.println("Please enter a valid option.");
				initialMgrsDisplay();
				break;

			}
			InitialSalesDisplay.initialDisplay();
		} else {
			System.out.println("You are not allowed to access this menu.");
			InitialSalesDisplay.initialDisplay();
		}
	}

	public static void employeeMenu() {

		System.out.println("Would you like to Add or Remove an employee?: ");

		String managersChoice = sc.nextLine();

		switch (managersChoice.toUpperCase()) {

		case "ADD":
			System.out.println("You selected Add Employee");
			AddRemoveEmployeesDisplay.addEmployee();
			break;

		case "REMOVE":
			System.out.println("You selected Remove Employee");
			AddRemoveEmployeesDisplay.removeEmployee();
			break;
		case "EXIT":
			System.out.println();
			ManagersDisplay.initialMgrsDisplay();
			break;
		default:
			System.out.println("Please enter a valid option.");
			employeeMenu();
			break;

		}

	}

	public static void inventoryMenu() {

		System.out.println("Would you like to Add or Remove inventory?: ");

		String managersChoice = sc.nextLine();

		switch (managersChoice.toUpperCase()) {

		case "ADD":
			System.out.println("You selected Add Inventory");
			ProductAndInventoryDisplay.addNewProduct();
			break;

		case "REMOVE":
			System.out.println("You selected Remove Inventory");
			ProductAndInventoryDisplay.removeProduct();
			break;
		case "EXIT":
			System.out.println();
			ManagersDisplay.initialMgrsDisplay();
			break;
		default:
			System.out.println("Please enter a valid option.");
			inventoryMenu();
			break;

		}

	}
}