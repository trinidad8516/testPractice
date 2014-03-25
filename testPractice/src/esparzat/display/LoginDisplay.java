package esparzat.display;

import java.util.List;
import java.util.Scanner;

import esparzat.data.Employee;
import esparzat.data.ExtractEmployees;

/**
 * This class is contains the method that prompts the user for their username
 * and password. It contains the hardcoded username and password we are using
 * during the prototyping phase.
 */
public class LoginDisplay {
	private static Employee loggedInEmployee;
	private static String loggedInUsername;

	/**
	 * This method prompts the user to enter their username and then validates
	 * against a hardcoded username during the prototype phase.
	 * 
	 * @return username This is the username of the employee using the program.
	 */

	/*
	 * This method is for getting the input of the username from the user.
	 * Eventually I will need a validator class to call to verify that the
	 * username is 6-12 alphanumeric characters long as per the spec document.
	 */
	public static void username() {
		List<Employee> employee = ExtractEmployees.employee;

		String tempUsername = null;
		String username = "";
		Scanner sc = new Scanner(System.in);

		System.out.println("Login Display");
		System.out.println();

		while (tempUsername == null) {
			System.out.print("Enter your username: ");
			username = sc.nextLine();

			if (username == null || username.isEmpty()) {
				System.out.println("Error! Username is required. Try again.");
			} else if (!username.isEmpty()) {
				for (Employee e : employee) {

					if (e.getUsername().equalsIgnoreCase(username)) {
						// Todo:create temporary username
						tempUsername = String.valueOf(e);
						loggedInUsername = username;
						break;
					}
				}

			}
			if (tempUsername == null) {
				System.out.println("Error! Username doesn't exist. Try again.");
			}
		}
		password();

	}

	/**
	 * This method prompts the user to enter their password and then validates
	 * against the exmployee.txt password.
	 */

	public static void password() {
		List<Employee> employee = ExtractEmployees.employee;
		String password = "";
		String tempPassword = null;
		Scanner sc = new Scanner(System.in);

		while (tempPassword == null) {
			System.out.print("Enter your password: ");
			password = sc.nextLine();

			if (password == null || password.isEmpty()) {
				System.out.println("Error! Password is required.");

			} else if (!password.isEmpty()) {
				for (Employee e : employee) {
					if (e.getUsername().equalsIgnoreCase(loggedInUsername)
							&& String.valueOf(e.getPassword()).equals(password)) {
						System.out.println("Login Successful");
						tempPassword = String.valueOf(e);
						loggedInEmployee = e;
						break;
					}
				}
			}
			if (tempPassword == null) {
				System.out.println("Error! Password is invalid. Try again.");
			}
		}

	}

	/**
	 * This method is used just to return the last logged in employee so I can
	 * use it later to not have to check if a manager is logged in or not.
	 * 
	 * @return loggedInEmployee
	 */
	public static Employee getLoggedInEmployee() {
		return loggedInEmployee;
	}
}