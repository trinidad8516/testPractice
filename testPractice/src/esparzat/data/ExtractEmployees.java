package esparzat.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class reads out the content of the employee.txt file to a List. This List then gets referenced as someone
 * verifies what exists in the file.
 */

public class ExtractEmployees
{
	public static List<Employee> employee = new ArrayList<>();

	/**
	 * This method reads out the content of the employee.txt file to list.
	 *
	 * @return employee
	 */
	public static List<Employee> readEmployeeFile()
	{

		File f = new File("Employee.txt");

		Scanner sc = null;

		try
		{
			sc = new Scanner(f);
		} catch (FileNotFoundException e)
		{
			System.out.println("Could not open file.");
		}

		while (sc.hasNextLine())
		{
			Employee e = new Employee();
			String in = sc.nextLine();
			//System.out.println(in);
			String[] fields = in.split("\t", -1);
			e.setUsername(fields[1]);
			e.setPassword(fields[2].toCharArray());
			e.setAccessLevel(fields[0]);
			//System.out.println("Username: " + fields[1]);
			//System.out.println("Password: " + fields[2]);
			//System.out.println("Access Level: " + fields[0]);
			employee.add(e);

		}

		return employee;

	}
}